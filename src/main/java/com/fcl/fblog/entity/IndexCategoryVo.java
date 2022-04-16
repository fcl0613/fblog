package com.fcl.fblog.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndexCategoryVo implements Serializable {
    private static final long serialVersionUID = -286547931811132841L;
    private Integer id;
    private String categoryName;
    private Integer blogCount;
}
