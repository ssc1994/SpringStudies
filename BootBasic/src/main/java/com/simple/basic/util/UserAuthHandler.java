package com.simple.basic.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class UserAuthHandler implements HandlerInterceptor{

	/*
	 * 1. HandlerInterceptor를 상속받는다.
	 * 
	 * prehHandle - 컨트롤러 진입전에 실행
	 * postHandle - 컨트롤러 수행 후에 실행
	 * afterCompletion() - 화면으로 가기 직전에 수행
	 * 
	 * 2. 인터셉터 클래스를 bean으로 등록
	 * 
	 */
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("인터셉터 실행");
		
		//현재 세션을 얻음
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		
		if(user_id == null) {
			response.sendRedirect(request.getContextPath()+"/user/login");  //로그인페이지로 리다이렉트
			return false;
		}
		System.out.println(user_id);
		
		return true;
	}

	
}
