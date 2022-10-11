package com.it.scholar.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //声明类为配置文件，代替配置文件中的系统配置
@ComponentScan({"com.it.scholar.dao","com.it.scholar.service"}) // 指定扫描路径，扫描指定路径下的Bean
@PropertySource("classpath:jdbc.properties") // 指定jdbc配置文件
@Import({JDBCConfig.class,mybatisConfig.class}) // 引用其他配置类
@EnableTransactionManagement // 开启事务，告诉spring项目中已经开启了事务
public class SpringConfig {
}
