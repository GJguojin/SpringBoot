package com.gj.test.service;

import com.gj.base.paginator.mybatis.PageList;
import com.gj.test.beans.Test;
import com.gj.test.search.TestSearch;

public interface ITestService{
	public Integer saveUser(Test user) throws Exception;

	public Integer editUser(Test user);

	public Integer deleteUser(Long userId) throws Exception;

	public Test selectById(Long userId);

	public PageList<Test> selectBySearch(TestSearch userSearch);
}
