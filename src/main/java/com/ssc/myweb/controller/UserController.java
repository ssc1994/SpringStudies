package com.ssc.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	
	//이페이지는 템플릿을 적용하지 않고 사용하려면 타임즈 설정에 직접추가
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	@RequestMapping("/join")
	public String join() {
		return "user/join";
	}
}
