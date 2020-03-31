package com.wuxufang.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuxufang.dao.SpecDao;
import com.wuxufang.pojo.Spec;
import com.wuxufang.pojo.SpecOption;
import com.wuxufang.service.SpecService;

//实现规格管理服务
@Service(interfaceClass = SpecService.class)
public class SpecServiceImpl implements SpecService {

	@Autowired
	private SpecDao specDao;

	

}
