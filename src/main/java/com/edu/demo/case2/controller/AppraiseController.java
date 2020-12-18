package com.edu.demo.case2.controller;

import com.edu.demo.case2.predict4j.AppraiseSearch;
import com.edu.demo.model.ResultVo;
import com.edu.demo.util.ResultVoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 估价接口
 *
 * @Author liu.xiaojian
 * @Date 2020-12-17 11:05
 **/

@RestController
@Api(tags = "估价接口")
@RequestMapping("/v1/appraise")
public class AppraiseController {

    @Autowired
    private AppraiseSearch appraiseSearch;

    @ResponseBody
    @PostMapping("worn")
    @ApiOperation(value = "/worn", notes = "二手车估价")
    @ApiImplicitParam(name = "values", required = true, dataType = "double[]", value = "[3,199,2,14,5992,14.8,5,6,2.5273273656719524,2009,1]")
    public ResultVo<Double> worn(@ApiParam(name = "values", required = true) @RequestBody() double[] values) {
        double result = appraiseSearch.search(values);
        return ResultVoUtil.success(result);
    }

}
