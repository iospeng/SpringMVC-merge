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
                afterCompletion()：原始方法正常执行（没有异常）执行完成后且postHandle方法执行后，执行后的方法
        2、定义配置类，继承WebMvcconfigurationSupport，实现addIntercepror方法（注意：扫描
            加载配置）
        3、在配置类中，添加拦截器并设定拦截的访问路径（拦截哪些接口），路径可以通过可变
            参数设置多个
            addInterceptor方法：设置拦截器类
            addPathPatterns方法：设置拦截的路径（访问接口） 指定拦截接口时，注意路径要写全，否则拦截不到
           注意：需将该配置文件加到SpringMVC的配置文件中，让SpringMVC扫描该配置文件
        注意：2、3步骤可以简写（侵入性较强）
            在SpringMVCConfig配置文件中，实现WebMvcConfigurer
            将2、3的配置全下载该配置文件中。这样该类就不用扫描2、3的配置文件了
 */
@Component //配置成bean
public class ProjectInterceptor implements HandlerInterceptor {

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
        System.out.println("preHandle：原始方法执行前");
        System.out.println("形参request:" + request.getHeader("User-Agent"));
        //将形参handler强转成HandlerMethod类型，再获得原始方法对象
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        //与原始方法对比，区别拦截的是哪个方法，做不同处理
        if(method.getName().equals(ScoreController.class.getMethod("findAll").getName())){
            System.out.println("原始方法" + method.getName());
        }
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
        System.out.println("postHandle:原始方法执行后");
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
        System.out.println("afterCompletion:原始方法执行后且postHandle方法执行后");
    }
}
