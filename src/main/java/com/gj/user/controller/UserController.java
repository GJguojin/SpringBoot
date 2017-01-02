package com.gj.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gj.base.controller.BaseController;
import com.gj.base.paginator.mybatis.PageList;
import com.gj.base.util.SpringUtil;
import com.gj.base.vo.MesJson;
import com.gj.user.beans.User;
import com.gj.user.search.UserSearch;
import com.gj.user.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping
	public String test(Model model){
		User user = userService.selectById(1L);
		UserSearch userSearch = new UserSearch();
		userSearch.setPage(1);
//		userSearch.setRows(2);
		PageList<User> userList = userService.selectBySearch(userSearch);
		model.addAttribute("name", user.getUserName());
		model.addAttribute("userList", userList);
		User user2 = userService.selectByUserName("root");
		model.addAttribute("user2", user2);
		return "test";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public MesJson testList(){
		UserSearch userSearch = new UserSearch();
		userSearch.setPage(0);
		IUserService userService1 = SpringUtil.getBean(IUserService.class);
		PageList<User> userList = userService1.selectBySearch(userSearch);
		MesJson json = new MesJson();
		json.setObjectList(userList);
		return json;
	}

}
