package com.ssm.entity;

import java.io.Serializable;

public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String id;
	private String userName;
	private String userSex;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userSex=" + userSex + "]";
	}
	

	
	
	
	
	
}
