package com.gj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
//@MapperScan("com.gj.*.dao")
@ServletComponentScan // 这个就是扫描相应的Servlet包;
@SpringBootApplication
@EnableCaching
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 
	 * 注册Servlet.不需要添加注解：@ServletComponentScan
	 * 不使用@WebServlet(urlPatterns = "/myServlet/*", description = "Servlet的说明")
	 * @return
	 */
//	@Bean
//	public ServletRegistrationBean myServlet() {
//		return new ServletRegistrationBean(new MyServlet(), "/myServlet/*");
//	}
}
