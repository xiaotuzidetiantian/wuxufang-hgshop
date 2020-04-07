package com.wuxufang.dao;

import com.wuxufang.pojo.User;

public interface UserDao {

	int add(User user);

	User findUser(User user);

	User findByUsername(String name);

}
