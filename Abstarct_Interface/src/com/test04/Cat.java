package com.test04;

public class Cat extends Animal {

	@Override
	public void bark() {
		System.out.println("야옹");
	}
	
	@Override
	public void eat(String food) {
		System.out.println(food + "먹는다.");
	}
}
