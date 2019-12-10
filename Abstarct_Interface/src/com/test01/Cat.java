package com.test01;

public class Cat extends Animal {

	@Override
	public void bark() {
		// TODO Auto-generated method stub
		System.out.println("야오옹");
	}
	
	
	public void eat(String animal) {
		super.eat(animal);
	}
}
