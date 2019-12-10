package com.kh01;

public class IfTest {
	public static void main(String[] args) {
		int a=10;
		int b=20;
		
		if(a>0) {
			System.out.println(a+ "은 0보다 큽니다.");
		}
		if(b>20) {
			System.out.println(b+ "은 20보다 큽니다.");
		} else {
			System.out.println(b+"은 20보다 작거나 같습니다.");
		}
		
		//3항 연산자와 if
		String s= (b>20?b+"은 20보다 큽니다.":b+"은 20보다 작거나 같습니다.");
		System.out.println(s);
		
		if(a>b) {
			System.out.println("a가 b보다 큽니다.");
		} else if(a==b) {
			System.out.println("a와 b는 같습니다.");
		} else {
			System.out.println("a가 b보다 작습니다.");
		}
	}
}
