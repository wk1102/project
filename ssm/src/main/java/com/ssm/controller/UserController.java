package com.ssm.controller;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.entity.User;
import com.ssm.service.IUserService;
import com.ssm.ultimate.Ultimate;
import com.ssm.util.ResultMap;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
	private IUserService userService;
    
    //日志类
    private static final Logger log = LogManager.getLogger(UserController.class.getName());
    
  
	/**
	 * 跳转到登陆页面
	 * @return
	 */
	@RequestMapping("/loginHtml")
	public String loginHtml1(){
		return "login";
	}
	
	@RequestMapping("/wk")
	public String loginHtml(){
		return "wk";
	}
	/**
	 * 注册
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/register")
	@ResponseBody
	public ResultMap register (String userName,String password ) throws Exception{
		ResultMap result = new ResultMap();
		if(StringUtils.isEmpty(userName)){
			result.setMsg(Ultimate.MSG_2);
			return result;
		}
		if(StringUtils.isEmpty(password)){
			result.setMsg(Ultimate.MSG_3);
			return result;
		}
		int num = userService.userIsNull(userName);
		if(num < 1){
			userService.insert(userName, password);
			result.setCode(1);
			result.setMsg(Ultimate.MSG_1);
		}else{
			result.setMsg(Ultimate.MSG_4);
		}
		
		return result;
	}
	/**
	 * 判断用户名是否存在
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/nameIsNull")
	@ResponseBody
	public ResultMap nameIsNull(String userName) throws Exception{
		ResultMap result = new ResultMap();
		if(!StringUtils.isEmpty(userName)){
			int num = userService.userIsNull(userName);
			result.setCode(1);
			result.setMsg(Ultimate.MSG_5);
			result.setData(num);
		}else{
			result.setMsg(Ultimate.MSG_2);
			return result;
		}
		return result;
	}
	/**
	 * 判断邮箱是否存在
	 * @param email
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/emailIsNull")
	@ResponseBody
	public ResultMap emailIsNull(String email) throws Exception{
		ResultMap result = new ResultMap();
		if(!StringUtils.isEmpty(email)){
			int num = userService.emailIsNull(email);
			result.setCode(1);
			result.setMsg(Ultimate.MSG_5);
			result.setData(num);
		}else{
			result.setMsg(Ultimate.MSG_2);
			return result;
		}
		return result;
	}
	
	/**
	 * 用户的登陆方法
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public ResultMap login(String userName,String password){
		System.err.println(userName);
		System.out.println(password);
		ResultMap result = new ResultMap();
		
		return result;
	}
	
	/**
	 * 用户登出的方法
	 * @return
	 */
	@RequestMapping("logout")
	public String logout () {
//		//调用shiro的获取subject的方法
//		Subject subject = SecurityUtils.getSubject();
//		//调用shiro的登出的方法
//		subject.logout();
		return "login";
	}
	
	
}
