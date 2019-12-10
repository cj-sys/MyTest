package com.test02;

class MyThread02 extends Thread{

	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("i = " +i);
		}
	}
}

public class Thread02 {
	public static void main(String[] args) {
		MyThread02 m1 = new MyThread02();
		MyThread02	m2 = new MyThread02();
		
		m1.start();
		m2.start();
	}
}
