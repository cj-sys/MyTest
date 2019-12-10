package com.hk03;

public class Student {
	public static int getSum(int kor, int eng, int math) {
		int sum = kor + eng + math;
		return sum;
	}
	
	public static double getAVG(int tot) {
		double avg = (double)tot/3;
		return avg;
	}
	
	public static void main(String[] args) {
		int kor, eng, mat;
		kor=eng=mat=0;
		
		kor=90;
		eng=85;
		mat=73;
		
		int sum=0;
		double avg=0;
		
		sum=getSum(kor, eng, mat);
		//avg=getAVG(sum);
		avg=getAVG(getSum(kor, eng, mat));
		System.out.printf("kor : %d, eng : %d, math : %d\ntotal : %d\navg : %.1f\n",kor,eng,mat,sum,avg);
	}
}
