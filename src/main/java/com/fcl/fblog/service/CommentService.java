package com.fcl.fblog.service;

import com.fcl.fblog.entity.BackendCommentVo;
import com.fcl.fblog.entity.LayuiPage;
import com.fcl.fblog.pojo.Comment;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CommentService {
    public PageInfo<BackendCommentVo> findCommentList(LayuiPage layuiPage, Integer id);
    public void saveComment(Comment comment);       //添加评论
    public void removeCommentLogic(Integer commentId, Byte isDelete);
    public void updateCommentPublished(Integer commentId, Byte commentStatus);
    public List<Comment> findCommentByBlogId(Integer id);
}
