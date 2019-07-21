package app.sample.entity;

import app.sample.dao.DefaultEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Entity;
import org.seasar.doma.Transient;

@SuppressWarnings("serial")
@Entity(listener = DefaultEntityListener.class) // 自動的にシステム制御項目を更新するためにリスナーを指定する
@Setter
@Getter
public abstract class DomaDtoImpl implements Serializable {

  // 作成者
  @JsonIgnore String createdBy;

  // 作成日時
  @JsonIgnore LocalDateTime createdAt;

  // 更新者
  @JsonIgnore String updatedBy;

  // 更新日時
  @JsonIgnore LocalDateTime updatedAt;

  // 楽観的排他制御で使用する改定番号
  // @Version
  // @Column(name = "version")
  // @JsonIgnore
  // Integer version;

  // 作成・更新者に使用する値
  @Transient @JsonIgnore String auditUser;

  // 作成・更新日に使用する値
  @Transient @JsonIgnore LocalDateTime auditDateTime;
}
