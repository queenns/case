package com.edu.demo.case1.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

/**
 * session 作用域
 *
 * @Author liu.xiaojian
 * @Date 2020-12-18 14:24
 **/
@RestController
@RequestMapping("scope/session")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ScopeSessionController {
}
