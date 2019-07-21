package app.sample.dao;

import app.sample.entity.User;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface UseDao {

  /**
   * パスワード取得します。
   *
   * @param username
   * @return
   */
  @Select
  User findByName(String username);
}
