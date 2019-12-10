package com.test03;

//스레드 이름을 지정하자
class MyThread03 extends Thread{
	public MyThread03(String name) {
		super(name);
	}
	
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println(this.getName() + " = " + i);
		}
		System.out.println(this.getName()+" =끝");
	}
}

public class Thread03 {
	public static void main(String[] args) {
		MyThread03 m1 = new MyThread03("야옹");
		MyThread03 m2 = new MyThread03("멍멍");
		
		//java의 thread scheduling은 우선순위(priority)와 순환할당(round robin) 방식을 사용한다.
		
		//priority : 우선순위
		m1.setPriority(10);
		m2.setPriority(Thread.MIN_PRIORITY);
		m1.start();
		m2.start();
		
		System.out.println(m1.getId() + " : " + m1.getName());
		System.out.println(m2.getId() + " : " + m2.getName());

		System.out.println(m1.getName() + m1.getPriority() + " : " + m2.getName() + m2.getPriority());
		
		
	}
}
