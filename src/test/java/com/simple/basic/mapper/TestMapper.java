package com.simple.basic.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.simple.command.ScoreVO;

public interface TestMapper {
	
	public String getTime();
	public ArrayList<ScoreVO> getScore();
	public ScoreVO getOne(int a);
	
	public int insertOne(String name);
	public int insertTwo(ScoreVO vo);
	public int insertThree(Map<String, String> map);	//다중값

	public Map<String, Object> selectMap(int num);	
	public ArrayList<Map<String, Object>> selectTwo();	//다중행Map
	
	public boolean updateOne(ScoreVO vo);
	
	public void insertFour(@Param("변수명1") String name, @Param("변수명2") int kor);
	
}
