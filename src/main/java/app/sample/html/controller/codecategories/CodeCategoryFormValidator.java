package app.sample.html.controller.codecategories;

import app.sample.base.validator.AbstractValidator;
import app.sample.form.CodeCategoryForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/** コード分類登録 入力チェック */
@Component
public class CodeCategoryFormValidator extends AbstractValidator<CodeCategoryForm> {

  @Override
  protected void doValidate(CodeCategoryForm form, Errors errors) {}
}
