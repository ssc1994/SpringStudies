package com.simple.score.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.score.dao.ScoreDAO;
import com.simple.score.mapper.ScoreMapper;

//@Component //@Repository //@Controller //@Service // (다 동일) 
//@Service ("Bean의 이름")
@Service ("이름")
public class ScoreServiceImpl implements ScoreService{
	
	@Autowired
	@Qualifier("yyy")
	private ScoreDAO scoreDAO;
	
	@Autowired
	private ScoreMapper scoreMapper;
	
	public void regist(ScoreVO vo) {
//		scoreDAO.regist(vo);
		scoreMapper.regist(vo);

	}

	@Override
	public ArrayList<ScoreVO> getList() {
		
//		return scoreDAO.getList();
		return scoreMapper.getList();
	}

	@Override
	public void delete(int num) {
//		scoreDAO.delete(num);
		scoreMapper.delete(num);
	}

}
