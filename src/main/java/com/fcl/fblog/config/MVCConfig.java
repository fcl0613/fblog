package com.fcl.fblog.config;

import com.fcl.fblog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //windows
//        registry.addResourceHandler("/img/cover/**")
//                .addResourceLocations("file:" + System.getProperty("user.dir") +
//                        System.getProperty("file.separator") + "img"+
//                        System.getProperty("file.separator"));
        //linux
//         /usr/local/tomcat/bin
        registry.addResourceHandler("/img/cover/**")
                .addResourceLocations("file:"+System.getProperty("file.separator")+"usr"+
                        System.getProperty("file.separator")+"local"+
                        System.getProperty("file.separator")+"tomcat"+
                        System.getProperty("file.separator")+"bin"+
                        System.getProperty("file.separator")+"img"+
                        System.getProperty("file.separator"));
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/login.html")
                .excludePathPatterns("/admin/dologin")
                .excludePathPatterns("/static/**");
    }
}
