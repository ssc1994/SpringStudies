package com.simple.basic;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.basic.command.MemoVO;
import com.simple.basic.mapper.TestMapper;

@SpringBootTest
public class MybatisTest {
	@Autowired
	TestMapper testMapper;
	
//	@Test
//	public void testCode01() {
//		System.out.println(testMapper.getTime());
//		
//	}
	
	@Test
	public void testcode02() {
		 List<MemoVO> list = testMapper.joinOne();
		 System.out.println(list.toString());
	}

}
