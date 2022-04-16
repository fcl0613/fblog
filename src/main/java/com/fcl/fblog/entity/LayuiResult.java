package com.fcl.fblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * layui统一返回数据规范
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayuiResult<T> {
    private Integer code;   //0成功 1失败
    private String msg;
    private Long count;
    private T data;

    public static LayuiResult<Object> success(){
        return new LayuiResult<>(0,"success",null,null);
    }

    public static LayuiResult<Object> success(String msg){
        return new LayuiResult<>(0, msg, null, null);
    }

    public static LayuiResult<Object> success(Integer code, String msg){
        return new LayuiResult<>(code, msg, null, null);
    }

    public static LayuiResult<Object> success(String msg, Object data, Long count){
        return new LayuiResult<>(0, msg, count, data);
    }

    public static LayuiResult<Object> fail(){
        return new LayuiResult<>(1,"fail",null,null);
    }

    public static LayuiResult<Object> fail(String msg){
        return new LayuiResult<>(1, msg, null, null);
    }

    public static LayuiResult<Object> fail(Integer code, String msg){
        return new LayuiResult<>(code,msg,null,null);
    }
}
