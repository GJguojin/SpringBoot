package com.gj.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gj.base.Interceptor.MyInterceptor;

/**
 * spring mvc 常用配置
 * @author Administrator
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	/**
	 * 添加静态资源映射
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
		super.addResourceHandlers(registry);
	}
	
	/**
	 *添加拦截器
	 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
