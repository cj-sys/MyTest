package com.kh01;

public class MethodTest01 {

	public static void main(String[] args) {
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		privateMethod(); //MethodTest01. 생략가능(같은 클래스 내에 있어서)
		defaultMethod();
		
		//defaultMethod_nonstatic();
		
	}
	
	public static void publicMethod() {
		System.out.println("public method");
	}
	
	protected static void protectedMethod() {
		System.out.println("protected method");
	}
	
	private static void privateMethod() {
		System.out.println("private method");
	}
	
	static void defaultMethod() {
		System.out.println("default method");
	}
	
	void defaultMethod_nonStatic() {
		System.out.println("nonStatic_default method");
	}
	
	
	
	
	
	
}
