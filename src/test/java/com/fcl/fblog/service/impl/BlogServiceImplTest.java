package com.fcl.fblog.service.impl;

import com.fcl.fblog.mapper.BlogDao;
import com.fcl.fblog.mapper.TagDao;
import com.fcl.fblog.pojo.Blog;
import com.fcl.fblog.pojo.Category;
import com.fcl.fblog.pojo.Tag;
import com.fcl.fblog.service.BlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogServiceImplTest {

    @Autowired
    BlogService blogService;

    @Autowired
    BlogDao blogDao;

    @Autowired
    TagDao tagDao;

    @Test
    void test11(){
        Category category = new Category();
        category.setId(2);
        Blog blog = new Blog();
        blog.setTitle("测试222");
        blog.setContent("sdahdkad");
        blog.setImgUrl("ydddhds");
        blog.setFlag("转载");
        blog.setVisitCount(220);
        blog.setEnableComment(new Byte("1"));
        blog.setPublished(new Byte("1"));
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setCategory(category);
    }

    @Test
    void test2222(){
        List<Blog> list = blogDao.findBlog(null, null);
        System.out.println(list);
//        Tag tag = tagDao.getTag(2);
//        System.out.println(tag);
    }
}