package com.it.scholar.config;

import com.it.scholar.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //声明类为配置文件，代替配置文件中的系统配置
@ComponentScan({"com.it.scholar.controller","com.it.scholar.config"}) //设置扫描路径（扫描指定包下的bean）
@EnableWebMvc //开启json转对象功能，不开启SpringMVC不会处理json数据
public class SpringMVCConfig{

}
//public class SpringMVCConfig implements WebMvcConfigurer {
//    @Autowired
//    private ProjectInterceptor projectInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(projectInterceptor).addPathPatterns("/findAll");
//    }
//}
