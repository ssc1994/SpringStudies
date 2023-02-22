package com.simple.basic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.UsersVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	//로그인기능
	@PostMapping("/login")
	public String loginForm(UsersVO vo, HttpSession session) {
		
		///select * from 유저 where id = ? and pw = ?
		
		//서비스영역 호출 (로그인 성공)
		//성공이라면 usersVO에 값을 받아서 돌아옴
		UsersVO userVO = new UsersVO();
		userVO.setId("aaa");
		userVO.setName("홍길동");
		
		//로그인 성공 - 세션을 이용해서 인증값
		if(userVO != null) {
			session.setAttribute("user_id", userVO.getId());
			return "redirect:/user/mypage";
		}
		
		
		return "user/login";
	}
	
	
	
	
	@GetMapping("/mypage")
	public String mypage() {
		return "user/mypage";
	}
	
	@GetMapping("/info")
	public String info() {
		return "user/info";
	}
	

}
