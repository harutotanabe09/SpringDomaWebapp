package app.sample.conf;

import static app.sample.base.WebConst.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import app.sample.base.security.DefaultAccessDeniedHandler;
import app.sample.base.security.DefaultAuthenticationEntryPoint;

/** 基底セキュリティコンフィグ */
public abstract class BaseSecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${application.security.secureCookie:false}")
  Boolean secureCookie;

  @Value("${application.security.tokenValiditySeconds:86400}")
  Integer tokenValiditySeconds;

  @Value("${application.security.tokenPurgeSeconds:2592000}") // 30 days
  Integer tokenPurgeSeconds;

  @Autowired DataSource dataSource;

  @Autowired UserDetailsService userDetailsService;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new PasswordNoEnconder();
	// return new PasswordNoEnconder();
    // return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // 静的ファイルへのアクセスは認証をかけない
    web.ignoring() //
        .antMatchers(WEBJARS_URL, STATIC_RESOURCES_URL);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService) //
        .passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

	// CookieにCSRFトークンを保存する
    http.csrf() //
        .csrfTokenRepository(new CookieCsrfTokenRepository());
    String[] permittedUrls = {
      LOGIN_TIMEOUT_URL,
      FORBIDDEN_URL,
      ERROR_URL,
      NOTFOUND_URL,
      RESET_PASSWORD_URL,
      CHANGE_PASSWORD_URL
    };

    http.authorizeRequests()
        // エラー画面は認証をかけない
        .antMatchers(permittedUrls)
        .permitAll()
        // エラー画面以外は、認証をかける
        .anyRequest()
        .authenticated() //
        .and() //
        .exceptionHandling() //
        .authenticationEntryPoint(authenticationEntryPoint()) //
        .accessDeniedHandler(accessDeniedHandler());

    http.formLogin()
        // ログイン画面のURL
        .loginPage(LOGIN_URL)
        // 認可を処理するURL
        .loginProcessingUrl(LOGIN_PROCESSING_URL)
        // ログイン成功時の遷移先
        .successForwardUrl(LOGIN_SUCCESS_URL)
        // ログイン失敗時の遷移先
        .failureUrl(LOGIN_FAILURE_URL)
        // ログインIDのパラメータ名
        .usernameParameter("loginId")
        // パスワードのパラメータ名
        .passwordParameter("password")
        .permitAll();

    // ログアウト設定
    http.logout() //
        .logoutRequestMatcher(new AntPathRequestMatcher(LOGOUT_URL))
        // ログアウト画面のURL
        .logoutUrl(LOGOUT_URL)
        // ログアウト後の遷移先
        .logoutSuccessUrl(LOGOUT_SUCCESS_URL)
        // セッションを破棄する
        .invalidateHttpSession(true)
        .permitAll();
  }

  @Bean
  public AccessDeniedHandler accessDeniedHandler() {
    return new DefaultAccessDeniedHandler();
  }

  @Bean
  public AuthenticationEntryPoint authenticationEntryPoint() {
    return new DefaultAuthenticationEntryPoint(LOGIN_URL, LOGIN_TIMEOUT_URL);
  }
}
