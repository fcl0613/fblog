package com.fcl.fblog.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndexTagVo implements Serializable {
    private static final long serialVersionUID = 4907971789727855364L;
    private Integer id;
    private String tagName;
    private Integer blogCount;
}
