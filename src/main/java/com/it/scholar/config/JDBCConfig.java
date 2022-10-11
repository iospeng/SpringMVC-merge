package com.it.scholar.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class JDBCConfig {
    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${name}")
    private String userName;
    @Value("${password}")
    private String passWord;

    @Bean
    public DataSource dataSource(){
        DruidDataSource druid = new DruidDataSource();
        druid.setDriverClassName(driver);
        druid.setUrl(url);
        druid.setUsername(userName);
        druid.setPassword(passWord);
        return druid;
    }

    //事务管理器，定义成bean，交给Spring管理
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return  dataSourceTransactionManager;
    }

}
