package com.fcl.fblog.service.impl;

import com.fcl.fblog.common.CodeConstant;
import com.fcl.fblog.common.MessageConstant;
import com.fcl.fblog.entity.IndexCategoryVo;
import com.fcl.fblog.entity.LayuiPage;
import com.fcl.fblog.exception.BackendBusinessException;
import com.fcl.fblog.mapper.CategoryDao;
import com.fcl.fblog.pojo.Category;
import com.fcl.fblog.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    /**
     * 保存分类信息
     * @param category
     */
    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryDao.insertCategory(category);
    }

    /**
     * 根据id获取对应的分类信息
     * @param id
     * @return
     */
    @Override
    public Category getCategory(Integer id) {
        return categoryDao.getCategory(id);
    }

    /**
     * 更新分类信息
     * @param category
     */
    @Override
    @Transactional
    public void updateCategory(Category category) {
        if (category.getId() == null) throw new BackendBusinessException(CodeConstant.FAIL_CODE,
                MessageConstant.PARAMS_ERROR);
        categoryDao.updateCategory(category);
    }

    /**
     * 删除分类信息
     * @param ids
     */
    @Override
    @Transactional
    public void removeCategory(List<Integer> ids) {
        categoryDao.deleteCategory(ids);
    }

    /**
     * 分页查询，模糊查询
     */
    @Override
    public PageInfo<Category> findCategory(LayuiPage layuiPage, String categoryName) {
        PageHelper.startPage(layuiPage.getPage(),layuiPage.getLimit());
        List<Category> categorys = categoryDao.findCategory(categoryName);
        PageInfo<Category> pageInfo = new PageInfo<Category>(categorys);
        return pageInfo;
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findCategory(null);
    }

    @Override
    public List<IndexCategoryVo> findTopCategory(Integer limit) {
        return categoryDao.findTopCategory(limit);
    }
}
