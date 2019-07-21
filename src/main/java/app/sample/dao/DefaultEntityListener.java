package app.sample.dao;

import java.time.LocalDateTime;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreInsertContext;

import app.sample.entity.DomaDtoImpl;
import app.sample.util.WebSecurityUtils;
import lombok.NoArgsConstructor;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor // コンストラクタが必須のため
@Slf4j
public class DefaultEntityListener<ENTITY> implements EntityListener<ENTITY> {

  @Override
  public void preInsert(ENTITY entity, PreInsertContext<ENTITY> context) {
	  val domaDto = (DomaDtoImpl) entity;
      val createdAt = LocalDateTime.now();
      val createdBy = WebSecurityUtils.getLoginId();
      domaDto.setCreatedAt(createdAt);
      domaDto.setCreatedBy(createdBy);
  }
}
