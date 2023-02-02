package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;
import com.simple.command.Quiz02VO;
import com.simple.command.Quiz03VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@RequestMapping("/quiz01")
	public String quiz01() {
		return "/quiz/quiz01";
	}
	@RequestMapping("/quiz01_ok")
	public String quiz01_ok(@RequestParam("vo") Quiz01VO vo) {
		return "/quiz/quiz01_ok";
	}
	
	@RequestMapping("/sendBirth")
	public String sendBirth(Quiz01VO vo, Model model) {
		
		String y = vo.getYear();
		String m = vo.getMonth();
		if(m.length()==1) m="0"+m;
		String d = vo.getDay();
		
		model.addAttribute("vo",vo);
		System.out.println(y+m+d);
		return "/quiz/quiz01_ok";
	}
	/////////////////////////////////////////////////////////
	@RequestMapping("/quiz02")
	public void quiz02() {
	}
	@RequestMapping("/join")
	public String join(Quiz02VO vo, Model model) {
		model.addAttribute("vo", vo);
		return "/quiz/quiz02_ok";
	}
	
	@RequestMapping("/quiz02_ok")
	public String quiz02_ok(@ModelAttribute("vo") Quiz02VO vo) {
		return"/quiz/quiz02_ok";
	}
	/////////////////////////////////////////////////////////////
	@RequestMapping("/quiz03")
	public void quiz03() {}
	
	@RequestMapping("/join2")
	public String join2(Quiz03VO vo, Model model, RedirectAttributes ra) {
		
		if(vo.getId().equals("")) {
			ra.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		}else if(!vo.getPw().equals(vo.getPw_check())) {
			ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		}else {
			model.addAttribute("vo", vo);
			return "/quiz/quiz03_ok";
		}
	}
	@RequestMapping("/quiz03_ok")
	public String quiz03_ok(@ModelAttribute("vo") Quiz03VO vo) {
		
		return "/quiz/quiz03_ok";				
	}
	
	
}
