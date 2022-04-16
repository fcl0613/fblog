package com.fcl.fblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员统一页面跳转的controller
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @GetMapping("/updatepsd")
    public String toUpdatePsd(){
        return "admin/user-password";
    }

    /**
     * 跳转到标签的编辑页面
     * @param id
     * @param tagname
     * @param model
     * @return
     */
    @GetMapping("/tag/toedit/{id}/{tagname}")
    public String toTagEdit(@PathVariable Integer id,
                            @PathVariable String tagname, Model model){
        model.addAttribute("id",id);
        model.addAttribute("taname",tagname);
        return "admin/tagedit";
    }

    /**
     * 跳转到标签的添加页面
     */
    @GetMapping("/tag/add.html")
    public String toTagAdd(){
        return "admin/tagadd";
    }

    /**
     * 跳转到分类的编辑页面
     * 根据是个人博客需求，这个是不存在当我去查询的时候，别人在改数据倒是数据不一致问题，所以直接拿页面数据进行跳转
     * 不需要去查询数据库
     */
    @GetMapping("/category/toedit/{id}/{categoryname}")
    public String toCategoryEdit(@PathVariable Integer id,
                                 @PathVariable String categoryname, Model model){
        model.addAttribute("id", id);
        model.addAttribute("categoryname", categoryname);
        return "admin/categoryedit";
    }

    /**
     * 跳转到分类的添加页面
     * @return
     */
    @GetMapping("/category/add.html")
    public String toCategoryAdd(){
        return "admin/categoryadd";
    }

    @GetMapping("/categorylist.html")
    public String toCategorylist(){
        return "admin/categorylist";
    }

    /**
     * 标签列表
     * @return
     */
    @GetMapping("/tagslist.html")
    public String toTagsList(){
        return "admin/tagslist";
    }

    /**
     * 评论列表
     * @return
     */
    @GetMapping("/comment.html")
    public String toComment(){
        return "admin/comment";
    }

    /**
     * 博客列表
     * @return
     */
    @GetMapping("/bloglist.html")
    public String tobloglist(){
        return "admin/bloglist";
    }

    /**
     * 去文章编辑页面
     * @return
     */
    @GetMapping("/essayedit.html")
    public String toessayedit(){
        return "admin/essayedit";
    }

    /**
     * 跳转到欢迎页
     * @return
     */
    @GetMapping("/welcome.html")
    public String toWelcome(){
        return "admin/welcome";
    }

    /**
     * 跳转到管理员的登录界面
     * @return
     */
    @GetMapping({"","/login","/login.html"})
    public String toLogin(){
        return "admin/login";
    }

    /**
     * 登录后跳转到首页
     * @return
     */
    @GetMapping("/index.html")
    public String toIndex(){
        return "admin/index";
    }
}