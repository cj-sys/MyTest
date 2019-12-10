package com.collection.map.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.collection.model.vo.Snack;

public class HashMapEx {
	public void doMap() {
		
		Map<String, Snack> map = new HashMap<>();
		
		System.out.println("========= put() =========");
		map.put("새우깡", new Snack("짠맛", 500));
		map.put("다이제", new Snack("단맛", 1000));
		map.put("포테이토칩", new Snack("짠맛", 500));
		map.put("칸초", new Snack("단맛", 600));
		map.put("고소미", new Snack("고소한맛", 300));
		
		System.out.println(map);
		
		map.put("새우깡", new Snack("짠맛",200));
		System.out.println(map);
		System.out.println();
		
		System.out.println("========= containXXX =========");
		System.out.println("map.containsKey(\"새우깡\") : " + map.containsKey("새우깡"));
		System.out.println("map.containsValue(new Snack(\"짠맛\", 500)) : " + map.containsValue(new Snack("짠맛", 500)));
	
		System.out.println();
		System.out.println("===== map 뽑아내기 =====");
		
		System.out.println("--> 방법 1 : keySet + Iterator");
		Set<String> keySet = map.keySet();
		Iterator<String> keys = keySet.iterator();
		while(keys.hasNext()) {
			String key = (String)keys.next();
			System.out.printf("키 : %s, 값 : %s%n", key, map.get(key));
		}
		
		System.out.println();
		System.out.println("--> 방법 2 : keySet자체");
		for(Object key: map.keySet()) {
			System.out.printf("키 : %s, 값 : %s%n", key, map.get(key));
		}
		
		
		System.out.println();
		System.out.println("--> 방법 3 : entrySet");
		
	
	}
	
}
