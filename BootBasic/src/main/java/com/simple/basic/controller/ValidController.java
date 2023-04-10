package com.simple.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.config.ValidVO;

@Controller
@RequestMapping("/valid")
public class ValidController {
	
	@GetMapping("/ex01")
	public String ex01(Model model) {
//		ValidVO vo = ValidVO.builder().name(null).salary(0).phone(null).email(null).build();
//		model.addAttribute("vo",vo);
		
		return "valid/ex01";
	}
	
	//@Valid - 유효성 검사를 진행하겠다는 뜻
	//Errors - 유효성검사에 실패하면 에러객체로 바인딩
	@PostMapping("/actionForm")
	public String actionForm(@Valid ValidVO vo, Errors error, Model model) {
		
		if(error.hasErrors()) {	//에러가있다면 true, 없다면 false
			List<FieldError> list = error.getFieldErrors();	//발생한 에러의 목록
			for(FieldError err : list) {
				if(err.isBindingFailure()) {	//유효성검사의 실패가 아닌, 자바 내부의 에러라면 true
					model.addAttribute("valid_" + err.getField(), "형식이 올바르지 않습니다");
				}else {	//유효성 검사에 실패한 목록
					model.addAttribute("valid_"+err.getField(),err.getDefaultMessage());
				}
			}
			model.addAttribute("vo",vo);
			return "valid/ex01";	//원래화면으로 돌아가기
		}
		
		return "valid/ex01_result";
	}
	
	
}
