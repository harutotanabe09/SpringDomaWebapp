package app.web.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "code_category")
@Entity
@Getter
@Setter
public class CodeCategory extends DomaDtoImpl {

    private static final long serialVersionUID = 2229749282619203935L;

    // コード分類ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codeCategoryId;

    // カテゴリキー
    String categoryKey;

    // カテゴリ名
    String categoryName;
}