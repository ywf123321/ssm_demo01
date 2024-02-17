package com.ywf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JDBCConfig.class,MybatisConfig.class})
public class SpringConfig {
}
