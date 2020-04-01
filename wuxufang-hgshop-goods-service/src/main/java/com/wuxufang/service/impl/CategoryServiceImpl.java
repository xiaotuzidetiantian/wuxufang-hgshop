package com.wuxufang.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.wuxufang.dao.CategoryDao;
import com.wuxufang.pojo.Category;
import com.wuxufang.service.CategoryService;

@Service(interfaceClass = CategoryService.class)
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getTree() {
		return categoryDao.listByParentId(0);
	}

	@Override
	public int add(Category cat) {
		return categoryDao.add(cat);
	}

	@Override
	public int update(Category cat) {
		return categoryDao.update(cat);
	}

	@Override
	public int delete(int catId) {
		return categoryDao.delete(catId);
	}

}
