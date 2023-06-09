package com.board;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.board.intercepter.Intercepter;
import com.board.intercepter.IntercepterCheck;

@Configuration
public class WebConfiguration implements WebMvcConfigurer{

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(intercepter())
                .addPathPatterns("/api/v1/question/**");
    }
	
	@Bean
	public Intercepter intercepter() {
		return new Intercepter();
	}
	
	@Bean
	public IntercepterCheck IntercepterCheck() {
		return new IntercepterCheck();
	}
}
