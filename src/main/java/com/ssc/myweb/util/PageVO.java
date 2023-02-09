package com.ssc.myweb.util;

import lombok.Data;

@Data
public class PageVO {
	
	private int end;		//페이지네이션 끝번호
	private int start;		//페이지네이션 시작번호
	private boolean next;	//다음버튼 활성화 여부
	private boolean prev;	//이전버튼 활성화 여부
	
	private int realEnd;	//페이지네이션 실제 끝번호
	
	private int page;		//사용자가 조회하는 페이지번호
	private int amount;		//화면에 1페이지에 나타내는 데이터개수
	private int total;		//전체 게시글 수
	
	private Criteria cri;	//페이지 기준
	
	//한페이지네이션에 보일 페이지번호 수
	private int pageCnt = 5;
	
	//생성자 - PageVO가 만들어질 때 Criteria와 total을 받는다.
	public PageVO(Criteria cri, int total ) {
		//계산에 필요한 값(페이지번호, 데이터개수, 전체게시글수, cri)을 초기화
		this.page = cri.getPage();
		this.amount = cri.getAmount();
		this.total = total;
		this.cri = cri;
		
		//1. 끝페이지 계산
		//page가 1~10 -> 끝페이지 = 10
		//page가 11~20 -> 끝페이지 = 20
		//페이지번호를 10.0으로 나누고 올림(Math.ceil)해주고 10을 곱한다
		//(int)Math.ceil(페이지번호/10.0) * 페이지네이션 수
		this.end = (int)Math.ceil(this.page/(double)pageCnt) * pageCnt;
		
		//2. 시작페이지 번호 계산
		//end - 페이지네이션 수 +1
		this.start = this.end-pageCnt+1;
		
		//3. 실제끝번호 계산
		//데이터가 60개라고 가정할때, end =6
		//데이터가 112개라고 가정할때, 11번 페이지 조회시 -> end = 12
		//데이터가 356개라고 가정할때, 32번 페이지 조회시 -> end =  36
		//(int)Math.ceil(전체게시글수 / (double)데이터개수)
		this.realEnd = (int)Math.ceil(this.total / (double)this.amount);
		
		//4. 마지막 페이지 번호를 다시 계산
		//데이터가 112개라고 가정할때, 5번페이지 조회시 end = 10, realEnd = 12
		//데이터가 112개라고 가정할때, 11번페이지 조회시 end = 20 realEnd = 12
		//끝번호 > 실제끝번호라면 실제끝번호를 따라감
		this.end = this.end > this.realEnd ? this.realEnd : this.end;
		
		
		//5. 이전버튼
		//start는 1, 11, 21, 31...로 증가되는데 1보다 크면 true
		this.prev = this.start>1;
		
		//6. 다음버튼
		//실제 끝번호가 end보다 크면 true
		this.next = this.end < this.realEnd;
		
	}

}
