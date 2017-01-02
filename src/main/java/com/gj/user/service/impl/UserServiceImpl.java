package com.gj.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gj.base.paginator.mybatis.PageList;
import com.gj.user.beans.User;
import com.gj.user.dao.UserDao;
import com.gj.user.search.UserSearch;
import com.gj.user.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;

	@Override
	public Integer saveUser(User user) throws Exception {
		return userDao.insert(user);
	}

	@Override
	public Integer editUser(User user) {
		return userDao.update(user);
	}

	@Override
	public Integer deleteUser(Long userId) throws Exception {
		return userDao.delete(userId);
	}

	@Override
	public User selectById(Long userId) {
		return userDao.selectById(userId);
	}

	@Override
	public PageList<User> selectBySearch(UserSearch userSearch) {
		return userDao.selectBySearch(userSearch);
	}

	@Override
	public User selectByUserName(String userName) {
		logger.info("=========没有使用缓存============");
		return userDao.selectByUserName(userName);
	}
}