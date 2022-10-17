package com.it.scholar.controller;

import com.it.scholar.domain.ResponseData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
异常处理器：
    概述：集中的、统一的处理项目中出现的异常
    使用：
        1、加载：
            该类写在任意包下，所以需要再配置文件中指明，该类在那个包下，
            使用@ComponentScan注解，与Spring、SpringMVC指明加载bean的一致
        2、格式：
            声明这个类是用来做异常处理的注解
                @ControllerAdvice: 该类的方法方法返回json数据时，需要加
                @ResponseBody注解
                @RestControllerAdvice: 该注解包含@ControllerAdvice，但该类的方法返
                    回json数据时，不需要加@ResponseBody注解
            告诉异常处理器，拦截的是哪一类异常使用的注解
                @ExceprionHandler(Exception.class)：表示拦截所有异常
        3、返回数据格式
            该方法返回我们封装的，统一返回给前端的类
 */
@ControllerAdvice
//@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseData doException(Exception exception){
        return new ResponseData(500,null,"出错啦！");
    }
}
