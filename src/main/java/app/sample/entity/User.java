package app.sample.entity;

import org.seasar.doma.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends DomaDtoImpl {

  private static final long serialVersionUID = 2229749282619203936L;

  // ユーザ名
  String userName;

  // パスワード
  String password;

}
