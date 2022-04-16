package com.fcl.fblog.controller;

import com.fcl.fblog.common.MessageConstant;
import com.fcl.fblog.entity.LayuiResult;
import com.fcl.fblog.pojo.Comment;
import com.fcl.fblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 博客详情页添加评论
     * @param comment
     * @return
     */
    @PostMapping("/commentsub")
    public String commentSub(Comment comment){
        commentService.saveComment(comment);
        return "redirect:/blog/comment/" + comment.getBlogId();
    }

    /**
     * 博客详情页获取相关评论
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/comment/{id}")
    public String comments(@PathVariable Integer id, Model model){
        List<Comment> commentList = commentService.findCommentByBlogId(id);
        model.addAttribute("comments", commentList);
        return "blog/blog :: commentlist";
    }

    /**
     * 测试数据格式的代码
     * @param id
     * @return
     */
    @GetMapping("/hhh/{id}")
    @ResponseBody
    public LayuiResult getComment(@PathVariable Integer id){
        List<Comment> commentList = commentService.findCommentByBlogId(id);
        return LayuiResult.success(MessageConstant.GET_COMMENT_SUCCESS,commentList,null);
    }
}
