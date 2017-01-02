package com.gj.base.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gj.base.shiro.UserRealm;
import com.gj.base.util.mvc.CustomTimestampEditor;
import com.gj.user.beans.User;
import com.gj.user.service.IUserService;

public class BaseController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		timestampFormat.setLenient(true);
		binder.registerCustomEditor(Timestamp.class, new CustomTimestampEditor(timestampFormat, true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@ModelAttribute
	public void initParam(Model model) {
//		model.addAttribute( ProjectCodeBook.CAIBAN_URL, caibanUrl);
//		model.addAttribute( Constants.CAIBAN_DEALIER_MANAGE_URL, dealierManageUrl);
	}

	public Locale getLocale(HttpServletRequest request) {
		Locale locale = (Locale) request.getSession().getAttribute("_LocaleInfo");
		if (locale == null) {
			locale = LocaleContextHolder.getLocale();
		}
		return locale;
	}

	public void reSetSubmitToken(HttpServletRequest request) {
		request.getSession(false).setAttribute("submitToken", ""); // 提交的token
	}

	/**
	 * 得到当前登录人信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getCurrentUser() {
		Subject subject = SecurityUtils.getSubject();
		if (!subject.isAuthenticated()) {//
			return null;
		}
		
		
		
		T currentUser = (T) subject.getSession().getAttribute(UserRealm.CURRENT_USER);
		if (currentUser != null) {
			return currentUser;
		}
		String userName = (String) subject.getPrincipal();
		if (StringUtils.isBlank(userName)) {
			return null;
		}
//		UserServiceImpl bean = SpringUtil.getBean(UserServiceImpl.class);
		User user = userService.selectByUserName(userName);
		if (user == null) {
			return null;
		}
		subject.getSession().setAttribute(UserRealm.CURRENT_USER, user);
		return (T) user;
	}
}
