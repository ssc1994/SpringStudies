package com.ssc.myweb.trip.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ssc.myweb.command.TripVO;
import com.ssc.myweb.util.Criteria;

@Mapper
public interface TripMapper {
	public int noticeRegist(TripVO vo);
//	public ArrayList<TripVO> getList();
	public ArrayList<TripVO> getList(Criteria cri);
	public TripVO getContent(int tno);
	public void upHit(int tno);
	public int noticeModify(TripVO vo);
	public int noticeDelete(int tno);
	public ArrayList<TripVO> getPrevNext(int tno);
	public int getTotal(Criteria cri);		//전체게시글수
}
