package com.edu.demo.case1.service.impl;

import com.edu.demo.case1.service.ScopeSessionService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author liu.xiaojian
 * @Date 2020-12-18 14:33
 **/
@Service
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ScopeSessionServiceImpl implements ScopeSessionService {

    @Override
    public void svc() {

    }

}
