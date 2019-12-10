package com.test;

abstract class A{
	public abstract int b();
	
	public void d() {
		System.out.println("word");
	}
}

class B extends A {

	@Override
	public int b() {
		
		return 0;
	}
	
}

public class AbstractDemo {

	public static void main(String[] args) {
		//A obj = new A();  // 에러... 추상클래스를 상속받아
		B obj = new B();
	}

}
