package com.wuxufang.controller;

import java.io.IOException;
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
import com.wuxufang.pojo.Brand;
import com.wuxufang.pojo.Spu;
import com.wuxufang.pojo.SpuVo;
import com.wuxufang.service.BrandService;
import com.wuxufang.service.SpuService;

//商品管理
@Controller
@RequestMapping("spu")
public class SpuController {

	@Reference
	SpuService spuService;

	@Reference
	BrandService brandService;

	@RequestMapping("list")
	public String list(HttpServletRequest request, SpuVo spuVo, @RequestParam(defaultValue = "1") int page) {
		PageInfo<Spu> pageInfo = spuService.list(page, spuVo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("spuVo", spuVo);
		return "spu/list";
	}

	// 跳转到添加页面
	@RequestMapping("toadd")
	public String toAdd(HttpServletRequest request) {
		List<Brand> brandList = brandService.listByFirst("");
		request.setAttribute("brandList", brandList);
		return "spu/add";
	}

	// 添加
	@ResponseBody
	@RequestMapping("add")
	public String add(HttpServletRequest request, Spu spu, @RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		// 上传文件
		String filePath = FileUtils.processFile(file);
		// 设置图片路径
		spu.setSmallPic(filePath);
		int result = spuService.add(spu);
		return result > 0 ? "success" : "failed";
	}

	// 删除
	@ResponseBody
	@RequestMapping("delBatch")
	public String delBatch(@RequestParam("ids[]") int ids[]) {
		int result = spuService.deleteBatch(ids);
		return result > 0 ? "success" : "failed";
	}

	// 跳转到修改页面
	@RequestMapping("toupdate")
	public String toupdate(HttpServletRequest request, int id) {
		//获取所有的品牌列表
		List<Brand> brandList = brandService.listByFirst("");
		//获取需要修改的数据回显
		Spu spu = spuService.getById(id);
		request.setAttribute("spu", spu);
		request.setAttribute("brandList", brandList);
		return "spu/update";
	}

	// 修改页面
	@ResponseBody
	@RequestMapping("update")
	public String update(HttpServletRequest request, Spu spu, @RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		// 上传文件
		String filePath = FileUtils.processFile(file);
		// 设置图片路径
		spu.setSmallPic(filePath);
		int result = spuService.add(spu);
		return result > 0 ? "success" : "failed";
	}
}
