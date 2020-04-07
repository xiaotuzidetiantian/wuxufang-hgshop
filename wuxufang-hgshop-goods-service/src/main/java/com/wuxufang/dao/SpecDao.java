package com.wuxufang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wuxufang.pojo.Spec;
import com.wuxufang.pojo.SpecOption;

public interface SpecDao {

	int addSpec(Spec spec);

	int addSpecOption(SpecOption specOption);

	int updateSpec(Spec spec);

	int deleteSpecOption(Integer id);

	Spec getById(int id);

	int deteteBatch(int[] ids);

	int deteteOptionBatch(int[] ids);

	List<Spec> list(@Param("name") String name);

	// 获取所有的规格
	@Select("select id,spec_name specName from hg_spec order by spec_name")
	List<Spec> listAll();

}
