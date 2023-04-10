package com.simple.basic.command;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersVO<T> {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	
	//1:n조인에선 n쪽을 list로 처리
	private List<T> memoList;
	

}
