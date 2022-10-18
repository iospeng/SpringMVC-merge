package com.it.scholar.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
拦截器（Interceptor）
    拦截器概念
        概述：拦截器是一种动态拦截方法调用的集资，在SpringMVC中动态拦截控制器方法的执行
            入门案例
    作用：
        在指定的方法调用前后执行预先设定的代码
        阻止原始方法的执行
    拦截器预过滤器的区别
            归属不同：Filter属于Servlet技术，Interceptor属于SpringMVC技术
            拦截内容不同：Filter对所有访问进行增强，Interceptor仅针对SpringMVC的访问进行增强
    实现步骤
        1、声明拦截器的bean，并实现HandlerInterceptor接口，（注意：扫描加载bean）
            需使用@Component将该类声明成bean
            一般该类配置在表现层controller层
            实现接口的三个方法
                preHandle()：原始方法执行前，执行的方法
                    该方法的返回值为：true，表示原始方法正常执行
                    该方法的返回值为：flash，表示终止原始方法执行
                postHandle()：原始方法执行后，执行的方法
                afterCompletion()：原始方法执行完成后且postHandle方法执行后，执行后的方法
        2、定义配置类，继承WebMvcconfigurationSupport，实现addIntercepror方法（注意：扫描
            加载配置）
        3、在配置类中，添加拦截器并设定拦截的访问路径（拦截哪些接口），路径可以通过可变
            参数设置多个
            addInterceptor方法：设置拦截器类
            addPathPatterns方法：设置拦截的路径（访问接口）
           注意：需将该配置文件加到SpringMVC的配置文件中，让SpringMVC扫描该配置文件
        注意：2、3步骤可以简写（侵入性较强）
            在SpringMVCConfig配置文件中，实现WebMvcConfigurer
            将2、3的配置全下载该配置文件中。这样该类就不用扫描2、3的配置文件了
 */
@Component
public class ProjectInterceptor implements HandlerInterceptor {

    /*
        preHandle()：原始方法执行前，执行的方法
            该方法的返回值为：true，表示原始方法正常执行
            该方法的返回值为：false，表示终止原始方法执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle：原始方法执行前");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle:原始方法执行后");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion:原始方法执行后且postHandle方法执行后");
    }
}
