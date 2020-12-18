package com.edu.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口请求返回最外层对象
 *
 * @Author liu.xiaojian
 * @Date 2019-01-14 09:20
 **/
@Data
public class ResultVo<T> implements Serializable {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public ResultVo(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public ResultVo(Integer code, String msg, T data) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

}
