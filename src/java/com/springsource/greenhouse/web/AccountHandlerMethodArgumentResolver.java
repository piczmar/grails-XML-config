package com.springsource.greenhouse.web;

import grails.custom.security.User;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.security.Principal;

public class AccountHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    public boolean supportsParameter(MethodParameter parameter) {
        return User.class.isAssignableFrom(parameter.getParameterType());
    }

    public Object resolveArgument(MethodParameter
                                          parameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        Principal principal = webRequest.getUserPrincipal();
        System.out.println("AccountHandlerMethodArgumentResolver = getUserPrincipal: " + principal);
        System.out.println("AccountHandlerMethodArgumentResolver = getUserPrincipal.class: " + principal.getClass().getName());
        Authentication auth = (Authentication) principal;
        return auth != null && auth.getPrincipal() instanceof User ? auth.getPrincipal() : null;
    }

}