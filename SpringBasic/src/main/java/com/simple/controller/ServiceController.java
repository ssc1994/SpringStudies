package com.simple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.score.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ServiceController {
	
	//1st
	//ScoreServiceImpl service = new ScoreServiceImpl();
	
	//2nd - service를 bean으로 생성한다 -> 의존객체 자동주입 @autowired

	//3rd - @service로 빈을 생성하고 , 의존객체 자동주입
	@Autowired
	@Qualifier("이름")
	ScoreServiceImpl service;
	
	
	//화면출력
	@RequestMapping("/scoreRegist")
	public String registView() {
		return "/service/scoreRegist";
	}
	
	//폼요청
	@RequestMapping(value="/regist", method = RequestMethod.POST)
	public String regist(ScoreVO vo) {
//		System.out.println(vo.toString());
		service.regist(vo);
		
		return "service/scoreResult";
	}
	
	//목록화면
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		
		//data조회 
		List<ScoreVO> list= service.getList();
		model.addAttribute("list", list);
		return "service/scoreList";
	}
	
	//삭제 요청
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) {
		service.delete(num);
		return "redirect:/service/scoreList"; 
	}
	
	
	
	
	

}
