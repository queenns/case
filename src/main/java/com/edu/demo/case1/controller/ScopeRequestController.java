package com.edu.demo.case1.controller;

import com.edu.demo.case1.service.ScopeRequestService;
import com.edu.demo.model.ResultVo;
import com.edu.demo.util.ResultVoUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * request 作用域
 *
 * @Author liu.xiaojian
 * @Date 2020-12-14 19:42
 **/
@RestController
@Api(tags = "Request作用域")
@RequestMapping("scope/request")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ScopeRequestController {

    @Autowired
    private ScopeRequestService svc;

    /**
     * 传统方式
     *
     * @param request  {@link HttpServletRequest}
     * @param response {@link HttpServletResponse}
     * @return {@link ResultVo}
     */
    @GetMapping("common")
    @ApiOperation(value = "common")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "xyz", value = "参数", dataType = "Integer", paramType = "query")
    })
    public ResultVo common(HttpServletRequest request, HttpServletResponse response) {
        svc.svc(request, response);
        return ResultVoUtil.success();
    }

    /**
     * 上下文方式
     *
     * @return {@link ResultVo}
     */
    @GetMapping("global")
    @ApiOperation(value = "global")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "xyz", value = "参数", dataType = "Integer", paramType = "query")
    })
    public ResultVo global() {
        svc.svc();
        return ResultVoUtil.success();
    }

}
