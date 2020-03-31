package com.wuxufang.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wuxufang.pojo.Brand;

public interface BrandService {

	// 根据首字母查询
//	List<Brand> listByFirst(String firstChar);

	// 品牌列表
	PageInfo<Brand> list(String firstChar, Integer page, Integer pageSize);

	
}
