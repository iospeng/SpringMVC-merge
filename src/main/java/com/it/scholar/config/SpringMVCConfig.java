package com.it.scholar.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration //声明类为配置文件，代替配置文件中的系统配置
@ComponentScan("com.it.scholar.controller") //设置扫描路径（扫描指定包下的bean）
@EnableWebMvc //开启json转对象功能，不开启SpringMVC不会处理json数据
public class SpringMVCConfig {
}
