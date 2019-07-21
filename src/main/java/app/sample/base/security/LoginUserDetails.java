package app.sample.base.security;

import org.springframework.security.core.authority.AuthorityUtils;

import app.sample.entity.User;
import lombok.Getter;

/** ログイン認証 */
@Getter
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
  private final User user;

  public LoginUserDetails(User user) {
    super(
        user.getUserName(),
        user.getPassword(),
        AuthorityUtils.createAuthorityList("ROLE_USER"));
    this.user = user;
  }
}
