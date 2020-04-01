package com.wuxufang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wuxufang.pojo.Spec;
import com.wuxufang.pojo.SpecOption;
import com.wuxufang.service.SpecService;

//规格管理
@Controller
@RequestMapping("spec")
public class SpecController {
	@Reference
	SpecService specService;

	@RequestMapping("list")
	public String list(HttpServletRequest request, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "1") int page) {

		PageInfo<Spec> pageInfo = specService.list(name, page);
		request.setAttribute("pageInfo", pageInfo);
		return "spec/list";
	}

	@RequestMapping("toupdate")
	public String toupdate(HttpServletRequest request, int id) {
		Spec spec = specService.findById(id);
		request.setAttribute("spec", spec);
		return "spec/update";

	}

	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request, Spec spec) {
		System.out.println("spec" + spec);
		request.setAttribute("spec", spec);

		List<SpecOption> optionList = spec.getOptionList();
		//过滤空数据
		for (int i = optionList.size(); i > 0; i--) {
			SpecOption option = optionList.get(i - 1);
			if (option.getOptionName() == null && option.getOrders() == 0) {
				optionList.remove(i - 1);
			}
			option.setSpecId(spec.getId());
		}
		return specService.update(spec) > 0 ? "success" : "failed";

	}
}
