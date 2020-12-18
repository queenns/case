package com.edu.demo.case1.controller;

import com.edu.demo.model.ResultVo;
import com.edu.demo.util.ResultVoUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author liu.xiaojian
 * @Date 2020-12-14 19:42
 **/
@RestController
@RequestMapping("api")
public class ApiController {

    @GetMapping("common")
    public ResultVo common(HttpServletRequest request, HttpServletResponse response) {
        return ResultVoUtil.success();
    }

    @GetMapping("global")
    public ResultVo global() {
        RequestContextHolder.currentRequestAttributes();
        return ResultVoUtil.success();
    }

}
