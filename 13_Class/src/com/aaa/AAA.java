package com.aaa;

public class AAA extends Object {

	private int abc;
	
	//기본생성자
	public AAA() {
		System.out.println("AAA생성");
	}
	
	public AAA(int abc) {
		System.out.println("AAA생성(abc 받아서 생성)");
		this.abc=abc;
	}

	public int getAbc() {
		return abc;
	}

	public void setAbc(int abc) {
		this.abc = abc;
	}
	
	public void prn() {
		System.out.println("AAA의 prn 메소드");
	}
	
}
