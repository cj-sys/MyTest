package com.test01;

public abstract class Animal {
	
	//상속받는 클래스가 반드시 구현해야한다.
	public abstract void bark();
	
	public void eat(String animal) {
		System.out.println(animal + " 먹다 ");
	}
}
