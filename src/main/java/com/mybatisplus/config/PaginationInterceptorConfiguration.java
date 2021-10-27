package com.mybatisplus.config;



import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册PaginationInterceptor对象到容器
 * @author lml
 * @date 2021-10-25
 */
@MapperScan("com.mybatisplus.mapper")
@Configuration
public class PaginationInterceptorConfiguration {


    @Bean
    public PaginationInterceptor getPaginationInterceptor(){
        return  new PaginationInterceptor();
    }
}
