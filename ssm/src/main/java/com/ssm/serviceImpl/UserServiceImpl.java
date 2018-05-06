package com.ssm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.UserDao;
import com.ssm.entity.User;
import com.ssm.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserDao userDao;
	
	public List<User> selectUserList() {
		// TODO Auto-generated method stub
		return  userDao.queryUserList();
	}

	public User findOne(User user) {
		
		return userDao.findOne(user);
	}

}
