package com.gj.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 在spring boot中添加自己的Servlet有两种方法，代码注册Servlet和注解自动注册（Filter和Listener也是如此）。 
 * 一、代码注册通过ServletRegistrationBean、 FilterRegistrationBean 和 ServletListenerRegistrationBean 获得控制。 
 * 也可以通过实现 ServletContextInitializer 接口直接注册。
 * 二、在 SpringBootApplication 上使用@ServletComponentScan注解后，Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码。
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = "/myServlet/*", description = "Servlet的说明")
public class MyServlet extends HttpServlet {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug(">>>>>>>>>>doGet()<<<<<<<<<<<");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug(">>>>>>>>>>doPost()<<<<<<<<<<<");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World</title>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>这是：myServlet</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
