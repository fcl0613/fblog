package com.fcl.fblog.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AdminUser implements Serializable {
    private static final long serialVersionUID = -5695167897273809166L;

    private Integer id;
    private String nickName;
    private String userName;
    private String password;
    private String email;
    private Date createTime;
    private Date updateTime;
}
