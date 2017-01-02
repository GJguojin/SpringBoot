package com.gj.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gj.base.controller.BaseController;
import com.gj.base.paginator.mybatis.PageList;
import com.gj.base.util.SpringUtil;
import com.gj.base.vo.MesJson;
import com.gj.test.beans.Test;
import com.gj.test.search.TestSearch;
import com.gj.test.service.ITestService;
import com.gj.user.beans.User;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController{
	
	@Autowired
	private ITestService userService;
	
	@RequestMapping
	public String test(Model model){
		User currentUser = getCurrentUser();
		Test user = userService.selectById(1L);
		TestSearch userSearch = new TestSearch();
		userSearch.setPage(1);
//		userSearch.setRows(2);
		PageList<Test> userList = userService.selectBySearch(userSearch);
		model.addAttribute("name", user.getUserName());
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("userList", userList);
		return "test";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public MesJson testList(){
		TestSearch userSearch = new TestSearch();
		userSearch.setPage(0);
		ITestService userService1 = SpringUtil.getBean(ITestService.class);
		PageList<Test> userList = userService1.selectBySearch(userSearch);
		MesJson json = new MesJson();
		json.setObjectList(userList);
		return json;
	}
	
	@ResponseBody
	@RequestMapping("/zeroException")
    public int zeroException(){
       return 100/0;
    }

}
