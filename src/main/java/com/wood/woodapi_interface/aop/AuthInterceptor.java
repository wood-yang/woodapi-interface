package com.wood.woodapi_interface.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * 权限校验 AOP
 *
*
 */
@Aspect
@Component
public class AuthInterceptor {

    @Pointcut(value =
            "execution(* com.wood.woodapi_interface.controller.*.*(..))")
    private void aspectPointcut() {

    }

    @Before(value = "aspectPointcut()")
    public void aspectBefore(JoinPoint joinPoint) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        // 如果有session则返回session如果没有则返回null(避免创建过多的session浪费内存)
        HttpSession session = request.getSession(false);
        // 获取请求头
        boolean flag = false;
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            if ("source".equals(name) && "gateway".equals(value)) {
                flag = true;
            }
        }
        if (!flag) {
            throw new RuntimeException();
        }
    }
}

