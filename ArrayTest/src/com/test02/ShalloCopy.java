package com.test02;

import java.util.Arrays;

public class ShalloCopy {

	public static void main(String[] args) {
		int[] iArray = {10,20,30};
		int[] cArray=iArray;	//reference를 복사
		
		System.out.println(Arrays.toString(iArray));
		System.out.println(Arrays.toString(cArray));
		
		System.out.println(iArray == cArray);
		
		cArray[2] = 90;
	
		System.out.println(Arrays.toString(iArray));
		System.out.println(Arrays.toString(cArray));
		
		System.out.println(iArray.hashCode());
		System.out.println(cArray.hashCode());
		
	}

}
