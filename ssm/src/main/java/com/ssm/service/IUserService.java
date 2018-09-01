package com.ssm.service;

import com.ssm.entity.User;

public interface IUserService {
	
	
	User findOneByName (String userName)throws Exception;
	
	User findOneByEmail(String email)throws Exception;
	
	void insert (String userName,String password)throws Exception;
	
	int userIsNull(String userName)throws Exception;
	
	int emailIsNull(String email)throws Exception; 
}
