package com.gj.test.search;

import org.apache.ibatis.type.Alias;

import com.gj.base.search.BaseSearch;
@Alias("TestSearch")
public class TestSearch extends BaseSearch{
	private Long id; //   id
	private String userName; //   userName
	private java.util.Date userBirth; //   userBirth
	private String userEmail; //   userEmail
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String realName;//  userEmail
	private String password;


	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setUserName(String value) {
		this.userName = value;
	}
	
	public String getUserName() {
		return this.userName;
	}

	public void setUserBirth(java.util.Date value) {
		this.userBirth = value;
	}
	
	public java.util.Date getUserBirth() {
		return this.userBirth;
	}
	public void setUserEmail(String value) {
		this.userEmail = value;
	}
	
	public String getUserEmail() {
		return this.userEmail;
	}

}

