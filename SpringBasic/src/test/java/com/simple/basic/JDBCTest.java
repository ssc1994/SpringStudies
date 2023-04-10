package com.simple.basic;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)			//JUnit으로 테스트환경을 구성
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml")		//동작시킬 Spring 설정파일
public class JDBCTest {

	
	//DAO에서 실행할 작업을 미리 해보는곳
	@Autowired
	DataSource datasource;
	
	@Test		//테스트코드로 실행함
	public void testCode01() {
		
		try {
			//DataSource에서 conn객체 얻음
			Connection conn = datasource.getConnection();
			
			System.out.println(conn);
			
		} catch (Exception e) {
			// 
		}
		
	}
}
