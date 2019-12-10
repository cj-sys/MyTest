package com.hk02;

public class Calc {
	
	public static void Sum(int a, int b) {
		int sum=0;
		
		sum=a+b;
		System.out.printf("%d + %d = %d 입니다.", a,b,sum);
	}
	
	public static void Sub(int a, int b) {
		int sub=0;
		
		sub=a-b;
		System.out.printf("%d - %d = %d 입니다.", a,b,sub);
	}
	
	public static void Mul(int a, int b) {
		int mul=0;
		
		mul=a*b;
		System.out.printf("%d * %d = %d 입니다.", a,b,mul);
	}
	
	public static void Div(int a, int b) {
		int div=0;
		div=a/b;
		int div2=0;
		div2=a%b;
		System.out.printf("%d / %d 의 몫은 %d 입니다.", a,b,div);
		System.out.printf("%d / %d 의 나머지는  %d 입니다.", a,b,div2);
	}
	
	
	
}
