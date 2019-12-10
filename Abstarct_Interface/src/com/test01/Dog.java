package com.test01;

public class Dog extends Animal {

	@Override
	public void bark() {
		// TODO Auto-generated method stub
		System.out.println("멍멍멍");
	}
	
	public void eat(String animal) {
		super.eat(animal);
	}
}
