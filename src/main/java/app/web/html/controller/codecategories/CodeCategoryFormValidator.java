package app.web.html.controller.codecategories;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import app.web.base.validator.AbstractValidator;
import app.web.html.controller.codecategories.form.CodeCategoryForm;

/**
 * コード分類登録 入力チェック
 */
@Component
public class CodeCategoryFormValidator extends AbstractValidator<CodeCategoryForm> {

    @Override
    protected void doValidate(CodeCategoryForm form, Errors errors) {

    }
}