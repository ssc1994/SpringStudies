package com.simple.score.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("yyy")
public class ScoreDAOImpl implements ScoreDAO{
	//데이터 베이스
	ArrayList<ScoreVO> list = new ArrayList<>();
	

	@Override
	public void regist(ScoreVO vo) {
		System.out.println("DAO영역 : "+vo);
		list.add(vo);	//db일땐 insert문
	}


	@Override
	public ArrayList<ScoreVO> getList() {
		return list;
	}


	@Override
	public void delete(int num) {
		list.remove(num);
		
	}

}
