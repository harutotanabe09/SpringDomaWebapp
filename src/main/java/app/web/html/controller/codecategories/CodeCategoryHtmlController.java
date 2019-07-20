package app.web.html.controller.codecategories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.web.entity.CodeCategory;
import app.web.html.controller.AbstractHtmlController;
import app.web.html.controller.codecategories.form.CodeCategoryForm;
import app.web.service.CodeCategoryService;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * コード分類管理
 */
@Controller
@RequestMapping("/system/code_categories")
// @SessionAttributes(types = { SearchCodeCategoryForm.class, CodeCategoryForm.class })
@Slf4j
public class CodeCategoryHtmlController extends AbstractHtmlController {

    @Autowired
    CodeCategoryFormValidator codeCategoryFormValidator;

    @Autowired
    CodeCategoryService codeCategoryService;

    @ModelAttribute("codeCategoryForm")
    public CodeCategoryForm codeCategoryForm() {
        return new CodeCategoryForm();
    }

    @InitBinder("codeCategoryForm")
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(codeCategoryFormValidator);
    }

    /**
     * 登録画面 初期表示
     *
     * @param form
     * @param model
     * @return
     */
    @GetMapping("/new")
    public String create(@ModelAttribute("codeCategoryForm") CodeCategoryForm form, Model model) {
        if (!form.isNew()) {
            // SessionAttributeに残っている場合は再生成する
            model.addAttribute("codeCategoryForm", new CodeCategoryForm());
        }
        return "modules/system/code_categories/new";
    }

    /**
     * 登録処理
     *
     * @param form
     * @param br
     * @param attributes
     * @return
     */
    @PostMapping("/new")
    public String create(@Validated @ModelAttribute("codeCategoryForm") CodeCategoryForm form, BindingResult br,
            RedirectAttributes attributes, Model model) {
        // 入力チェックエラーがある場合は、元の画面にもどる
        if (br.hasErrors()) {
        	return create(form, model);
        }
        // 入力値からDTOを作成する
        val inputCodeCategory = modelMapper.map(form, CodeCategory.class);
        inputCodeCategory.setCodeCategoryId(100L);
        // 登録
        val createdCodeCategory = codeCategoryService.create(inputCodeCategory);
        log.info(createdCodeCategory + " result --- ");
        setFlashAttributeSuccess(attributes);
        return  "redirect:/system/code_categories/new";
    }
}