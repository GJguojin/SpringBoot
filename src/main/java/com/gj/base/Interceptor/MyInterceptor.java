package com.gj.base.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 配置拦截器也很简单，Spring 为什么提供了基础类WebMvcConfigurerAdapter ，我们只需要重写 addInterceptors 方法添加注册拦截器。
 * 实现自定义拦截器只需要3步： 
 * 1、创建我们自己的拦截器类并实现 HandlerInterceptor 接口。 
 * 2、创建一个Java类继承WebMvcConfigurerAdapter，并重写 addInterceptors 方法。 
 * 2、实例化我们自定义的拦截器，然后将对像手动添加到拦截器链中（在addInterceptors方法中添加）。 
 * @author Administrator
 *
 */
public class MyInterceptor implements HandlerInterceptor {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.debug(">>>MyInterceptor.preHandle>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
		return true;// 只有返回true才会继续向下执行，返回false取消当前请求
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		logger.debug(">>>MyInterceptor.preHandle>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
		logger.debug(">>>MyInterceptor.afterCompletion>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
	}

}
