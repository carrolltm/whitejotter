package com.evan.tm.config;

import com.evan.tm.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootConfiguration
//@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor getLoginIntercepter() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        // 对所有路径应用拦截器，除了 /index.html
        registry.addInterceptor(getLoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/index.html");
    }
    @Override

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "f:/workspace/img/");
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:D:/workspace/img/");
    }
}
