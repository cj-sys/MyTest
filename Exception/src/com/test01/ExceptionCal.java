package com.test01;

import java.util.Scanner;

public class ExceptionCal {
	public int calculation() {
		int res =0;
		
		while(true) {
			try {
				res=inputNum()/inputNum();
				System.out.println(res);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		
		return res;
	}
	
	public int inputNum() {
		int n =0;
		
		System.out.println("숫자만 입력하세요(숫자아니면 예외) : ");
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		
		return n;
	}
}
