package com.bbb;

import com.aaa.AAA;

public class BBB extends AAA {
	
	private int b;
	
	public BBB() {
//		super();
		System.out.println("bbb생성");
	}

	public BBB(int b) {
		super(b); // 선조의 생성자 -> AAA(abc);
		this.b = b;
		System.out.println("BBB 생성 (b 받아서 생성)");
	}

	public BBB(int abc, int b) {
		super(abc);
		this.b = b;
		System.out.println("BBB 생성 (abc, b 받아서 생성)");
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getSum() {
		int sum = super.getAbc() + this.getB();
//		int bb = b;
//		System.out.println("getSum 실행->bb의 값은 : "+bb);
		
//		int sum = super.getAbc() + b;
		return sum;
	}
	
	@Override
	public void prn() {
//		super.prn();
		System.out.println("bb.prn()");
	}
}
