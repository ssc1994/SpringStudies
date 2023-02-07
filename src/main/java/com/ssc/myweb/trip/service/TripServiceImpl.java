package com.ssc.myweb.trip.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssc.myweb.command.TripVO;

@Service("tripService")
public class TripServiceImpl implements TripService{
	
	@Autowired
	private TripMapper tripMapper ;

	@Override
	public int noticeRegist(TripVO vo) {
		return tripMapper.noticeRegist(vo);
	}

	@Override
	public ArrayList<TripVO> getList() {
		ArrayList<TripVO> list = tripMapper.getList();
		return list;
	}

}
