package com.edu.demo.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * API错误信息枚举
 *
 * @Author liu.xiaojian
 * @Date 2020-11-03 10:18
 **/
@Getter
@ToString
public enum ResponseEnum {

    /**
     * 成功
     **/

    SUCCESS(0, "成功"),

    /**
     * 系统异常
     **/
    SYSTEM_ERROR(-1, "系统异常");

    int code;

    String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseEnum codeToEnum(int code) {
        ResponseEnum[] values = ResponseEnum.values();
        for (ResponseEnum returnCode : values) {
            if (returnCode.code == code) {
                return returnCode;
            }
        }
        return SYSTEM_ERROR;
    }

}
