package com.fcl.fblog.service.impl;

import com.fcl.fblog.common.enums.ExceptionEnum;
import com.fcl.fblog.entity.LayuiPage;
import com.fcl.fblog.exception.BackendBusinessException;
import com.fcl.fblog.exception.FrontBusinessException;
import com.fcl.fblog.mapper.BlogDao;
import com.fcl.fblog.mapper.CategoryDao;
import com.fcl.fblog.mapper.CommentDao;
import com.fcl.fblog.pojo.Blog;
import com.fcl.fblog.service.BlogService;
import com.fcl.fblog.utils.CommonUtils;
import com.fcl.fblog.utils.MarkDownUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public Blog getBlog(Integer id, boolean isBackend) {
        Blog blog = blogDao.getBlog(id);
        if (blog == null){
            throw new FrontBusinessException(ExceptionEnum.NOT_FOUND);
        }
        if (!isBackend){
            String content = blog.getContent();
            String s = MarkDownUtil.markdownToHtmlExtensions(content);
            blog.setContent(s);
            blogDao.updateVisitCount(id);
        }
        return blog;
    }

    @Override
    public PageInfo<Blog> findBlog(LayuiPage layuiPage, String blogTitle, Integer categoryId) {
        PageHelper.startPage(layuiPage.getPage(), layuiPage.getLimit());
        List<Blog> blogs = blogDao.findBlog(blogTitle, categoryId);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogs);
        return blogPageInfo;
    }

    @Override
    @Transactional
    public void saveBlog(Map<String,Object> map) {
        try {
            Blog blog = CommonUtils.mapToBlog(map, false);
            List<Integer> tags = (List<Integer>) map.get("tags");
            blogDao.saveBlog(blog);
            blogDao.saveBlogTagRelation(blog.getId(), tags);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BackendBusinessException();
        }
    }

    @Override
    @Transactional
    public void updateBlog(Map<String,Object> map) {
        Blog blog = CommonUtils.mapToBlog(map, true);
        List<Integer> tags = (List<Integer>) map.get("tags");
        blogDao.deleteTagsRelationByBlogId(blog.getId());
        blogDao.updateBlog(blog);
        blogDao.saveBlogTagRelation(blog.getId(), tags);
    }

    @Override
    @Transactional
    public void updateBlog(Blog blog) {
        blogDao.updateBlog(blog);
    }

    @Override
    @Transactional
    public void removeBlog(List<Integer> ids) {
        blogDao.deleteBlog(ids);
        commentDao.deleteCommentByBlogIds(ids);
    }

    @Override
    public PageInfo<Blog> findBlog4Index(LayuiPage layuiPage, String searchName) {
        PageHelper.startPage(layuiPage.getPage(),layuiPage.getLimit());
        PageHelper.orderBy("id desc");
        List<Blog> blog4Index = blogDao.findBlog4Index(searchName);
        PageInfo<Blog> pageInfo = new PageInfo<>(blog4Index);
        return pageInfo;
    }

    @Override
    public List<Blog> findTopBlog(Integer limit) {
        return blogDao.findTopBlog(limit);
    }

    @Override
    public List<Blog> findAllWithTitleAndId() {
        return blogDao.findAllWithTitleAndId();
    }

    @Override
    public PageInfo<Blog> findBlog4Category(LayuiPage layuiPage, Integer categoryId) {
        PageHelper.startPage(layuiPage.getPage(),layuiPage.getLimit());
        List<Blog> blog4Category = blogDao.findBlog4Category(categoryId);
        PageInfo<Blog> pageInfo = new PageInfo<>(blog4Category);
        return pageInfo;
    }

    @Override
    public PageInfo<Blog> findBlogByTag(LayuiPage layuiPage, Integer tagId) {
        PageHelper.startPage(layuiPage.getPage(),layuiPage.getLimit());
        List<Blog> blogList = blogDao.findBlogByTagId(tagId);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }

    @Override
    public Map<String, List<Blog>> findBlog4Archives() {
        Map<String,List<Blog>> blogMap = new HashMap<>();
        List<String> blogYear = blogDao.findBlogYear();
        for (String year : blogYear) {
            List<Blog> blogList = blogDao.findBlogByYear(year);
            blogMap.put(year,blogList);
        }
        return blogMap;
    }

    @Override
    public Map<String,Integer> getStats4Welcome() {
        Map<String, Integer> map = blogDao.getBlogCountAndVisitCount();
        Integer commentCount = commentDao.getCommentCount();
        Integer categoryCount = categoryDao.getCategoryCount();
        map.put("commentCount", commentCount);
        map.put("categoryCount", categoryCount);
        return map;
    }
}
