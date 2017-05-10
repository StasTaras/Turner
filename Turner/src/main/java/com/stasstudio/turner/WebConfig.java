package com.stasstudio.turner;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.logging.Logger;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    private static final Logger log = Logger.getLogger(WebConfig.class.getName());

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.warning("=================== Adding CORS requests support for /** =====================");
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
