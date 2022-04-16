package com.fcl.fblog.service;

import com.fcl.fblog.entity.IndexTagVo;
import com.fcl.fblog.entity.LayuiPage;
import com.fcl.fblog.pojo.Tag;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TagService {
    public void saveTag(Tag tag);    //保存标签
    public Tag getTag(Integer id);    //根据id获取对应的标签信息
    public void updateTag(Tag tag);  //更新标签信息
    public void removeTag(List<Integer> ids);  //删除标签信息
    public PageInfo<Tag> findTag(LayuiPage layuiPage, String tagName);   //查询标签信息
    public List<Tag> findAll();
    public List<IndexTagVo> findTopTag(Integer limit);
}
