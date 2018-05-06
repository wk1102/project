package com.ssm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.entity.User;
import com.ssm.service.IUserService;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
	private IUserService userService;
    
	@RequestMapping("list")
	@ResponseBody
	public List<User> list () throws Exception{
	
		return userService.selectUserList();
	}
	
	@RequestMapping("findOne")
	@ResponseBody
	public User findOne(User user) throws Exception{
		
		return userService.findOne(user);
	}
	
	/**
	 * 用户的登陆方法
	 * @return
	 */
	@RequestMapping("login")
	public String login(){
		
		return "login";
	}
	
	
	public boolean filed (User user,Predicate<User> t){
		List<User> list = new ArrayList<User>();
		list.parallelStream();
		
		return t.test(user);
	}
	
	
	/**
	 * 用户登出的方法
	 * @return
	 */
	@RequestMapping("logout")
	public String logout () {
		//调用shiro的获取subject的方法
		Subject subject = SecurityUtils.getSubject();
		//调用shiro的登出的方法
		subject.logout();
		return "login";
	}
	
	
}
