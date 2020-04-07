package com.wuxufang.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuxufang.dao.SkuDao;
import com.wuxufang.pojo.Sku;
import com.wuxufang.pojo.SkuVo;
import com.wuxufang.pojo.SpecOption;
import com.wuxufang.service.SkuService;

@Service(interfaceClass = SkuService.class)
public class SkuServiceImpl implements SkuService {

	@Autowired
	SkuDao skuDao;

	@Override
	public int add(Sku sku) {
		// 必须生成主键，添加到主表
		int result = skuDao.add(sku);
		List<SpecOption> optionList = sku.getSpecOptionList();
		for (SpecOption specOption : optionList) {
			// 插入子表
			result += skuDao.addSkuSpec(sku.getId(), specOption);
		}
		return result;
	}

	@Override
	public int deleteBatch(int[] ids) {
		// 删除主表
		int result = skuDao.deleteBatch(ids);
		// 删除子表
		result = skuDao.deleteSkuSpec(ids);
		return result;
	}

	@Override
	public int update(Sku sku) {
		// 修改主表
		int result = skuDao.update(sku);
		// 删除子表相关数据
		result += skuDao.deleteSkuSpec(sku.getId());
		// 插入子表
		List<SpecOption> optionList = sku.getSpecOptionList();
		//插入子表
		for (SpecOption specOption : optionList) {
			//子表
			result += skuDao.addSkuSpec(sku.getId(),specOption);
		}
		return result;
	}

	@Override
	public PageInfo<Sku> list(int page, SkuVo skuVo) {
		PageHelper.startPage(page, 10);
		return new PageInfo<Sku>(skuDao.list(skuVo));
	}

	@Override
	public Sku getById(int id) {
		return skuDao.getById(id);
	}

}
