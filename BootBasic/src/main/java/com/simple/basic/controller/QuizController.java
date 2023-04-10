package com.simple.basic.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.SimpleVO;

@Controller
@RequestMapping("/view")
public class QuizController {
	
	@GetMapping("/quiz01")
	public String quiz01(Model model) {
		
		SimpleVO vo = SimpleVO.builder().mno(1).id("testId").name("testName").build();
		
		model.addAttribute("vo",vo);
		return "view/quiz01";
	}
	
	/*
	 * @GetMapping("/quiz_result01/{a}/{b}/{c}") public String
	 * quiz_result01(@PathVariable("a") int a,
	 * 
	 * @PathVariable("b") String b,
	 * 
	 * @PathVariable("c") String c){
	 * 
	 * return "view/quiz_result01"; }
	 */
	@GetMapping("/quiz_result01")
	public String quiz_result01(@RequestParam("mno") int mno,
								@RequestParam("name") String name,
								@RequestParam("id") String id,
								Model model){
		model.addAttribute("mno",mno);
		model.addAttribute("name",name);
		model.addAttribute("id",id);
		return "view/quiz_result01";
	}

}
