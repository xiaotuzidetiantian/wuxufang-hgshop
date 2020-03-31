package com.wuxufang.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wuxufang.pojo.Brand;
import com.wuxufang.service.BrandService;

@Controller
@RequestMapping("brand")
public class BrandController {

	@Reference
	private BrandService brandService;

	// 品牌列表
	@RequestMapping("list")
	public String list(HttpServletRequest request, String firstChar, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "3") Integer pageSize) {
		PageInfo<Brand> info = brandService.list(firstChar, page, pageSize);
		request.setAttribute("info", info);
		request.setAttribute("firstChar", firstChar);
		return "brand/list";
	}

}
