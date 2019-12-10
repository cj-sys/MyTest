package com.test03;

public class MTest {

	public static void main(String[] args) {
		Person a = new Person();
		a.name="이순신";
		a.age=50;
		
		Person b = new Person();
		b.name="홍길동";
		b.age=28;
		
		Couple c = new Couple();
		Person[] couple = c.couple(a, b);
		
		for(int i=0; i<couple.length; i++) {
			System.out.println(couple[i].name+" "+couple[i].age); 
		}
		
		
		
	}

}
