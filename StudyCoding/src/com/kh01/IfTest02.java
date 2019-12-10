package com.kh01;

public class IfTest02 {
	public static void test01(int a) {
		if(a%5==0) {
			System.out.println(a+"는 5의 배수입니다.");
		}
	}
	
	public static void test02(int a ) {
		if((a%2==0) && (a%3==0)) {
			System.out.println("2와 3의 배수입니다.");
		} else {
			System.out.println("2와 3의 배수가 아닙니다.");
		}
	}
	
	public static void test03(char a) {
		if(Character.isUpperCase(a)) {
			System.out.println("대문자입니다.");
		} else if(Character.isLowerCase(a)) {
			System.out.println("소문자입니다.");
		} else {
			System.out.println("이상해여");
		}
	}
	
	public static void main(String[] args) {
		//1. 입력받은 수가 5의 배수이면 출력
		//2. 입력받은 수가 2의 배수이며 3의 배수이면 출력, 아니면 2와3의 배수가 아니다 출력
		//3. 입력받은 문자가 소문자면 소문자입니다, 대문자이면 대분자입니다. 출력
		
		test01(15);
		test02(6);
		test03('a');
	}
}
