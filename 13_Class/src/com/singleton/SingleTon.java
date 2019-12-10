package com.singleton;

public class SingleTon {

	private static SingleTon singleTon;
	
	private SingleTon() {
		System.out.println("sigleton instance 생성");
	}
	
	public static SingleTon getInstance() {
		if(singleTon == null) {
			singleTon = new SingleTon();
		}
		return singleTon;
	}
}
