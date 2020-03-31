package com.wuxufang.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuxufang.dao.BrandDao;
import com.wuxufang.pojo.Brand;
import com.wuxufang.service.BrandService;

@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;

//	@Override
//	public List<Brand> listByFirst(String firstChar) {
//		
//		return brandDao.listByFirstChar(firstChar);
//	}

	// 品牌列表
	@Override
	public PageInfo<Brand> list(String firstChar, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Brand> list = brandDao.list(firstChar);
		PageInfo<Brand> info = new PageInfo<Brand>(list);
		return info;
	}

	
}
