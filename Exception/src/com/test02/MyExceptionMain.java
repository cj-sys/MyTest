package com.test02;

import java.util.Scanner;

public class MyExceptionMain {

	public static void main(String[] args) {
		
		int a=0;
		
		try {
			System.out.println("숫자입력 : ");
			Scanner sc = new Scanner(System.in);
			a=sc.nextInt();
			
			if(a==100) {
				throw new MyException();
			}
		} catch (MyException m) {
			System.out.println("myException");
			
			m.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception");
		}
		
		
	}

}
