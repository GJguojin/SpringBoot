package com.gj.user.dao;

import org.apache.ibatis.annotations.Select;

import com.gj.base.dao.BaseDao;
import com.gj.base.paginator.mybatis.PageList;
import com.gj.user.beans.User;
import com.gj.user.search.UserSearch;

public interface UserDao extends BaseDao<User>{
	
	public PageList<User> selectBySearch( UserSearch userSearch );
	
	@Select("select * from t_user where userName=#{userName} limit 1")
	public User selectByUserName(String userName);

}
