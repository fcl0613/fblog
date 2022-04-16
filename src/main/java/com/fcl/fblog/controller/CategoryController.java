package com.fcl.fblog.controller;

import com.fcl.fblog.common.MessageConstant;
import com.fcl.fblog.entity.LayuiPage;
import com.fcl.fblog.entity.LayuiResult;
import com.fcl.fblog.pojo.Category;
import com.fcl.fblog.service.CategoryService;
import com.fcl.fblog.utils.CommonUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类管理
 */

@RequestMapping("/admin/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 获取全部的分类信息
     * @return
     */
    @GetMapping("/all")
    public LayuiResult findAllCategory(){
        try {
            List<Category> categories = categoryService.findAll();
            return LayuiResult.success(MessageConstant.GET_CATEGORY_SUCCESS, categories, null);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.GET_CATEGORY_FAIL);
        }
    }

    /**
     * 分类的删除
     * @param category
     * @return
     */
    @PutMapping("/update")
    public LayuiResult updateCategory(Category category){
        try {
            categoryService.updateCategory(category);
            return LayuiResult.success(MessageConstant.UPDATE_CATEGORY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.UPDATE_CATEGORY_FAIL);
        }
    }

    /**
     * 分类的删除
     * @param ids
     * @return
     */
    @DeleteMapping("/delete/{ids}")
    public LayuiResult doDeleteCategory(@PathVariable String ids){
        try {
            List<Integer> list = CommonUtils.StringsToList(ids);
            categoryService.removeCategory(list);
            return LayuiResult.success(MessageConstant.DELETE_CATEGORY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.success(MessageConstant.DELETE_CATEGORY_FAIL);
        }
    }

    /**
     * 分类的添加
     * @param category
     * @return
     */
    @PostMapping("/add")
    public LayuiResult doCategoryAdd(Category category){
        try {
            categoryService.saveCategory(category);
            return LayuiResult.success(MessageConstant.SAVE_CATEGORY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.SAVE_CATEGORY_FAIL);
        }
    }

    /**
     * 查询操作
     * @param layuiPage
     * @param searchParams
     * @return
     */
    @GetMapping("/list")
    public LayuiResult findCategoryList(LayuiPage layuiPage,
                                        @RequestParam(value = "searchParams", defaultValue = "") String searchParams){
        try {
            PageInfo<Category> category = categoryService.findCategory(layuiPage, searchParams);
            long total = category.getTotal();
            List<Category> list = category.getList();
            if (total == 0){
                return LayuiResult.fail(MessageConstant.NO_DATE_IN_DATABASE);
            }
            return LayuiResult.success(MessageConstant.GET_CATEGORY_SUCCESS,list,total);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.GET_CATEGORY_FAIL);
        }
    }
}
