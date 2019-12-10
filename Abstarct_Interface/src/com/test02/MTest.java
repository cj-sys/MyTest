package com.test02;

import java.util.Scanner;

public class MTest {
	public static void main(String[] args) {
		/*
		 * 동적 바인딩 - 프로그램의 시작시에는 어떤객체의 메소드를 실행할지 모르는데 실행시 메모리 할당을 하면서 메소드를 동적으로 연동하는 방식 
		 동적 바인딩 이라는게 프로그램 시작 할때는~~~ 어느 객체의 메소드 인지 모르지만 막상 실행되다 메모리가 할당되면서 동적으로 되는거 
		 * 1. 코드 절약 2. 실행속도 향상 3. 행위 은닉
		 * 
		 * base를
		 */
		System.out.println("선택해 주세요 [1:고양이 2: 멍멍이 3: 송아지]");
		Scanner sc = new Scanner(System.in);
	
		int select = sc.nextInt();
		
		//base 타입의 참조변수를 선언 - null값으로 초기화
		Base base = null;
		
		switch (select) {
		case 1:
			base = new Cat();
			break;
		case 2:
			base = new Dog();
			break;
		case 3:
			base = new Cow();
			break;
	
		}
		// 프로그램이 진행되면서 다른 start stop 동작을 수행
		base.start();
		base.stop();
		
		sc.close();
		
	}
}
