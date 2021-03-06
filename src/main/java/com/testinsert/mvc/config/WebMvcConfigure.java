package com.testinsert.mvc.config;

import com.testinsert.mvc.Interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfigure implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/index")
                .addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/register");

    }
}
