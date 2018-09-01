package com.ssm.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String id;//id
	private String userName;//用户名
	private String password;//密码
	private String userSex;//性别
	private String userCredentialsType; //证件类型
	private String userCredentialsNumber;//证件号
	private String userAddress;//用户地址
	private String userCellphone;//手机号
	private String userEmail;//邮箱
	private String type;//类型
	private Date createTime;//注册的时间
	private String delFlag;//删除标记 (0未删除,1删除)
	private String common; //备注
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserCredentialsType() {
		return userCredentialsType;
	}
	public void setUserCredentialsType(String userCredentialsType) {
		this.userCredentialsType = userCredentialsType;
	}
	public String getUserCredentialsNumber() {
		return userCredentialsNumber;
	}
	public void setUserCredentialsNumber(String userCredentialsNumber) {
		this.userCredentialsNumber = userCredentialsNumber;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserCellphone() {
		return userCellphone;
	}
	public void setUserCellphone(String userCellphone) {
		this.userCellphone = userCellphone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", userSex=" + userSex
				+ ", userCredentialsType=" + userCredentialsType + ", userCredentialsNumber=" + userCredentialsNumber
				+ ", userAddress=" + userAddress + ", userCellphone=" + userCellphone + ", userEmail=" + userEmail
				+ ", type=" + type + ", createTime=" + createTime + ", delFlag=" + delFlag + ", common=" + common + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
