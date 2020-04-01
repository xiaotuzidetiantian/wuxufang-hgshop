package com.wuxufang.service;

import java.util.List;

import com.wuxufang.pojo.Category;

public interface CategoryService {

	List<Category> getTree();

	int add(Category cat);
	
	int update(Category cat);
	
	int delete(int catId);

}
