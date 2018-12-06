package com.zyy.blog.commons.config;

import com.zyy.blog.commons.utils.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    /**
     * 登录session key
     */
    public static final String SESSION_KEY = "user";

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        // 排除配置
        addInterceptor.excludePathPatterns("/user");
        addInterceptor.excludePathPatterns("/login");
        addInterceptor.excludePathPatterns("/Dologin");
        addInterceptor.excludePathPatterns("/select");
        addInterceptor.excludePathPatterns("/selectAllUser");
        addInterceptor.excludePathPatterns("/insertMenu");
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }
}
