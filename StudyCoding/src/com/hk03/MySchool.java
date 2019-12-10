package com.hk03;

public class MySchool {
	public static String MyName() {
		return "까릅뚜";
	}
	
	public static int MyYear() {
		return 1;
	}
	
	public static char MyClass() {
		return 'A';
	}
	
	public static int MyNum() {
		return 25;
	}
	
	public static void Prn(String myName, int myYear, char myClass, int myNum ) {
		System.out.printf("저는 %d학년 %c반 %d번 %s 입니다.\n",myYear, myClass, myNum, myName);
	}
	
	public static void main(String[] args) {
		String myName = MyName();
		int myYear = MyYear();
		char myClass = MyClass();
		int myNum = MyNum();
		
		Prn(myName, myYear, myClass, myNum);
	}
}
