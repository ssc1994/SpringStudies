package com.ssc.myweb.trip.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ssc.myweb.command.TripVO;

@Mapper
public interface TripMapper {
	public int noticeRegist(TripVO vo);
	public ArrayList<TripVO> getList();
	public TripVO getContent(int tno);
	public void upHit(int tno);
	public int noticeModify(TripVO vo);
	public int noticeDelete(int tno);
	public ArrayList<TripVO> getPrevNext(int tno);
}
