package com.fcl.fblog.controller;

import com.fcl.fblog.common.CodeConstant;
import com.fcl.fblog.common.MessageConstant;
import com.fcl.fblog.entity.LayuiPage;
import com.fcl.fblog.entity.LayuiResult;
import com.fcl.fblog.pojo.Blog;
import com.fcl.fblog.pojo.Category;
import com.fcl.fblog.service.BlogService;
import com.fcl.fblog.service.CategoryService;
import com.fcl.fblog.utils.CommonUtils;
import com.fcl.fblog.utils.FileUpload;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/welcome")
    public LayuiResult getWelcomeDate(){
        try {
            Map<String, Integer> stats4Welcome = blogService.getStats4Welcome();
            return LayuiResult.success(MessageConstant.GET_STATS_SUCCESS,stats4Welcome,null);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.GET_STATS_FAIL);
        }
    }

    /**
     * 图片上传
     * @param multipartFile
     * @return
     */
    @PostMapping("/uploadFile")
    public LayuiResult uploadFile(@RequestParam(name = "file")MultipartFile multipartFile){
        //windows
        String filePath = System.getProperty("user.dir") +
                System.getProperty("file.separator") +
                "img";

        //linux file:/usr/local/img/
//        String filePath = "file:/usr/local/img";
        //文件名=当前时间+原来的文件名
        System.out.println(multipartFile.getOriginalFilename());
        String fileName = System.currentTimeMillis()+multipartFile
                .getOriginalFilename().substring(multipartFile.getOriginalFilename().length()-4);
        try {
            FileUpload.fileUpload(multipartFile,filePath,fileName);
            return LayuiResult.success(MessageConstant.UPLOAD_FILE_SUCCESS,fileName,null);
        } catch (IOException e) {
           return LayuiResult.fail(MessageConstant.UPLOAD_FILE_FAIL);
        }
    }

    /**
     * 获取所有的博客，在评论页面  select
     * @return
     */
    @GetMapping("/all")
    public LayuiResult findAllBlogWithTitleAndId(){
        try {
            List<Blog> blogList = blogService.findAllWithTitleAndId();
            return LayuiResult.success(MessageConstant.GET_BLOG_SUCCESS,blogList,null);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.GET_BLOG_FAIL);
        }
    }

    /**
     * 更新blog
     */
    @PostMapping("/update")
    public LayuiResult blogUpdate(@RequestBody Map<String,Object> map){
        try {
            blogService.updateBlog(map);
            return LayuiResult.success(MessageConstant.UPDATE_BLOG_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.UPDATE_BLOG_FAIL);
        }
    }

    /**
     * 跳转到编辑页面
     * @param blogid
     * @return
     */
    @GetMapping("/toedit")
    public ModelAndView toedit(@RequestParam("blogid") Integer blogid){
        ModelAndView mv = new ModelAndView();
        try {
            Blog blog = blogService.getBlog(blogid,true);
            List<Category> all = categoryService.findAll();
            mv.addObject("blog",blog);
            mv.addObject("categorylist",all);
            mv.setViewName("admin/editblog");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            mv.setViewName("error/404");
            return mv;
        }
    }

    /**
     * 更新博客是否可以评论
     * @param blogId
     * @param enableComment
     * @return
     */
    @PostMapping("/enablecomment")
    public LayuiResult updateBlogEnableComment(@RequestParam("blogid") Integer blogId,
                                        @RequestParam("enableComment") String enableComment){
        try {
            Byte e = new Byte(enableComment);
            Blog blog = new Blog();
            blog.setId(blogId);
            blog.setEnableComment(e);
            blogService.updateBlog(blog);
            return LayuiResult.success(MessageConstant.UPDATE_BLOG_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.UPDATE_BLOG_FAIL);
        }
    }

    /**
     * 修改博客发布状态
     */
    @PostMapping("/published")
    public LayuiResult updateBlogPublish(@RequestParam("blogid") Integer blogId,
                                        @RequestParam("published") String published){
        try {
            Byte p = new Byte(published);
            Blog blog = new Blog();
            blog.setId(blogId);
            blog.setPublished(p);
            blogService.updateBlog(blog);
            return LayuiResult.success(MessageConstant.UPDATE_BLOG_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.UPDATE_BLOG_FAIL);
        }
    }

    /**
     * 添加博客
     */
    @PostMapping("/add")
    public LayuiResult saveBlog(@RequestBody Map<String,Object> map){
//        System.out.println(map);
        try {
            blogService.saveBlog(map);
            return LayuiResult.success(CodeConstant.SUCCESS_CODE,MessageConstant.SAVE_BLOG_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(CodeConstant.FAIL_CODE, MessageConstant.SAVE_BLOG_FAIL);
        }
    }

    /**
     * 删除博客
     * @param ids
     * @return
     */
    @DeleteMapping("/delete/{ids}")
    public LayuiResult deleteBlog(@PathVariable String ids){
        try {
            List<Integer> integers = CommonUtils.StringsToList(ids);
            blogService.removeBlog(integers);
            return LayuiResult.success(MessageConstant.DELETE_BLOG_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.DELETE_BLOG_FAIL);
        }
    }

    /**
     * 博客查询
     * @param layuiPage
     * @param blogTitle
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    public LayuiResult findBlogList(LayuiPage layuiPage,
                                    @RequestParam(value = "blogtitle", defaultValue = "") String blogTitle,
                                    @RequestParam(value = "categoryid", defaultValue = "0") Integer categoryId){
        try {
            PageInfo<Blog> blog = blogService.findBlog(layuiPage, blogTitle, categoryId);
            List<Blog> list = blog.getList();
            long total = blog.getTotal();
            return LayuiResult.success(MessageConstant.GET_BLOG_SUCCESS,list,total);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.GET_BLOG_FAIL);
        }
    }
}
