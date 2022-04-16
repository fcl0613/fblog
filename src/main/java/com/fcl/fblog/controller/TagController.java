package com.fcl.fblog.controller;

import com.fcl.fblog.common.MessageConstant;
import com.fcl.fblog.entity.LayuiPage;
import com.fcl.fblog.entity.LayuiResult;
import com.fcl.fblog.exception.BackendBusinessException;
import com.fcl.fblog.pojo.Tag;
import com.fcl.fblog.service.TagService;
import com.fcl.fblog.utils.CommonUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin/tag")
@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/all")
    public LayuiResult getAllTags(){
        try {
            List<Tag> all = tagService.findAll();
            return LayuiResult.success(MessageConstant.GET_TAG_SUCCESS,all,null);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.GET_TAG_FAIL);
        }
    }

    /**
     * 标签更新
     * @param tag
     * @return
     */
    @PutMapping("/update")
    public LayuiResult updateTag(Tag tag){
        try {
            tagService.updateTag(tag);
            return LayuiResult.success(MessageConstant.UPDATE_TAG_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.UPDATE_TAG_FAIL);
        }
    }

    /**
     * 删除标签
     * @param ids
     * @return
     */
    @DeleteMapping("/delete/{ids}")
    public LayuiResult deleteTag(@PathVariable String ids){
        try {
            List<Integer> list = CommonUtils.StringsToList(ids);
            tagService.removeTag(list);
            return LayuiResult.success(MessageConstant.DELETE_TAG_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.DELETE_TAG_FAIL);
        }
    }

    /**
     * 标签添加
     * @param tag
     * @return
     */
    @PostMapping("/add")
    public LayuiResult doTagAdd(Tag tag){
        try {
            tagService.saveTag(tag);
            return LayuiResult.success(MessageConstant.SAVE_TAG_SUCCESS);
        } catch (BackendBusinessException e) {
            return LayuiResult.fail(MessageConstant.SAVE_TAG_FAIL);
        }
    }

    /**
     * 标签查询
     * @param layuiPage
     * @param searchParams
     * @return
     */
    @GetMapping("/list")
    public LayuiResult findTagList(LayuiPage layuiPage,
                                   @RequestParam(value = "searchParams", defaultValue = "") String searchParams){
        try {
            PageInfo<Tag> tagPageInfo = tagService.findTag(layuiPage, searchParams);
            long total = tagPageInfo.getTotal();
            List<Tag> list = tagPageInfo.getList();
            if (total == 0){
                return LayuiResult.fail(MessageConstant.NO_DATE_IN_DATABASE);
            }
            return LayuiResult.success(MessageConstant.GET_TAG_SUCCESS,list,total);
        } catch (Exception e) {
            e.printStackTrace();
            return LayuiResult.fail(MessageConstant.GET_TAG_FAIL);
        }
    }
}
