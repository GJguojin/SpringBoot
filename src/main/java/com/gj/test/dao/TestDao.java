package com.gj.test.dao;

import com.gj.base.dao.BaseDao;
import com.gj.base.paginator.mybatis.PageList;
import com.gj.test.beans.Test;
import com.gj.test.search.TestSearch;


public interface TestDao extends BaseDao<Test>{
	
	public PageList<Test> selectBySearch( TestSearch userSearch );

}
