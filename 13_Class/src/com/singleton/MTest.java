package com.singleton;

public class MTest {

	public static void main(String[] args) {
	//	SingleTon st = new SingleTon();
		
		SingleTon st = SingleTon.getInstance();
		System.out.println(st);
		
		SingleTon st02 = SingleTon.getInstance();
		System.out.println(st02);
		
		System.out.println(st==st02);
		
		System.out.println(st.hashCode());
		System.out.println(st02.hashCode());
	}

}
