package com.test;
import java.lang.*;

public class Mtest {

	public static char getUpChar(char a) {
		char res = Character.toUpperCase(a);
		return res;
	}
	
	public static char getLowChar(char a) {
		char res = Character.toLowerCase(a);
		return res;
	}
	
	public static void main(String[] args) {
		//1.getupChar() 메서드는 영문 대분자 한글자를 입력받아 소문자로 바꾸어 리턴하는 메서드
		//2.getLowChar() 메서드는 영문 소문자 한글자를 입력받아 대문자로 바꾸어 리턴하는 메서드
		
		System.out.println("A를 소문자로 :" + getLowChar('A'));
		System.out.println("a를 대문자로 : " + getUpChar('a'));
	}
}
