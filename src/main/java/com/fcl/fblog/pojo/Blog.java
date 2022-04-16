package com.fcl.fblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Blog implements Serializable {
    private static final long serialVersionUID = 1235604599173668984L;
    private Integer id;
    private String title;
    private String preface;
    private String content; //内容
    private String imgUrl;
    private String flag;
    private Integer visitCount; //浏览次数
//    private Byte shareStatement; //是否允许转载
    private Byte enableComment;  //是否可评论
    private Byte published;  //是否发布 草稿
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private Category category;
    private List<Tag> tags;
}
