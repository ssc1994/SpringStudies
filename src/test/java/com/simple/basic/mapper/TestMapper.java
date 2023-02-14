package com.simple.basic.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper		//스프링부트에서는 매퍼 어노테이션은 필수
public interface TestMapper {
	public String getTime();

}
