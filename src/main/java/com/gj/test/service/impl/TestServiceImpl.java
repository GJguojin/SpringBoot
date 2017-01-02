package com.gj.test.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gj.base.paginator.mybatis.PageList;
import com.gj.test.beans.Test;
import com.gj.test.dao.TestDao;
import com.gj.test.search.TestSearch;
import com.gj.test.service.ITestService;

@Service
@Transactional
public class TestServiceImpl implements ITestService {
	public static Log log = LogFactory.getLog(TestServiceImpl.class);
	@Autowired
	private TestDao userDao;

	@Override
	public Integer saveUser(Test user) throws Exception {
		return userDao.insert(user);
	}

	@Override
	public Integer editUser(Test user) {
		return userDao.update(user);
	}

	@Override
	public Integer deleteUser(Long userId) throws Exception {
		return userDao.delete(userId);
	}

	@Override
	public Test selectById(Long userId) {
		return userDao.selectById(userId);
	}

	@Override
	public PageList<Test> selectBySearch(TestSearch userSearch) {
		return userDao.selectBySearch(userSearch);
	}
}