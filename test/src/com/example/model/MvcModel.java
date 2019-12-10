package com.example.model;

import java.util.ArrayList;

public class MvcModel {

	public ArrayList getColor(String color) {
		ArrayList colors = new ArrayList();
		
		if(color.equals("red")) {
			colors.add("first");
			colors.add("red");
		} else if(color.equals("green")) {
			colors.add("second");
			colors.add("green");
		} else {
			colors.add("third");
			colors.add("blue");
		}
		
		return colors;
	}

}
