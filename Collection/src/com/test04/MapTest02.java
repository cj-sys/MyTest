package com.test04;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.score.Score;

public class MapTest02 {

	public static void sortMap(Map<Integer,Score> mp) {
		Map<Integer, Score> sm = 
				new TreeMap<Integer,Score>(new MyOrder(mp));
		
		sm.putAll(mp);
		printMap(sm);

	}
	
	public static void main(String[] args) {
		Score sm01 = new Score("가가가", 70, 100, 56);
		Score sm02 = new Score("나나나", 90, 97, 100);
		Score sm03 = new Score("다다다", 80, 89, 88);
		
		Map<Integer, Score> mp = new HashMap<Integer, Score>();
		mp.put(1, sm01);
		mp.put(2, sm02);
		mp.put(3, sm03);
		
		printMap(mp);
		sortMap(mp);
		
	}
	
	public static void printMap(Map<Integer, Score> mp) {
		Set<Map.Entry<Integer, Score>> sm = mp.entrySet();
		
		for(Map.Entry<Integer, Score> my : sm) {
			System.out.println(my.getKey()+" : " + my.getValue());
		}
	}

}


class MyOrder implements Comparator<Integer>{

	Map<Integer, Score> mp;
	
	public MyOrder(Map<Integer, Score> mp) {
		this.mp=mp;
	}
	
	
	@Override
	public int compare(Integer o1, Integer o2) {
		//1이면 앞의 인자 큰 값, 0이면 같은 값, -1 뒤의 인자가 큰 값
				if(mp.get(o1).getKor() > mp.get(o2).getKor()) {
					return -1;	//내림차순으로 정렬하기 위해, 거꾸로 썼다.(원래는 1)
				}else if(mp.get(o1).getKor() == mp.get(o2).getKor()) {
					if(mp.get(o1).getEng() > mp.get(o2).getEng()) {
						return -1;
					}else {
						return 1;
					}
				}else {
					return 1;
				}
	}
}