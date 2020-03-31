package com.wuxufang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.wuxufang.pojo.Brand;

public interface BrandDao {

	// 根据首字母查询
//	List<Brand> listByFirstChar(String firstChar);

	// 品牌列表
	List<Brand> list(@Param("firstChar") String firstChar);

	
}
