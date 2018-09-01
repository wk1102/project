package com.ssm.dao;

import com.ssm.entity.User;

public interface UserDao {
	//注册
    void insert (User user);
    //登陆
    User findOneByName(String userName);
    //登陆
    User findOneByEmail(String email);
    //name 是否存在
    int userIsNull(String userName);
    //email 是否存在
    int emailIsNull(String email);
}
