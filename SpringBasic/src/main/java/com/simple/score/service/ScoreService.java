package com.simple.score.service;

import java.util.ArrayList;
import java.util.List;

import com.simple.command.ScoreVO;

public interface ScoreService {
	// service 구현체에서 사용할 추상 메서드의 모형을 선언
	public void regist(ScoreVO vo);
	public ArrayList<ScoreVO> getList();
	public void delete(int num);
}
 