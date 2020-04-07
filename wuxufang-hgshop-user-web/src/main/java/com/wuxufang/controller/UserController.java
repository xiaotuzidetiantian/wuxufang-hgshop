package com.wuxufang.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxufang.pojo.User;
import com.wuxufang.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Reference
	UserService userService;
	
	@RequestMapping("toregister")
	public String toRegister() {
		return "user/register";
	}
	
	@RequestMapping("register")
	public String register(User user,HttpServletRequest request) {
		int result = userService.register(user);
		if(result<1) {
			request.setAttribute("error", "注册失败");
			return "user/register";
		}
		return "redirect:/user/tologin";
	}
	
	@RequestMapping("tologin")
	public String toLogin() {
		return "user/login";
	}
	
	@RequestMapping("login")
	public String login(User user,HttpServletRequest request) {
		User loginUser = userService.login(user);
		if(loginUser==null) {
			request.setAttribute("error", "登录失败");
			request.getSession().removeAttribute("SESSION_KEY");
			return "user/login";
		}
		//存放session
		request.getSession().setAttribute("SESSION_KEY", loginUser);
		return "redirect:/user/home";
	}
}
