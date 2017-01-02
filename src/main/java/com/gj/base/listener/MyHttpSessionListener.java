package com.gj.base.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用@WebListener注解，实现ServletContextListener接口
 *
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.debug("-----------------Session被创建-----------------");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.debug("-----------------Session被销毁-----------------");
	}

}
