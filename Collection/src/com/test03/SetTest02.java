package com.test03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.score.Score;

public class SetTest02 {

	public static void main(String[] args) {
		Score sm01 = new Score("이창진", 99, 80, 89);
		Score sm02 = new Score("홍길동", 100, 65, 85);
		Score sm03 = new Score("이순신", 68, 100, 77);

		Set<Score> hs = new HashSet<Score>();
		hs.add(sm01);
		hs.add(sm02);
		hs.add(sm03);
		
		//printSet(hs);
		
		transElem(hs,"홍길동",10);
	}

	public static void transElem(Set<Score> hs, String name, int korN) {
		for(Score s : hs) {
			if(s.getName().equals(name)) {
				s.setKor(korN);
			}
		}
		printSet(hs);
	}
	
	public static void printSet(Set<Score> hs) {
		//방법 1
		/*
		 * for(Score s : hs) { System.out.println(s); }
		 * 
		 * 
		 * //방법 2 Object[] oArr = hs.toArray(); for(Object o : oArr) {
		 * System.out.println(o); }
		 */
		
		//방법 3
		Iterator<Score> ir = hs.iterator();
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
		
		
	}
}
