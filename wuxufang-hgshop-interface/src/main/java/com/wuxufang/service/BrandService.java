package com.wuxufang.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wuxufang.pojo.Brand;

public interface BrandService {

	List<Brand> listByFirst(String firstChar);

	PageInfo<Brand> list(int page);

	int update(Brand brand);

	Brand brandById(int id);
}
