package com.fcl.fblog.controller;

import com.fcl.fblog.common.MessageConstant;
import com.fcl.fblog.entity.BackendCommentVo;
import com.fcl.fblog.entity.LayuiPage;
import com.fcl.fblog.entity.LayuiResult;
import com.fcl.fblog.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/comment")
public class BackendCommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 更新评论审核
     * @param commentId
     * @param commentStatus
     * @return
     */
    @PutMapping("/update")
    public LayuiResult updateComment(@RequestParam("commentid") Integer commentId,
                                     @RequestParam("commentstatus") String commentStatus){
        try {
            commentService.updateCommentPublished(commentId, new Byte(commentStatus));
            return LayuiResult.success(MessageConstant.AUDIT_COMMENT_SUCCESS);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.AUDIT_COMMENT_FAIL);
        }
    }

    /**
     * 删除评论
     * @param commentId
     * @param isDelete
     * @return
     */
    @DeleteMapping("/delete")
    public LayuiResult deleteComment(@RequestParam("commentid") Integer commentId,
                                     @RequestParam("isdelete") String isDelete){
        try {
            commentService.removeCommentLogic(commentId, new Byte(isDelete));
            //传入是0 则是代表要删除这条评论
            //传入是1 则是代表要回复这条评论
            if ("0".equals(isDelete)){
                return LayuiResult.success(MessageConstant.DELETE_COMMENT_SUCCESS);
            }
            return LayuiResult.success(MessageConstant.RECOVER_COMMENT_SUCCESS);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            if ("0".equals(isDelete)){
                return LayuiResult.success(MessageConstant.DELETE_COMMENT_FAIL);
            }
            return LayuiResult.success(MessageConstant.RECOVER_COMMENT_FAIL);
        }
    }

    /**
     * 管理端查询评论
     * @param layuiPage
     * @param blogId
     * @return
     */
    @GetMapping("/list")
    public LayuiResult getCommentList(LayuiPage layuiPage,
                                      @RequestParam(value = "searchParams",required = false) Integer blogId){
        try {
            PageInfo<BackendCommentVo> commentList = commentService.findCommentList(layuiPage, blogId);
            List<BackendCommentVo> list = commentList.getList();
            long total = commentList.getTotal();
            return LayuiResult.success(MessageConstant.GET_COMMENT_SUCCESS,list,total);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.GET_COMMENT_FAIL);
        }
    }
}
