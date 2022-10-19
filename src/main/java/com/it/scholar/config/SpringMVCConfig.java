package com.it.scholar.config;

import com.it.scholar.controller.interceptor.ProjectInterceptor;
import com.it.scholar.controller.interceptor.ProjectInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //声明类为配置文件，代替配置文件中的系统配置
//@ComponentScan({"com.it.scholar.controller","com.it.scholar.config"}) //设置扫描路径（扫描指定包下的bean）
@ComponentScan("com.it.scholar.controller") //设置扫描路径（扫描指定包下的bean）
@EnableWebMvc //开启json转对象功能，不开启SpringMVC不会处理json数据
//public class SpringMVCConfig{
//
//}
public class SpringMVCConfig implements WebMvcConfigurer {
    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Autowired
    private ProjectInterceptor2 projectInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //指定拦截接口时，注意路径要写全，否则拦截不到，若需要拦截多个接口，可用逗号分割
        registry.addInterceptor(projectInterceptor).addPathPatterns("/user/findAll","/user/findById");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/user/findAll","/user/findById");
    }
}
