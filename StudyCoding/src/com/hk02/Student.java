package com.hk02;

public class Student {
	public static void main(String[] args) {
		String name="이창진";
		int kor = 90;
		int eng = 74;
		int math = 88;
		
		Score sc = new Score();
		char grade = sc.getGrage(sc.getAvg(kor, eng, math));
		
		System.out.println(name+"님의 성적은 "+grade+"입니다.");
	}
}
