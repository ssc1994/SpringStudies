package com.simple.basic.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.BuilderVO;
import com.simple.basic.command.BuilderVO2;

@Controller
@RequestMapping("/view")
public class ThymeleafController {
	
	@GetMapping("/ex01")	//get방식만 허용
	public String ex01() {	
		
		return "view/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		ArrayList<BuilderVO2> list = new ArrayList<>(); 
		
		for(int i  = 1; i<=10; i++) {
			BuilderVO2 vo = BuilderVO2.builder()
									.age(i)
									.name("홍길동"+i)
									.build();
			list.add(vo);
		}
		model.addAttribute("list",list);
		return "view/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		ArrayList<BuilderVO2> list = new ArrayList<>(); 
		
		for(int i  = 1; i<=10; i++) {
			BuilderVO2 vo = BuilderVO2.builder()
									.age(i)
									.name("홍길동"+i)
									.build();
			list.add(vo);
		}
		model.addAttribute("list",list);
		return "view/ex03";
	}
	
	@GetMapping("/test")
	public String test(@RequestParam("age") int age,
						@RequestParam("name") String name) {
		System.out.println(age);
		System.out.println(name);
		
		
		
		return "view/test";
	}
	
	@GetMapping("/test2/{a}/{b}")
	public String test2(@PathVariable("a") String a,
						@PathVariable("b") String b) {
		System.out.println(a);
		System.out.println(b);
		
		return "view/test";
	}
	
	@GetMapping("/ex04")
	public String ex04(Model model) {
		
		BuilderVO2 vo = new BuilderVO2("이순신", 20);
		model.addAttribute("name", "홍길동");
		model.addAttribute("vo",vo);
		
		return "view/ex04";
	}
	
	//타임리프 내장함수
	@GetMapping("/ex05")
	public String ex05(Model model) {
		
		//날짜의 형변환은 database, 자바, 화면 어디서하든지 상관없음
		model.addAttribute("regdate", LocalDateTime.now());
		
		return "view/ex05";
	}
	
	@GetMapping("/ex06")
	public String ex06() {
		
		return "view/ex06";
	}
	@GetMapping("/ex07")
	public String ex07() {
		
		return "view/ex07";
	}
	

}
