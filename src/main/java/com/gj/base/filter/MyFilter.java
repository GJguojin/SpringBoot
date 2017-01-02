package com.gj.base.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName="myFilter",urlPatterns="/*")
public class MyFilter implements Filter {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		logger.debug("-----------------MyFilter 过滤器初始化-----------------");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.debug("-----------------MyFilter 执行过滤操作-----------------");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		logger.debug("-----------------MyFilter 过滤器销毁-----------------");
	}
}
