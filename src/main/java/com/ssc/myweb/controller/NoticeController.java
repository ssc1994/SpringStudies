package com.ssc.myweb.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssc.myweb.command.TripVO;
import com.ssc.myweb.trip.service.TripService;


@Controller
@RequestMapping("/trip")
public class NoticeController {
	
	@Autowired
	@Qualifier("tripService")
	private TripService tripService;
	
	
	@RequestMapping("/notice_list")
	public String notice_list(Model model) {
		
		/*
		 * service, mapper영역에 getlist함수를 선언
		 * 등록번호를 역순으로 데이터를 조회해서 가지고 나가기
		 * model에 담아서 화면에는 반복문으로 처리
		 * */
		ArrayList<TripVO> list = tripService.getList();
		model.addAttribute("list",list);
		
		return "trip/notice_list";
	}
	
	@RequestMapping("/notice_write")
	public String notice_write() {
		return "trip/notice_write";
	}
	
	@RequestMapping("/notice_view")
	public String notice_view(@RequestParam("tno") int tno, 
								Model model,
								HttpServletResponse response,
								HttpServletRequest request
								) {
		
		//클릭한 글 번호에 대한 내용을 조회
		TripVO vo = tripService.getContent(tno);
		model.addAttribute("vo",vo);
		
		//조회수 - Cookie or 세션 이용해서 조회수 중복 방지
		tripService.upHit(tno);
		
//		Cookie cookie = new Cookie("key","1");
//		cookie.setMaxAge(30);
//		response.addCookie(cookie);
		
		//이전글 다음글
		ArrayList<TripVO> list = tripService.getPrevNext(tno);
		
		System.out.println(list.toString());
		model.addAttribute("list", list);
		
		return "trip/notice_view";
	}

	@RequestMapping("/notice_modify")
	public String notice_modify(@RequestParam("tno") int tno, Model model ) {
		
		TripVO vo = tripService.getContent(tno);
		model.addAttribute("vo",vo);
		return "trip/notice_modify";
	}
	
//	//수정 상세화면이 완전 동일하다면
//	@RequestMapping({"notice_view", "notice_modify"})
//	public void notice_view(@RequestParam("tno") int tno, Model model ) {
//		
//		TripVO vo = tripService.getContent(tno);
//		model.addAttribute("vo",vo);
//	}
	
	
	//글등록
	@RequestMapping(value="/registForm", method = RequestMethod.POST)
	public String registForm(TripVO vo, RedirectAttributes ra) {
		int result = tripService.noticeRegist(vo);
		String msg = result == 1? "문의사항이 정상 등록 되었습니다":"문의등록에 실패했습니다";
		ra.addFlashAttribute("msg", msg);
		return "redirect:/trip/notice_list";
	}
	
	//수정기능
	@RequestMapping(value = "modifyForm", method=RequestMethod.POST)
	public String modifyForm(TripVO vo, RedirectAttributes ra) {
		int result = tripService.noticeModify(vo);
		String msg = result ==1? "문의사항이 수정되었습니다" : "문의사항 수정실패";
		ra.addFlashAttribute("msg",msg);
		return "redirect:/trip/notice_list";
	}
	
	//글삭제
	@RequestMapping(value ="/deleteForm" , method=RequestMethod.POST)
	public String deleteForm(@RequestParam("tno") int tno,
							 RedirectAttributes ra) {
		
		
		/*
		 * service , mapper 에는 noticeDelete메서드로 삭제를 진행
		 * 삭제 이후엔 list화면으로 이동
		 * */
		int result = tripService.noticeDelete(tno);
		String msg = result==1?"삭제완료":"삭제실패";
		ra.addFlashAttribute("msg",msg);
		
		
		return "redirect:/trip/notice_list";
		
	}
	
	
	
}
