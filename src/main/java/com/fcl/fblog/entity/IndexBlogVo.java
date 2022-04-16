package com.fcl.fblog.entity;

import com.fcl.fblog.pojo.Blog;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class IndexBlogVo implements Serializable {
    private static final long serialVersionUID = 4159804004428314881L;
    private List<Blog> list;
    private Integer total;
}
