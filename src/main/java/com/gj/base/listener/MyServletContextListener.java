package com.gj.base.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 监听Session的创建与销毁
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.debug("-----------------ServletContex销毁-----------------");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.debug("-----------------ServletContex初始化-----------------");
	}

}
