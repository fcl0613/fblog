package com.fcl.fblog.utils;

import com.fcl.fblog.pojo.Blog;
import com.fcl.fblog.pojo.Category;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CommonUtils {

    /**
     * map封装的json对象转blog对象
     */
    public static Blog mapToBlog(Map<String,Object> map, boolean isUpdate){
        String title = (String) map.get("title");
        String preface = (String) map.get("preface");
        Byte published = new Byte(map.get("published").toString());
        String flag = (String) map.get("flag");
        Integer categoryId = Integer.parseInt((String) map.get("category"));
        String content = (String) map.get("content");
        Byte enableComment = new Byte(map.get("enableComment").toString());
        String imgURL = (String) map.get("imgUrl");
        Category category = new Category();
        category.setId(categoryId);
        Blog blog = new Blog();
        if (!isUpdate){
            blog.setCreateTime(new Date());
            blog.setImgUrl("morentupian");
            blog.setVisitCount(0);
        } else {
            Integer blogId = Integer.parseInt((String) map.get("id"));
            blog.setId(blogId);
        }
        blog.setImgUrl(imgURL);
        blog.setTitle(title);
        blog.setPreface(preface);
        blog.setCategory(category);
        blog.setPublished(published);
        blog.setEnableComment(enableComment);
        blog.setContent(content);
        blog.setFlag(flag);
        blog.setUpdateTime(new Date());
        return blog;
    }

    /**
     * 多id转integer列表
     * @param ids
     * @return
     */
    public static List<Integer> StringsToList(String ids){
        String[] split = ids.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }
}
