package com.wuxufang.dao;

import java.util.List;

import com.wuxufang.pojo.Category;

public interface CategoryDao {

	//根据父id获取列表
	List<Category> listByParentId(int pid);

	//添加
	int add(Category cat);

	int update(Category cat);

	int delete(int catId);

	
}
