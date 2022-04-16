package com.fcl.fblog.service.impl;

import com.fcl.fblog.common.CodeConstant;
import com.fcl.fblog.common.MessageConstant;
import com.fcl.fblog.common.enums.ExceptionEnum;
import com.fcl.fblog.entity.BackendCommentVo;
import com.fcl.fblog.entity.LayuiPage;
import com.fcl.fblog.exception.FrontBusinessException;
import com.fcl.fblog.mapper.CommentDao;
import com.fcl.fblog.pojo.Comment;
import com.fcl.fblog.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public PageInfo<BackendCommentVo> findCommentList(LayuiPage layuiPage, Integer id) {
        PageHelper.startPage(layuiPage.getPage(),layuiPage.getLimit());
        List<BackendCommentVo> commentList = commentDao.findComment(id);
        PageInfo<BackendCommentVo> pageInfo = new PageInfo<>(commentList);
        return pageInfo;
    }

    @Override
    @Transactional
    public void saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        comment.setAvatar("/blog/images/touxiang.jpg");
        comment.setIsDelete(new Byte("0"));
        comment.setCommentStatus(new Byte("0"));
        if (comment.getParentId() == -1){
            comment.setParentId(null);
        }
        commentDao.saveComment(comment);
    }

    @Override
    @Transactional
    public void removeCommentLogic(Integer commentId, Byte isDelete) {
        commentDao.deleteCommentLogic(commentId, isDelete);
    }

    @Override
    @Transactional
    public void updateCommentPublished(Integer commentId, Byte commentStatus) {
        commentDao.updateCommentPublished(commentId, commentStatus);
    }

    @Override
    public List<Comment> findCommentByBlogId(Integer id) {
        List<Comment> commentList = commentDao.findCommentByBlogId(id);
//        List<Comment> comments = new ArrayList<>();
        List<Comment> parents = new ArrayList<>();
        for (Comment comment : commentList) {
            if (comment.getParentId() == null){
//                comments.add(comment);
                parents.add(comment);
            }else {
                boolean fp = false;
                for (Comment parent : parents) {
                    if (parent.getReplayComments().size() == 0 && comment.getParentId() == parent.getId()){
                        parent.getReplayComments().add(comment);
                        fp = true;
                        break;
                    }else {
                        for (Comment replayComment : parent.getReplayComments()) {
                            if (comment.getParentId() == replayComment.getId()){
                                parent.getReplayComments().add(comment);
                                fp = true;
                                break;
                            }
                        }
                    }
                }
                if (!fp){
                    throw new FrontBusinessException(CodeConstant.FAIL_CODE, MessageConstant.SERVICE_ERROR);
                }
            }
        }
        return parents;
    }
}
