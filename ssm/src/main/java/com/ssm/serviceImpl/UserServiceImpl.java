package com.ssm.serviceImpl;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ssm.dao.UserDao;
import com.ssm.entity.User;
import com.ssm.service.IUserService;
import com.ssm.ultimate.Ultimate;
import com.ssm.util.Utils;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserDao userDao;

	/**
	 * 通过userName查询(登陆时用)
	 */
	public User findOneByName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findOneByName(userName);
	}

	/**
	 * 添加用户(注册时候用)
	 */
	public void insert(String userName, String password) throws Exception {
		// TODO Auto-generated method stub
		if(!(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password))){
//			//盐值
//			Object slat = ByteSource.Util.bytes(userName);
//			//使用md5加密,加密次数是100
//			Object passwords =new SimpleHash(Ultimate.ENCRYPT_TYPE,password,slat,Ultimate.ENCRYPT_NUM);
			User user = new User ();
			user.setCreateTime(new Date());
			user.setId(Utils.getUUID());
			user.setUserName(userName);
			//user.setPassword(passwords.toString());
			userDao.insert(user);
		}
	}
    /**
     * 判断userName 是否存在(前端数据校验时用)
     */
	@Override
	public int userIsNull(String userName) throws Exception {
		// TODO Auto-generated method stub
		return userDao.userIsNull(userName);
	}
    /**
     * 判断email 是否存在(前端数据校验时用)
     */
	@Override
	public int emailIsNull(String email) throws Exception {
		// TODO Auto-generated method stub
		return userDao.userIsNull(email);
	}
    /**
     * 邮箱登陆使用
     */
	@Override
	public User findOneByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findOneByEmail(email);
	}
	

}
