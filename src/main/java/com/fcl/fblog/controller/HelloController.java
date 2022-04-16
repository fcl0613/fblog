package com.fcl.fblog.controller;

import com.fcl.fblog.service.BlogService;
import com.fcl.fblog.service.CategoryService;
import com.fcl.fblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试控制器
 */
public class HelloController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @RequestMapping({"/","/index","/index.html"})
    public String hello(Model model){

        return "blog/index";
    }
}
