package com.wuxufang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.wuxufang.pojo.Brand;

public interface BrandDao {

	List<Brand> listByFirstChar(String firstChar);

	List<Brand> list();

	Brand getById(int id);

	int update(Brand brand);
}
