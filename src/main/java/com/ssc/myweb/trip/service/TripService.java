package com.ssc.myweb.trip.service;

import java.util.ArrayList;

import com.ssc.myweb.command.TripVO;

public interface TripService {
	public int noticeRegist(TripVO vo);
	public ArrayList<TripVO> getList();
}
