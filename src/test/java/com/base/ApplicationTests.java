package com.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gj.Application;
import com.gj.user.beans.User;
import com.gj.user.service.IUserService;

@SpringBootApplication
@ComponentScan(excludeFilters={@Filter(type=FilterType.ASSIGNABLE_TYPE,value={Application.class})})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private CacheManager cacheManager;

	@SuppressWarnings("unused")
	@Test
	public void contextLoads() {
		Cache cache = cacheManager.getCache("userService");
		ValueWrapper valueWrapper = cache.get("root");
		logger.info("---------------------------------------------");
		User user = userService.selectByUserName("root");
		logger.info("-----------------第一次----------------------------");
		user = userService.selectByUserName("root");
		logger.info("-----------------第二次----------------------------");
		cache = cacheManager.getCache("userService");
		valueWrapper = cache.get("root");
	}

}
