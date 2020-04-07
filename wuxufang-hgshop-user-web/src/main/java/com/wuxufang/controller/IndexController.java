package com.wuxufang.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wuxufang.pojo.Category;
import com.wuxufang.pojo.Spu;
import com.wuxufang.pojo.SpuVo;
import com.wuxufang.service.CategoryService;
import com.wuxufang.service.SpuService;

@Controller
@RequestMapping
public class IndexController {

	@Reference
	SpuService spuService;

	@Reference
	CategoryService categoryService;

	@Autowired
	RedisTemplate<String, PageInfo<Spu>> redisTemplate;

	@RequestMapping({ "/", "index", "main" })
	public String index(HttpServletRequest request, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "0") int catId) {
		if (catId == 0 && page == 1) {
			if (getRedisTemplate().hasKey("GOODS_FIRST_PAGE")) {
				ValueOperations<String, PageInfo<Spu>> operations = getRedisTemplate().opsForValue();
				PageInfo<Spu> pageInfo = operations.get("GOODS_FIRST_PAGE");
				request.setAttribute("pageInfo", pageInfo);
				request.setAttribute("catId", catId);
				return "index";
			}
		}

		SpuVo vo = new SpuVo();
		vo.setCategoryId(catId);
		PageInfo<Spu> pageInfo = spuService.list(page, vo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("catId", catId);

		if (catId == 0 && page == 1) {
			ValueOperations<String, PageInfo<Spu>> operations = getRedisTemplate().opsForValue();
			operations.set("GOODS_FIRST_PAGE", pageInfo, 100, TimeUnit.SECONDS);
		}

		return "index";
	}

	public RedisTemplate<String, PageInfo<Spu>> getRedisTemplate() {
		// TODO Auto-generated method stub
		return redisTemplate;
	}

	@ResponseBody
	@RequestMapping("treeData")
	public List<Category> treeData() {
		List<Category> catTree = categoryService.getTree();
		return catTree;
	}

	public void setRedisTemplate(RedisTemplate<String, PageInfo<Spu>> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
