package com.fcl.fblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = -7408864149178091566L;
    private Integer id;
    private Integer blogId;
    private Integer parentId;
    private String nickName;
    private String email;
    private String content;
    private String avatar;  //头像地址
    private Byte commentStatus;
    private Byte isDelete;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private List<Comment> replayComments = new ArrayList<>();
    private String parentNickName;  //冗余字段
}
