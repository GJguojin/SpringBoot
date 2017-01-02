package com.gj.user.service;

import org.springframework.cache.annotation.Cacheable;

import com.gj.base.paginator.mybatis.PageList;
import com.gj.user.beans.User;
import com.gj.user.search.UserSearch;

public interface IUserService{
	public Integer saveUser(User user) throws Exception;

	public Integer editUser(User user);

	public Integer deleteUser(Long userId) throws Exception;

	public User selectById(Long userId);
	
	@Cacheable("userService")
	public User selectByUserName(String userName);

	public PageList<User> selectBySearch(UserSearch userSearch);
}
