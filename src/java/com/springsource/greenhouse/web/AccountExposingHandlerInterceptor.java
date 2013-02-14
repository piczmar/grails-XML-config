package com.springsource.greenhouse.web;

import grails.custom.security.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring MVC Interceptor that exposes the Account identifying the currently signed in member as a well-known
 * request attribute that can be used during the course of request processing.
 * Supports obtaining a reference to the current member Account from @Controllers and views.
 * @author Keith Donald
 */
public class AccountExposingHandlerInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("AccountExposingHandlerInterceptor - preHandle, auth: " + auth);
        if (auth != null && auth.getPrincipal() instanceof User) {
            System.out.println("AccountExposingHandlerInterceptor - set request attr, account: " + auth.getPrincipal());
            request.setAttribute("account", auth.getPrincipal());
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}