package com.fcl.fblog.service.impl;

import com.fcl.fblog.common.CodeConstant;
import com.fcl.fblog.common.MessageConstant;
import com.fcl.fblog.entity.IndexTagVo;
import com.fcl.fblog.entity.LayuiPage;
import com.fcl.fblog.exception.BackendBusinessException;
import com.fcl.fblog.mapper.TagDao;
import com.fcl.fblog.pojo.Tag;
import com.fcl.fblog.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    @Transactional
    public void saveTag(Tag tag) {
        if (tag.getTagName() == null) throw new BackendBusinessException(CodeConstant.FAIL_CODE,
                MessageConstant.PARAMS_ERROR);
        tagDao.saveTag(tag);
    }

    @Override
    public Tag getTag(Integer id) {
        return tagDao.getTag(id);
    }

    @Override
    @Transactional
    public void updateTag(Tag tag) {
        tagDao.updateTag(tag);
    }

    @Override
    @Transactional
    public void removeTag(List<Integer> ids) {
        tagDao.removeTag(ids);
    }

    @Override
    public PageInfo<Tag> findTag(LayuiPage layuiPage, String tagName) {
        PageHelper.startPage(layuiPage.getPage(),layuiPage.getLimit());
        List<Tag> tags = tagDao.findTag(tagName);
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        return pageInfo;
    }

    @Override
    public List<Tag> findAll() {
        return tagDao.findTag(null);
    }

    @Override
    public List<IndexTagVo> findTopTag(Integer limit) {
        return tagDao.findTopTag(limit);
    }
}
