package com.edu.demo.case1.service.impl;

import com.edu.demo.case1.service.ScopeRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author liu.xiaojian
 * @Date 2020-12-18 14:34
 **/
@Slf4j
@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ScopeRequestServiceImpl extends AbstractRequestServiceImpl implements ScopeRequestService {

    @Override
    public void svc(HttpServletRequest request, HttpServletResponse response) {
        log.info("param:{}, request: {}, response: {}", request.getParameter("xyz"), request, response);
        configValue(10);
    }

    @Override
    public void svc() {
        HttpServletRequest request = getRequest();
        HttpServletResponse response = getResponse();
        log.info("param:{}, request: {}, response: {}", request.getParameter("xyz"), request, response);
        configValue(30);
    }

}
