package com.fcl.fblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BackendCommentVo implements Serializable {
    private static final long serialVersionUID = -1918434706880684130L;
    private Integer id;
    private String nickName;
    private String email;
    private String content;
    private Byte commentStatus;
    private Byte isDelete;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String title;
}
