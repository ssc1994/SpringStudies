package com.ssc.myweb.trip.service;

import java.util.ArrayList;

import com.ssc.myweb.command.TripVO;

public interface TripService {
	public int noticeRegist(TripVO vo);
	public ArrayList<TripVO> getList();
	public TripVO getContent(int tno);
	public int noticeModify(TripVO vo);
	public int noticeDelete(int tno);
	public void upHit(int tno);
	public ArrayList<TripVO> getPrevNext(int tno);
}
