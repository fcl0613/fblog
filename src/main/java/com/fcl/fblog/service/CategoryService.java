package com.fcl.fblog.service;

import com.fcl.fblog.entity.IndexCategoryVo;
import com.fcl.fblog.entity.LayuiPage;
import com.fcl.fblog.exception.BackendBusinessException;
import com.fcl.fblog.pojo.Category;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CategoryService {
    public void saveCategory(Category category);    //保存分类
    public Category getCategory(Integer id);    //根据id获取对应的分类信息
    public void updateCategory(Category category) throws BackendBusinessException;  //更新分类信息
    public void removeCategory(List<Integer> ids);  //删除分类信息
    public PageInfo<Category> findCategory(LayuiPage layuiPage, String categoryName);   //查询分类信息
    public List<Category> findAll();
    public List<IndexCategoryVo> findTopCategory(Integer limit);
}
