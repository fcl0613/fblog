package com.fcl.fblog.mapper;

import com.fcl.fblog.entity.IndexCategoryVo;
import com.fcl.fblog.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {
    public void insertCategory(Category category);
    public Category getCategory(@Param("id") Integer id);
    public void updateCategory(Category category);
    public void deleteCategory(List<Integer> ids);
    public List<Category> findCategory(@Param("categoryName") String categoryName);
    public List<IndexCategoryVo> findTopCategory(@Param("limit") Integer limit);
    public Integer getCategoryCount();
}
