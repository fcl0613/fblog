package com.fcl.fblog.mapper;

import com.fcl.fblog.pojo.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BlogDao {
    public Blog getBlog(@Param("id") Integer id);
    public List<Blog> findBlog(@Param("blogTitle") String blogTitle, @Param("categoryId") Integer categoryId);
    public void saveBlog(Blog blog);
    public void updateBlog(Blog blog);
    public void deleteBlog(List<Integer> ids);
    public void saveBlogTagRelation(@Param("blogId") Integer blogId, List<Integer> list);
    public void deleteTagsRelationByBlogId(@Param("id") Integer id);
    public List<Blog> findBlog4Index(@Param("searchName") String searchName);
    public List<Blog> findTopBlog(@Param("limit") Integer limit);
    public List<Blog> findAllWithTitleAndId();
    public List<Blog> findBlog4Category(@Param("categoryId") Integer categoryId);
    public List<Blog> findBlogByTagId(@Param("tagId") Integer tagId);
    public List<String> findBlogYear();
    public List<Blog> findBlogByYear(@Param("year") String year);
    public void updateVisitCount(@Param("id") Integer id);
    public Map<String,Integer> getBlogCountAndVisitCount();
}
