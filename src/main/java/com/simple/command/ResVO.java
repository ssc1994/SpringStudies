package com.simple.command;

public class ResVO {
	
	private String name;
	private int age;

	public ResVO() {
		// TODO Auto-generated constructor stub
	}

	public ResVO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getage() {
		return age;
	}

	public void setage(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ResVO [name=" + name + ", age=" + age + "]";
	}
	
}
