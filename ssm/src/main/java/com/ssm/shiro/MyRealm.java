package com.ssm.shiro;


import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.ssm.entity.User;
import com.ssm.service.IUserService;
import com.ssm.serviceImpl.UserServiceImpl;

public class MyRealm extends AuthorizingRealm  {
    
	@Resource
	private IUserService userService ;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token)throws AuthenticationException {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	    System.out.println("88888888888888888888888888888888888888888888888888888888888");
		//获取从页面传入的userName
		String userName = (String)token.getPrincipal();
		//从数据库获取userName和password
		//以下数据是从数据库获取
		//principal 认证实体信息 可以是username 也可以是 数据表对应的用户实体类对象
		User user = null;
		try {
			user = userService.findOneByName(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.err.println(user.getUserName());
		if(user != null){
			//抛出没有此账户
			throw new UnknownAccountException();
		}
		//盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(userName);
		//realmName : 当前realm对象的name 调用父类的getName() 方法即可
		String realmName = getName();
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
			user.getUserName(), //用户名
		    user.getPassword(), //密码
		    credentialsSalt, //盐值
		    realmName  //realm name
	    );
		return authenticationInfo;
	}
}
