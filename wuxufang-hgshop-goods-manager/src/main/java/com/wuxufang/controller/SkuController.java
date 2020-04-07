package com.wuxufang.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.wuxufang.common.FileUtils;
import com.wuxufang.pojo.Sku;
import com.wuxufang.pojo.SkuVo;
import com.wuxufang.pojo.Spec;
import com.wuxufang.pojo.SpecOption;
import com.wuxufang.pojo.Spu;
import com.wuxufang.service.SkuService;
import com.wuxufang.service.SpecService;
import com.wuxufang.service.SpuService;

@Controller
@RequestMapping("sku")
public class SkuController {

	@Reference
	SkuService skuService;

	@Reference
	SpuService spuService;

	@Reference
	SpecService specService;

	@RequestMapping("list")
	public String list(HttpServletRequest request, SkuVo skuVo, @RequestParam(defaultValue = "1") int page) {
		// 获取数据
		PageInfo<Sku> pageInfo = skuService.list(page, skuVo);
		// 查询条件回显
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("skuVo", skuVo);
		return "sku/list";
	}

	@RequestMapping("toadd")
	public String toAdd(HttpServletRequest request, int spuId) {
		Spu spu = spuService.getById(spuId);
		// 获取所有的规格列表
		List<Spec> specList = specService.listAll();
		request.setAttribute("spu", spu);
		request.setAttribute("specList", specList);
		return "sku/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request, Sku sku, int[] specId, int[] optionId, MultipartFile imageFile,
			MultipartFile cartFile) {

		// 构建sku的属性
		List<SpecOption> specOptionList = new ArrayList<SpecOption>();
		for (int i = 0; i < specId.length && i < optionId.length; i++) {
			SpecOption option = new SpecOption();
			option.setId(optionId[i]);
			option.setSpecId(specId[i]);
			// 添加到集合
			specOptionList.add(option);
		}
		// 将集合添加到封装bean中
		sku.setSpecOptionList(specOptionList);
		System.out.println("sku === " + sku);
		// 上传图片
		try {
			sku.setImage(FileUtils.processFile(imageFile));
			sku.setCartThumbnail(FileUtils.processFile(cartFile));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("sku === " + sku);

		return skuService.add(sku) > 0 ? "success" : "failed";

	}

	@RequestMapping("toupdate")
	public String toUpdate(HttpServletRequest request, int skuId) {
		Sku sku = skuService.getById(skuId);
		// 获取所有规格
		List<Spec> specList = specService.listAll();
		// 回显数据
		request.setAttribute("sku", sku);
		request.setAttribute("specList", specList);
		return "sku/update";
	}

	@ResponseBody
	@RequestMapping("update")
	public String update(HttpServletRequest request, Sku sku, int[] specId, int[] optionId, MultipartFile imageFile,
			MultipartFile cartFile) {
		// 构建sku的属性
		List<SpecOption> specOptionList = new ArrayList<SpecOption>();
		for (int i = 0; i < specId.length && i < optionId.length; i++) {
			SpecOption option = new SpecOption();
			option.setId(optionId[i]);
			option.setSpecId(specId[i]);
			// 添加到集合中
			specOptionList.add(option);
		}
		// 将集合添加到封装bean中
		sku.setSpecOptionList(specOptionList);
		System.out.println("sku === " + sku);
		// 上传图片
		try {
			sku.setImage(FileUtils.processFile(imageFile));
			sku.setCartThumbnail(FileUtils.processFile(cartFile));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("sku === " + sku);

		return skuService.update(sku) > 0 ? "success" : "failed";
	}
	
	@ResponseBody
	@RequestMapping("delBatch")
	public String delBatch(@RequestParam("ids[]")int ids[]) {
		int i = skuService.deleteBatch(ids);
		return i>0?"success":"failed";
	}

}
