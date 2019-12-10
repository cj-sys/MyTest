package com.test01;

class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("i = "+i);
		}
	}
	
}

public class Thread01 {

	public static void main(String[] args) {
		//main Thread가 우선순위. -------이 먼저 출력
		System.out.println("main start----------");
		
		/*	
		//Thread가 아니다.
		MyThread m01 = new MyThread();
		MyThread m02 = new MyThread();
		m01.run();
		m02.run();
*/
		//Thread이다.
		
		
		Thread m01 = new Thread(new MyThread());
		Thread m02 = new Thread(new MyThread());
		
		m01.setDaemon(true);
		
		m01.start();
		m02.start();//자동으로 run을 부른다.
		
		System.out.println(m01.getState() + ":" + m01.isDaemon());
		
		System.out.println("main stop----------------");
		
		
		
		
		
	}

}
