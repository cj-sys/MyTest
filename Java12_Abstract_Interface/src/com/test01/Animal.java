package com.test01;

public abstract class Animal {
	
	static String doldol = "돌돌이ㅏ바보";
	
	public Animal() {
		System.out.println("animal");
	}
	
	public Animal(String name) {
		System.out.println(name+"animal");
	}
	
	public abstract void bark();
	
	public static void eat(String animal) {
		System.out.println(animal + "먹는다");
	}
}