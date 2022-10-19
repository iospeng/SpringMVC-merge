package com.it.scholar.controller.interceptor;

import com.it.scholar.controller.ScoreController;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/*
拦截器链
    概述：配置多个拦截器，形参拦截器类
    实现步骤
        1、再定义一个拦截器类
        2、配置文件的addInterceptors中，再指定一个拦截器类，和拦截的接口
    执行顺序：
        preHandle：先配置那个拦截器类，就先执行那个
        postHandle：先配置后执行，可能不执行
        afterCompletion：先配置后执行，可能不执行
    注意：若第一个拦截器的preHandle方法返回的是false,则不单单是该拦截器拦截的原始方法
        终止执行，后面的拦截器，和他拦截的原始方法也终止执行
 */
@Component //配置成bean
public class ProjectInterceptor2 implements HandlerInterceptor {

    /*
        preHandle()：原始方法执行前，执行的方法
            该方法的返回值为：true，表示原始方法正常执行
            该方法的返回值为：false，表示终止原始方法执行
     */

    /**
     *
     * @param request 是指经过spring封装的请求对象, 包含请求地址, 头, 参数, body(流)等信息.
     * @param response 是指经过spring封装的响应对象, 包含输入流, 响应body类型等信息.
     * @param handler 是指controller的@Controller注解下的"完整"方法名, 是包含exception等字段信息的.
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle：原始方法执行前——拦截器2");
        return true;
    }

    /**
     *
     * @param request 是指经过spring封装的请求对象, 包含请求地址, 头, 参数, body(流)等信息.
     * @param response 是指经过spring封装的响应对象, 包含输入流, 响应body类型等信息.
     * @param handler 是指controller的@Controller注解下的"完整"方法名, 是包含exception等字段信息的.
     * @param modelAndView 封装响应数据为页面时的，页面数据
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle:原始方法执行后——拦截器2");
    }

    /**
     *
     * @param request 是指经过spring封装的请求对象, 包含请求地址, 头, 参数, body(流)等信息.
     * @param response 是指经过spring封装的响应对象, 包含输入流, 响应body类型等信息.
     * @param handler 是指controller的@Controller注解下的"完整"方法名, 是包含exception等字段信息的.
     * @param ex 是指原始程序报的异常
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion:原始方法执行后且postHandle方法执行后——拦截器2");
    }
}
