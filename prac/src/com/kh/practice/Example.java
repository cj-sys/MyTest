package com.kh.practice;

import java.util.Scanner;

public class Example {
	
	public void sample1() {
		int kor,eng,mat,total;
		double avg;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("kor :");
		kor = sc.nextInt();
		System.out.println("eng :");
		eng = sc.nextInt();
		System.out.println("mat :");
		mat = sc.nextInt();
		
		total = kor+eng+mat;
		avg = total/3.0;
		
	/*	if((kor>40 && eng>40 && mat>40) && avg>60 ) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}*/
		
		
		
		sc.close();
		
	}
	
	public void sample2() {
		
		String name;
		int hak;
		int ban;
		int bun;
		char sex;
		double grade;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("name :");
		name = sc.next();
		System.out.println("hak :");
		hak = sc.nextInt();
		System.out.println("ban :");
		ban = sc.nextInt();
		System.out.println("bun :");
		bun = sc.nextInt();
		System.out.println("sex :");
		sex = sc.next().charAt(0);
		System.out.println("grade :");
		grade = sc.nextDouble();
		
		System.out.println("성별!!!!!!!!!!!!      "+sex);
		String sexx;
		if(sex=='M') {
			sexx = "남학생";
			System.out.println(hak + "년 "+ban+"반 "+bun+"번 "+sexx+" "+name+"은 성적이 "+grade+"이다.");
		} else {
			sexx = "여학생";
			System.out.println(hak + "년 "+ban+"반 "+bun+"번 "+sexx+" "+name+"은 성적이 "+grade+"이다.");
		}
		
		
	}
	
	public void sample3() {
		int a;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("insert :");
		a=sc.nextInt();
		
		if(a>0) {
			System.out.println("양수다");
		} else {
			System.out.println("양수가 아니다");
		}
	}
	
	public void sample4() {
		int a;
		String s;
		
		Scanner sc = new Scanner(System.in);
		a=sc.nextInt();
		
		if(a%2==0) {
			s="짝수다.";
		} else {
			s="홀수다";
		}
		System.out.println(s);
		
		
	}
	
}
