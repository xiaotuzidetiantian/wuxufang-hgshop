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
	private SpecService specService;

}
