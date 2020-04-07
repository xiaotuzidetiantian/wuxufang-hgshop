package com.wuxufang.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.wuxufang.dao.UserDao;
import com.wuxufang.pojo.User;
import com.wuxufang.service.UserService;

@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public int register(User user) {
		//判断是否存在同名用户
		User existUser = userDao.findByUsername(user.getName());
		if(existUser!=null) {
			return-1;
		}
		return userDao.add(user);
	}

	@Override
	public User login(User user) {
		return userDao.findUser(user);
	}

}
