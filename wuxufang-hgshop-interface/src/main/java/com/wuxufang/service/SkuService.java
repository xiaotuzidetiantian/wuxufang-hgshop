package com.wuxufang.service;

import com.github.pagehelper.PageInfo;
import com.wuxufang.pojo.Sku;
import com.wuxufang.pojo.SkuVo;

public interface SkuService {

	//添加
	int add(Sku sku);
	//批量删除
	int deleteBatch(int ids[]);
	//修改
	int update(Sku sku);
	//列表
	PageInfo<Sku> list(int page,SkuVo skuVo);
	//获取一个sku 修改回显 详情
	Sku getById(int id);
}
