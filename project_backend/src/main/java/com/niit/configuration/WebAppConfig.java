package com.niit.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
// to create beans for all the classes under the package com.****....
@ComponentScan(basePackages = "com.niit")
public class WebAppConfig extends WebMvcConfigurerAdapter {

	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver(){
	       CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	       multipartResolver.setMaxUploadSize(20971520);//20MB
	       multipartResolver.setMaxInMemorySize(1048576);//1 MB
	       return multipartResolver;
}
}