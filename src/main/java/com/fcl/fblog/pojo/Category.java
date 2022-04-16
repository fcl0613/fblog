package com.fcl.fblog.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {
    private static final long serialVersionUID = -214918079171543832L;
    private Integer id;
    private String categoryName;
}
