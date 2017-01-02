package com.gj.base.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务
 * @author Administrator
 *
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	
    @Scheduled(cron = "0/20 * * * 10 ?") // 每20秒执行一次
    public void scheduler() {
    	logger.debug(">>>>>>>>> SchedulingConfig.scheduler()");
    }
}
