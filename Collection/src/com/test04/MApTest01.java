package com.test04;

import java.util.HashMap;
import java.util.Map;

public class MApTest01 {

	public static void main(String[] args) {
		Map<Integer, String> mp = new HashMap<Integer, String>();
		
		for(int i=111; i<116; i++) {
			//map.put(k,v)
			mp.put(i, i+"abc");
		}
	}

}
