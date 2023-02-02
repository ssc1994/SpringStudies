package com.simple.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqQuizVO;
import com.simple.command.ReqVO;

@Controller
@RequestMapping("/request")	//메서드 앞에 공통으로 들어가는 요청경로
public class RequestController {

	//요청경로와 출력경로는 달라도 괜찮지만 보기 편하게 하기 위해서 맞춘다

	//String메서드 - 출력화면을 직접 지정
	//	@RequestMapping("/ex01")	//요청경로
	//	public String ex01() {
	//		return "request/ex01";		//출력경로
	//	}

	@RequestMapping("/ex01")
	public void ex01() {

	}




	//	@RequestMapping(value = "/basic1", method = RequestMethod.GET)
	@GetMapping("/basic1")
	public String basic1() {
		System.out.println("get만 허용");
		return null;
	}

	//	@RequestMapping(value ="/basic2", method = RequestMethod.POST)
	@PostMapping("/basic2")
	public String basic2() {
		System.out.println("post만허용");
		return null;
	}

	@RequestMapping("/basic3")
	public String basic3() {
		System.out.println("get & post 둘다 허용");
		return null;
	}

	@RequestMapping("/ex02")
	public String ex02() {
		System.out.println("ex02");
		return "/request/ex02";
	}

	//1번째 방식
	//	@RequestMapping(value = "/doAction", method=RequestMethod.POST)
	//	public String doAction(HttpServletRequest request) {
	//		
	//		//name param
	//		String name = request.getParameter("name");
	//		//age param
	//		String age = request.getParameter("age");
	//		//inter - checkbox
	//		String[] inter = request.getParameterValues("inter");
	//		
	//		System.out.println(name);
	//		System.out.println(age);
	//		System.out.println(Arrays.toString(inter));
	//		
	//		
	//		return "request/ex02_ok";
	//	}
	
//	2번째 방식
//	@RequestMapping("/doAction")
//	public String doAction(@RequestParam(value ="name", required=false) String name,
//							@RequestParam("age") int age,
//							@RequestParam(value = "inter", required = false, defaultValue = "") List<String> list) {
//
//		//-RequrestParam은 공백과 null데이터가 전달되면 요청을 거절하게 된다.
//		//-필수가 아닌 파라미터는 required=false 속성을 지정하면 된다. 
//		//-필수가 아닌 파라미터인 경우에는 null or "" 을 지정하게 되는데 
//		//defaultValue속성으로 기본값을 줄 수 있다.
//		//-
//		
//		System.out.println(name);
//		System.out.println(age);
//		System.out.println(list.toString());
//		return "request/ex02_ok";
//	}
	
	//3번재 방식 (가장 많이 사용함)
	//커멘트 객체를 통해서 맵핑( 넘어오는 데이터의 name과 setter명이 같아야한다)
	@RequestMapping("/doAction")
	public String doAction(ReqVO vo) {
		
		System.out.println(vo.toString());
		
		return "request/ex02_ok";
	}
	
	@RequestMapping("/req_quiz01")
	public void req_quiz01() {}
	
	@RequestMapping("/req_quiz01_ok")
	public String req_quiz01_ok() {
		return "request/req_quiz01_ok";
	}
	
	@RequestMapping("/req_quiz01_no")
	public String req_quiz01_no() {
		return "request/req_quiz01_no";
	}
	
	@PostMapping("/req_test")
	public String req_test(ReqQuizVO vo) {
		System.out.println(vo.toString());
		if( vo.getId().equals("abc123") && vo.getPw().equals("xxx123") ) {
			return "request/req_quiz01_ok";
		}else {
			return "request/req_quiz01_no";
		}
		
	}
	


}
