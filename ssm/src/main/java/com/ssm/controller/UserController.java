package com.ssm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Resource;

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
	 * Ìø×ªµ½µÇÂ¼Ò³Ãæ
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
	
	
	
}
