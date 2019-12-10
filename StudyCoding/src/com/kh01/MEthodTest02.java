package com.kh01;

public class MEthodTest02 {
	public static void main(String[] args) {
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		MethodTest01.defaultMethod();
		
		//static 과 non-static 차이점
		MethodTest01 mtdTest = new MethodTest01();
		
		mtdTest.defaultMethod_nonStatic();
	}
}
