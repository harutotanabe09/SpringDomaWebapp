package app.sample.dao;

import app.sample.entity.CodeCategory;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface CodeCategoryDao {

  /**
   * コード分類を登録します。
   *
   * @param CodeCategory
   * @return
   */
  @Insert
  int insert(CodeCategory CodeCategory);
}
