package com.edu.demo.util;


import com.edu.demo.enums.ResponseEnum;
import com.edu.demo.model.ResultVo;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * API接口统一返回数据格式
 *
 * @Author liu.xiaojian
 * @Date 2019-01-14 09:14
 **/
@Slf4j
@ToString
public abstract class ResultVoUtil implements Serializable {

    private static final String SUCCESS_MSG = ResponseEnum.SUCCESS.getMsg();

    private static final int SYSTEM_ERROR_CODE = ResponseEnum.SYSTEM_ERROR.getCode();

    private static final String SYSTEM_ERROR_MSG = ResponseEnum.SYSTEM_ERROR.getMsg();

    private static <D> ResultVo<D> instance(int code, String msg, D data) {

        return new ResultVo<>(code, msg, data);

    }

    public static ResultVo success() {

        return success(null);

    }

    public static <D> ResultVo<D> success(D data) {

        return instance(0, SUCCESS_MSG, data);

    }

    public static <E extends Enum<E>, D> ResultVo<D> fail(E error) {

        return fail(error, null);

    }

    public static <E extends Enum<E>, D> ResultVo<D> fail(E error, D data) {

        int code = SYSTEM_ERROR_CODE;

        String msg = SYSTEM_ERROR_MSG;

        Class<?> clazz = error.getDeclaringClass();

        Object[] constants = clazz.getEnumConstants();

        for (Object constant : constants) {

            if (!constant.equals(error)) continue;

            try {

                code = (int) clazz.getMethod("getCode", new Class[0]).invoke(constant);

                msg = (String) clazz.getMethod("getMsg", new Class[0]).invoke(constant);

                return instance(code, msg, data);

            } catch (IllegalAccessException e) {

                log.error("ResultVo fail target[{}] constant[{}] IllegalAccessException", error, constant);

            } catch (InvocationTargetException e) {

                log.error("ResultVo fail target[{}] constant[{}] InvocationTargetException", error, constant);

            } catch (NoSuchMethodException e) {

                log.error("ResultVo fail target[{}] constant[{}] NoSuchMethodException", error, constant);

            }

        }

        return instance(code, msg, data);

    }

}
