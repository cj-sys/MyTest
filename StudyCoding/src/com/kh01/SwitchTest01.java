package com.kh01;

public class SwitchTest01 {

	public static void main(String[] args) {
		int i=2;
		
		switch(i) {
		case 1:
			System.out.println("1이다");
			break;
		case 2:
			System.out.println("2이다");
			break;
		case 3:
			System.out.println("3이다");
			break;
		default :
			System.out.println("숫자이다");
		}
	}
	//if는 순차적으로 코드는 읽지만, switch는 헤당 case로 jumping 하기 때문에 컴파일러가 작업하는데 수월하다
}
