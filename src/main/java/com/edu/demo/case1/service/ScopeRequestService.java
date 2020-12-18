package com.edu.demo.case1.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author liu.xiaojian
 * @Date 2020-12-18 14:33
 **/
public interface ScopeRequestService {

    void svc(HttpServletRequest request, HttpServletResponse response);

    void svc();

}
