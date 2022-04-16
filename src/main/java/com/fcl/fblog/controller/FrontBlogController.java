package com.fcl.fblog.controller;

import com.fcl.fblog.entity.IndexCategoryVo;
import com.fcl.fblog.entity.IndexTagVo;
import com.fcl.fblog.entity.LayuiPage;
import com.fcl.fblog.exception.FrontBusinessException;
import com.fcl.fblog.pojo.Blog;
import com.fcl.fblog.pojo.Comment;
import com.fcl.fblog.service.BlogService;
import com.fcl.fblog.service.CategoryService;
import com.fcl.fblog.service.CommentService;
import com.fcl.fblog.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class FrontBlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/blog/about")
    public String toAbout(Model model){
        return "blog/about";
    }

    /**
     * 去归档页面
     * @param model
     * @return
     */
    @GetMapping("/blog/archives")
    public String toArchives(Model model){
        Map<String, List<Blog>> blog4Archives = blogService.findBlog4Archives();
        model.addAttribute("blogmap", blog4Archives);
        return "blog/archives";
    }

    /**
     * 去标签页面
     * @param id
     * @param page
     * @param limit
     * @param model
     * @return
     */
    @GetMapping("/blog/tags")
    public String toTags(@RequestParam(value = "id",defaultValue = "0") Integer id,
                         @RequestParam(value = "page",defaultValue = "1") Integer page,
                         @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                         Model model){
        List<IndexTagVo> topTag = tagService.findTopTag(1000);
        if (id == 0){
            id = topTag.get(0).getId();
        }
        LayuiPage layuiPage = new LayuiPage();
        layuiPage.setPage(page);
        layuiPage.setLimit(limit);
        PageInfo<Blog> blogPageInfo = blogService.findBlogByTag(layuiPage, id);
        model.addAttribute("pageinfo",blogPageInfo);
        model.addAttribute("tagList",topTag);
        model.addAttribute("currentId",id);
        return "blog/tags";
    }

    /**
     * 去分类页面
     * @param id
     * @param page
     * @param limit
     * @param model
     * @return
     */
    @GetMapping("/blog/category")
    public String toCategory(@RequestParam(value = "id",defaultValue = "0") Integer id,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                             Model model){
        List<IndexCategoryVo> topCategory = categoryService.findTopCategory(1000);
        if (id == 0){
            id = topCategory.get(0).getId();
        }
        LayuiPage layuiPage = new LayuiPage();
        layuiPage.setPage(page);
        layuiPage.setLimit(limit);
        PageInfo<Blog> pageInfo = blogService.findBlog(layuiPage, "", id);
        model.addAttribute("pageinfo",pageInfo);
        model.addAttribute("categoryList",topCategory);
        model.addAttribute("currentId",id);
        return "blog/category";
    }

    /**
     * 去详情界面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/blog/{id}")
    public String blogDetail(@PathVariable Integer id, Model model){
        try {
            Blog blog = blogService.getBlog(id,false);
            List<Comment> commentList = commentService.findCommentByBlogId(id);
            model.addAttribute("comments", commentList);
            model.addAttribute("blog", blog);
            return "blog/blog";
        } catch (FrontBusinessException e) {
            model.addAttribute("msg", e.getErrorMsg());
            return "error/404";
        }
    }

    /**
     * 首页面
     * @param page
     * @param limit
     * @param searchName
     * @param model
     * @return
     */
    @RequestMapping({"/","/index","/index.html"})
    public String hello(@RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                        @RequestParam(value = "search", defaultValue = "") String searchName,
                        Model model){
        LayuiPage layuiPage = new LayuiPage();
        layuiPage.setPage(page);
        layuiPage.setLimit(limit);
        try {
            PageInfo<Blog> blog4Index = blogService.findBlog4Index(layuiPage, searchName);
            List<IndexCategoryVo> topCategory = categoryService.findTopCategory(5);
            List<IndexTagVo> topTag = tagService.findTopTag(8);
            List<Blog> topBlog = blogService.findTopBlog(5);
            model.addAttribute("topCategory", topCategory);
            model.addAttribute("topTag", topTag);
            model.addAttribute("topBlog", topBlog);
            model.addAttribute("pageinfo", blog4Index);
            model.addAttribute("searchName", searchName);
            return "blog/index";
        } catch (Exception e) {
            e.printStackTrace();
            return "error/404";
        }
    }
}
