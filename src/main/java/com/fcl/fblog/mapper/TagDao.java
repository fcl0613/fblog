package com.fcl.fblog.mapper;

import com.fcl.fblog.entity.IndexTagVo;
import com.fcl.fblog.pojo.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagDao {
    public void saveTag(Tag tag);    //保存标签
    public Tag getTag(@Param("id") Integer id);    //根据id获取对应的标签信息
    public void updateTag(Tag tag);  //更新标签信息
    public void removeTag(List<Integer> ids);  //删除标签信息
    public List<Tag> findTag(@Param("tagName") String tagName);   //查询标签信息
    public List<Tag> findTagByBlogId(@Param("blogId") Integer blogId);
    public List<IndexTagVo> findTopTag(@Param("limit") Integer limit);
}
