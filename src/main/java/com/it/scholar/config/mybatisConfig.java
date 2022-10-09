package com.it.scholar.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class mybatisConfig {
    /*
        指定读取数据库后保存、封装数据的数据类
        该方法相当于给Spring指定封装读取到的数据的实现类（数据库表的映射类），让Spring自动创建实体类对象
        通过MapperScannerConfigurer方法指定的数据层接口，读取数据，然后封装到该方法指定的类中
        注：该方法指定的是文件夹，该文件夹下的所有的实现类（映射类），Spring会自动与Dao层的接口匹配
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean =new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage("com.it.scholar.domain");
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
    /*
        指定操作数据库的类（接口），自动封装读取的数据到与之对应实体类中
        注：该方法指定的是文件夹，该文件夹下的所有的接口，Spring会自动与实体类匹配
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer (){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.it.scholar.dao");
        return null;
    }
}
