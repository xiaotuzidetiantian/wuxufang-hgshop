package com.wuxufang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

}
