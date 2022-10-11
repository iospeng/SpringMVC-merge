package com.it.scholar.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebControllerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    //重写该方法，用于指定加载Spring配置文件，不加载无法使用Spring的bean
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    //重写该方法，用于指定加载SpringMVC配置文件，不加载无法时使用SpringMVC的bean
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    //配置哪些路径的请求归SpringMVC处理，"/"代表所有请求都归SpringMVC处理
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //解决中文乱码
    @Override
    protected Filter[] getServletFilters() {
        //配置字符编码过滤器，设置编码格式为：utf-8
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("utf-8");
        return new Filter[]{characterEncodingFilter};
    }
}
