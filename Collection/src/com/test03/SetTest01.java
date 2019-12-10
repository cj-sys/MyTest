package com.test03;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {

	public static void main(String[] args) {
		Set<String>	 st = new HashSet<>();
		
		st.add("1");
		st.add("2");
		st.add("3");
		st.add("4");
		st.add("5");
		st.add("6");
		st.add("7");
		st.add("7");
		//st.add(null); //null 이라는 값으로 받는다.
		//하지만 외부에서 접근하게 되면 nullpointException 발생한다.
		
		System.out.println(st);
		setFind(st,"5");
		setDel(st, "5");
	}

	public static void setDel(Set<String> st, String delE) {
		for(String del : st) {
			if(del.equals(delE)) {
				System.out.println(del+"   DELETE!!!!!!!");
				st.remove(del);
				break;	//break문이 없다면 ConcurrentModificationException 발생한다.
						//for문을 돌리는데 index 비교하며 같은지를 검색하는데,.. 도중에 remove를 하게되어 
						//기존 index값과 줄어든 size값이 맞지 않기 때문에 예외가 발생...
			}
		}
	}
	
	
	public static void setFind(Set<String> st, String findE) {
		for(String f : st) {
			if(f.equals(findE)) {
				System.out.println(findE + " FIND!!!!!!!!!");
			}
		}
		
		
	}

}
