package com.ywf.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource ds){
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setTypeAliasesPackage("com.ywf.pojo");
        factoryBean.setDataSource(ds);
        Configuration configuration=new Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
        factoryBean.setConfiguration(configuration);
        factoryBean.setPlugins(new PageInterceptor());
        return factoryBean;
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScanner=new MapperScannerConfigurer();
        mapperScanner.setBasePackage("com.ywf.mapper");
        return mapperScanner;
    }
}
