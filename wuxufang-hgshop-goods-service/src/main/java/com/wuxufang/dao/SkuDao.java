package com.wuxufang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuxufang.pojo.Sku;
import com.wuxufang.pojo.SkuVo;
import com.wuxufang.pojo.SpecOption;

public interface SkuDao {

	int add(Sku sku);

	// 规格和属性值
	int addSkuSpec(@Param("skuId") Integer skuId, @Param("specOpt") SpecOption specOption);

	int deleteBatch(int[] ids);

	int deleteSkuSpec(int...ids);

	int update(Sku sku);

//	int deleteSkuSpec(Integer id);

	List<Sku> list(SkuVo skuVo);

	Sku getById(int id);

}
