package com.test04;

public class Dog extends Animal {

	@Override
	public void bark() {
		System.out.println("멍멍");
	}

	@Override
	public void eat(String food) {
		System.out.println(food + "먹는다.");
	}
	
}
