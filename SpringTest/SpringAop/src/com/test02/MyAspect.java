package com.test02;

public class MyAspect {

	public void before() {
		System.out.println("카드를 찍는다.");
	}
	
	public void after() {
		System.out.println("컴퓨터를 끈다.");
	}
	
	public void test() {
		System.out.println("이건 테스트");
	}
}
