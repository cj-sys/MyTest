package com.test03;


public class Thread04 {
	public static void main(String[] args) {
		MyThread03 m1 = new MyThread03("야옹");
		MyThread03 m2 = new MyThread03("멍멍");
		
		long start_time = System.currentTimeMillis();
		
		m1.start();
		
		try {
			m1.join();
			//m1 thread가 종료 될때 까지 다른  thread를 멈춤
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		m2.start();
		
		long end_time = System.currentTimeMillis();
		
		System.out.println("실행시간 : " + (end_time - start_time));
	}
}
