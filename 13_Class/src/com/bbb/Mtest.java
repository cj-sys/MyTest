package com.bbb;

import com.aaa.AAA;

public class Mtest {

	public static void main(String[] args) {
		BBB b1 = new BBB();
		b1.setAbc(1);
		b1.setB(2);
		System.out.println(b1.getSum());
		b1.prn();
		
		BBB b2 = new BBB(3);
		b2.setB(4);
		System.out.println(b2.getSum());
		
		
		BBB b3 = new BBB(5,6);
		System.out.println(b3.getSum());
		
		
		
		
		System.out.println("===========================");
		AAA a1 = new AAA();
		AAA a2 = new BBB();
//		BBB a3 = new AAA();
		a1.prn();
		a2.prn();
	}

}
