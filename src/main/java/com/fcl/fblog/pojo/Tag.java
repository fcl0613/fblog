package com.fcl.fblog.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tag implements Serializable {
    private static final long serialVersionUID = 8811321446432475248L;
    private Integer id;
    private String tagName;
}
