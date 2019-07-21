package app.sample.dao;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreInsertContext;

@NoArgsConstructor // コンストラクタが必須のため
@Slf4j
public class DefaultEntityListener<ENTITY> implements EntityListener<ENTITY> {

  @Override
  public void preInsert(ENTITY entity, PreInsertContext<ENTITY> context) {}
}
