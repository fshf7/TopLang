package com.top.lang.toplang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/access-denied").setViewName("denied");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/about").setViewName("about");
    }
}