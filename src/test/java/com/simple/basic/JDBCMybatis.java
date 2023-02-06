package com.simple.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.basic.mapper.TestMapper;
import com.simple.command.ScoreVO;

//JUnit으로 테스트환경을 구성
@RunWith(SpringJUnit4ClassRunner.class)	
//동작시킬 Spring 설정파일
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml")		//동작시킬 Spring 설정파일
public class JDBCMybatis {
	
	//root-context의 (id가 ds인 hikariDataSource를 연결해둔) sqlSessionFactory Bean 호출
	@Autowired
	SqlSessionFactoryBean sqlSessionFactory;
	
	//xml파일 연결
	@Autowired
	TestMapper testMapper;
	 
//	@Test//테스트코드로 실행함
//	public void testCode01() {
//		//마이바티스 핵심 객체
//		System.out.println(sqlSessionFactory);
//	}
	
//	//xml파일의 getTime메서드 호츨(TestMapper.xml의 id가 getTime인 select태그 호출)
//	@Test//테스트코드로 실행함
//	public void testCode02() {
//		String time = testMapper.getTime();
//		System.out.println(time);
//	}
	
	
//	//select 태그의 ResultType
//	@Test
//	public void testCode03() {
//		ArrayList<ScoreVO> list = testMapper.getScore();
//		System.out.println(list.toString());
//	}
//	
//	@Test
//	public void testCode04() {
//		ScoreVO vo = testMapper.getOne(10);
//		System.out.println(vo.toString());
//	}
	
//	//insert -단일값
//	@Test
//	public void testCode05() {
//		int result = testMapper.insertOne("이순영");
//		System.out.println("성공실패 : "+  result);
//	}
	
//	//insert-다중값(Setter명)
//	@Test
//	public void testCode06() {
//		ScoreVO vo = new ScoreVO(0, "테스트", "50", "100");
//		
//		int result = testMapper.insertTwo(vo);
//		System.out.println("성공실패 : "+  result);
//	}
	
//	//insert- 다중값(MAP) : key값이 파라미터가 됨
//	@Test
//	public void testCode07() {
//		Map<String, String> map = new HashMap<>();
//		map.put("name", "홍길자");
//		map.put("kor", "30");
//		map.put("eng", "40");
//		
//		int result = testMapper.insertThree(map);
//		System.out.println("성공실패 : "+  result);
//	}
	
//	//select - map타입의 반환
//	@Test
//	public void testCode08() {
//		Map<String, Object> map =  testMapper.selectMap(6);
//		System.out.println(map.toString());
//	}
	
//	//select - map을 통한 다중행 조회
//	@Test
//	public void testCode09() {
//		ArrayList<Map<String, Object>> list = testMapper.selectTwo();
//		System.out.println(list.toString());
//	}
	
	//
//	@Test
//	public void testCode10() {
//		ScoreVO vo = new ScoreVO(6, "변경", "100", "100");
//		boolean result = testMapper.updateOne(vo);
//		System.out.println(result);	//성공시 true 실패시 false
//	}
	
	@Test
	public void testCode11() {
		testMapper.insertFour("파람테스트", 100);
	}
	
	

}
