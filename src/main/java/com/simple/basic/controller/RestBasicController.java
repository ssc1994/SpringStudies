package com.simple.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simple.basic.command.SimpleVO;

@RestController 	//controller + responseBody
public class RestBasicController {

	/*
	 * 1. responsebody는 returb값이 뷰 리졸버가 아닌, 요청이 들어온곳으로 반환한다.
	 * 
	 */
	
	@GetMapping("/getText")
	public String getText() {
		return "hello World";
	}
	
	//객체를 담게 되면 application/json 형식으로 반환하게 된다.
	//@getmapping의 produces는 생략 가능 // 내가 보내는 타입의 형식을 지정함.
	/*
	 * consumes = 받는데이터에 대한 타입 (생략시 json)
	 * produces = 보내는데이터에 대한 타입 (생략시 json) 
	 * 
	 * text/plain => String    // application/json   => Json형식
	 */
	@GetMapping(value = "/getObject", produces = "application/json")
	public SimpleVO getObject() {
		SimpleVO vo = new SimpleVO(1,"aaa123","홍길동");
		return vo;
	}
	
	//맵형식의 반환
	@GetMapping("/getObject2")
	public Map<String, Object> getObject2(){
		
		Map<String, Object> map = new HashMap<>();
		SimpleVO vo = new SimpleVO(1,"aaa123","홍길동");
		map.put("total", 100);
		map.put("data", vo);
		
		return map;
	}
	
	//리스트형식의 반환
	@GetMapping("/getObject3")
	public List<SimpleVO> getObject3(){
		List<SimpleVO> list = new ArrayList<>();
		for( int i  = 1 ; i<= 10 ; i++) {
			list.add(new SimpleVO(i,"aaa123"+i,"홍길동"+i));
		}
		return list;
	}
	
	//get형식 값을 받는 방법 1 = 쿼리스트링 ?키=값
	//http://localhost:8383/getKey?id=idTest&name=nameTest
	@GetMapping("/getKey")
	public String getKey(@RequestParam("id") String id,
						@RequestParam("name") String name) {
		System.out.println(id);
		System.out.println(name);
		return "success";
	}
	
	//get형식 값을 받는 방법 2 = 쿼리파람 url/키/키
	//http://localhost:8383/getKey/
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/getKey2/{sort}/{apiKey}")
	public String getKey2(@PathVariable("sort") String sort,
							@PathVariable("apiKey") String key) {
		System.out.println(sort);
		System.out.println(key);
		return "success";
	}
	
	//////////////////////////post방식의 처리
	//값을 받는 방법 1- VO로 맵핑
	//JSON형식이 데이터를 자바의 객체로 맵핑시키려면 @RequestBody 어노테이션을 사용해야한다.

	//cors - 기본적으로 서버가 다르면 요청을 거절하는데 (특정 서버에 대하여 허용해줌)
	//@CrossOrigin(*)모든곳에서 다열림 ( 보안상 좋지 않음) //혹은 필터를 통해서 설정가능
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/getJson")
	public String getJson(@RequestBody SimpleVO vo) {
		System.out.println(vo.toString());
		return "success";
	}
	
	//값을 받는 방법2- MAP으로 맵핑
	@PostMapping("/getMap")
	public String getMap(@RequestBody Map<String, Object> map) {
		System.out.println(map.toString());
		
		return "success";
	}
	
	// consumer을 통한 데이터 제한
	// comsumer는 특정 타입의 데이터를 받도록 처리하는 옵션(  기본값 json)
	// 클라이언트에는 content-type 을 이용해서 보내는 데이터에 대한 타입을 명시(반드시 필수)
	@PostMapping(value = "/getResult", consumes = "text/plain")
	public String getResult(@RequestBody String vo) {
		
		System.out.println(vo);
		return "success";
	}
	
	//응답문서의 형태를 직접선언 - ResponseEntity
	@PostMapping("/createRes")
	public ResponseEntity createRes() {
		///데이터
		SimpleVO vo = new SimpleVO(1,"aaa","홍길동"); 
		
		//헤더
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "token.....");
		
		//상태코드
		HttpStatus status=HttpStatus.ACCEPTED;
		
//		new ResponseEntity<>(데이터, 헤더, 상태코드);
		//ResponseEntity의 제너릭타입은 데이터의 타입을 따라감
		ResponseEntity<SimpleVO> entity = new ResponseEntity<>(vo, header, status);
		
		return entity;
		
	}
	
	//jquery - ajax
	
	@CrossOrigin("http://127.0.0.1:5501")
	@PostMapping("/getAjax")
	public Map<String, Object> getAjax(@RequestBody SimpleVO simpleVo){
		//받은 데이터
		System.out.println(simpleVo.toString());
		
		//보낸 데이터
		Map<String, Object> map = new HashMap<>();
		SimpleVO vo = new SimpleVO(1,"aaa123","홍길동");
		map.put("total", 100);
		map.put("data", vo);
		
		return map;
	}
	
	@CrossOrigin("http://127.0.0.1:5501")
	@GetMapping("/getAjax2/{topic}")
	public String getAjax2(@PathVariable("topic") String topic) {
		System.out.println(topic);
		return "success";
	}
s}
