package com.test01;

public class MTest {

	public static void main(String[] args) {
		AA a = new AA();
		Super s = a;	//Super s;
						// a(instance);		
		//BB b = (BB) s;	//ClassCastException 발생
		System.out.println(a.hashCode());
		System.out.println(s.hashCode());
	}
}
