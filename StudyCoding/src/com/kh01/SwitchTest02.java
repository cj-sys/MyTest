package com.kh01;

public class SwitchTest02 {

	public static void main(String[] args) {
		int i=2;
		
		switch(i) {
		case 1:
		case 3:
			System.out.println("홀수");
			break;
		case 2:
		case 4:
			System.out.println("짝수");
			break;
		default :
			System.out.println("범위를 벗어난 숫자이다.");
		}
	}

}
