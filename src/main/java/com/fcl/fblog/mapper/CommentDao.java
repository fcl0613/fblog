package com.fcl.fblog.mapper;

import com.fcl.fblog.entity.BackendCommentVo;
import com.fcl.fblog.pojo.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    public List<Comment> findCommentByBlogId(@Param("id") Integer id);
    public void saveComment(Comment comment);
    public List<BackendCommentVo> findComment(@Param("blogId") Integer id);
    public void deleteCommentLogic(@Param("commentId") Integer commentId, @Param("isDelete") Byte isDelete);
    public void updateCommentPublished(@Param("commentId") Integer commentId, @Param("commentStatus") Byte commentStatus);
    public Integer getCommentCount();
    public void deleteCommentByBlogIds(List<Integer> list);
}
