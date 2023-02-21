package com.simple.basic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.MemoVO;
import com.simple.basic.command.UsersVO;

@Mapper		//스프링부트에서는 매퍼 어노테이션은 필수
public interface TestMapper {
	public String getTime();
	
	//N : 1 조인의 모형 글 - 회원정보
	public List<MemoVO> joinOne();

	//1 : N 조인의 모형 회원정보 - 글
	public UsersVO<MemoVO> joinTwo();
	

}
