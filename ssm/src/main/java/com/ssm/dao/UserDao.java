package com.ssm.dao;

import java.util.List;

import com.ssm.entity.User;

public interface UserDao {
	List<User> queryUserList();
	
	User findOne(User user);
}
