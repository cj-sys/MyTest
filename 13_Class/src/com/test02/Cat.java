package com.test02;

public class Cat extends Animal {

	public Cat() {
		super();
		System.out.println("고양이");
	}

	@Override
	public void Bark() {
		super.Bark();
		System.out.println("야옹");
	}
}
