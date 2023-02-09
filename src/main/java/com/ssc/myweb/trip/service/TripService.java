package com.ssc.myweb.trip.service;

import java.util.ArrayList;

import com.ssc.myweb.command.TripVO;
import com.ssc.myweb.util.Criteria;

public interface TripService {
	public int noticeRegist(TripVO vo);
//	public ArrayList<TripVO> getList();
	public ArrayList<TripVO> getList(Criteria cri);
	public int getTotal(Criteria cri);		//전체게시글수
	public TripVO getContent(int tno);
	public int noticeModify(TripVO vo);
	public int noticeDelete(int tno);
	public void upHit(int tno);
	public ArrayList<TripVO> getPrevNext(int tno);
}
