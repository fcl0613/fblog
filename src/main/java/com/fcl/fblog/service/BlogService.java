package com.fcl.fblog.service;

import com.fcl.fblog.entity.LayuiPage;
import com.fcl.fblog.pojo.Blog;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;


public interface BlogService {
    public Blog getBlog(Integer id, boolean isBackend);
    public PageInfo<Blog> findBlog(LayuiPage layuiPage, String blogTitle, Integer categoryId);
    public void saveBlog(Map<String,Object> map);
    public void updateBlog(Map<String,Object> map);     //大部分更新
    public void updateBlog(Blog blog);     //局部更新
    public void removeBlog(List<Integer> ids);
    public PageInfo<Blog> findBlog4Index(LayuiPage layuiPage, String searchName);
    public List<Blog> findTopBlog(Integer limit);
    public List<Blog> findAllWithTitleAndId();
    public PageInfo<Blog> findBlog4Category(LayuiPage layuiPage, Integer categoryId);
    public PageInfo<Blog> findBlogByTag(LayuiPage layuiPage, Integer tagId);
    public Map<String,List<Blog>> findBlog4Archives();
    public Map<String,Integer> getStats4Welcome();
}
