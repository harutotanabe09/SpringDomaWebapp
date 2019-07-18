package app.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import app.web.dao.CodeCategoryDao;
import app.web.entity.CodeCategory;

/**
 * コード分類サービス
 */
@Service
public class CodeCategoryService {

    @Autowired
    CodeCategoryDao codeCategoryDao;

    /**
     * コード分類を追加します。
     *
     * @param inputCodeCategory
     * @return
     */
    public int create(final CodeCategory inputCodeCategory) {
        Assert.notNull(inputCodeCategory, "inputCodeCategory must not be null");
        return codeCategoryDao.insert(inputCodeCategory);
    }

}
