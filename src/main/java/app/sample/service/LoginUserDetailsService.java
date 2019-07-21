package app.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.sample.base.security.LoginUserDetails;
import app.sample.dao.UseDao;
import app.sample.entity.User;

/** ログイン認証サービス */
@Service
public class LoginUserDetailsService implements UserDetailsService {

  @Autowired UseDao userdao;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Bean
  PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }

  @Override
  public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

    String password = "#fe?3d31";
    String digest = passwordEncoder.encode(password);
    System.out.println("ハッシュ値 = " + digest);

	User user = userdao.findByName(loginId);
    if (user == null) {
      throw new UsernameNotFoundException("user not found");
    }
    return new LoginUserDetails(user);
  }
}
