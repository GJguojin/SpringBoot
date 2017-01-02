package com.gj.test.beans;

import java.io.Serializable;

public class Test implements Serializable{
	private Long id;//  id
	private String userName;//  userName
	private java.util.Date userBirth;//  userBirth
	private String userEmail;//  userEmail
	private String realName;//  userEmail
	private String password;

	public Test(){
	}

	public Test(Long id){
		this.id = id;
	}

		/**
		 * id
		 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * id
	 */
	public Long getId() {
		return this.id;
	}
		/**
		 * userName
		 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * userName
	 */
	public String getUserName() {
		return this.userName;
	}
		/**
		 * userBirth
		 */
	public void setUserBirth(java.util.Date userBirth) {
		this.userBirth = userBirth;
	}

	/**
	 * userBirth
	 */
	public java.util.Date getUserBirth() {
		return this.userBirth;
	}
		/**
		 * userEmail
		 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * userEmail
	 */
	public String getUserEmail() {
		return this.userEmail;
	}

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
	
}

