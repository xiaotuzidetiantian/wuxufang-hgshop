package com.wuxufang.service;

import com.wuxufang.pojo.User;

public interface UserService {

	// 注册
	int register(User user);

	// 登录
	User login(User user);
}
