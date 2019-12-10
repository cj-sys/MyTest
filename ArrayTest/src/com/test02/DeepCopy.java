package com.test02;

import java.util.Arrays;

public class DeepCopy {

	public static void main(String[] args) {

		//test1();
		//test2();
		//test3();
		test4();
	}

	// 1. 배열 인덱스의 값을 가져와서 복사
	public static void test1() {

		int[] oArray = { 10, 20, 30, 40 };
		int[] cArray = new int[oArray.length];

		for (int i = 0; i < oArray.length; i++) {
			cArray[i] = oArray[i];
		}
		System.out.println(Arrays.toString(oArray));
		System.out.println(Arrays.toString(cArray));
		System.out.println(oArray == cArray);

		System.out.println(oArray.toString());
		System.out.println(cArray.toString());

	}

	// oArray 한테 요청하여 복사 ( clone)
	public static void test2() {
		int[] oArray = { 10, 20, 30, 40 };
		int[] cArray = (int[])oArray.clone();
		
		
		System.out.println(Arrays.toString(oArray));
		System.out.println(Arrays.toString(cArray));
		System.out.println(oArray == cArray);

		
		
	}

	
	
	public static void test3() {
		int[] oArray = { 10, 20, 30, 40 };
		int[] cArray = new int[5];
		
		Arrays.fill(cArray, 100);
		
		System.out.println(Arrays.toString(cArray));
		
		System.arraycopy(oArray, 0, cArray,0, 4);
		System.out.println(Arrays.toString(cArray));
		
		System.out.println("==========================");
		
		System.out.println(oArray.hashCode());
		System.out.println(cArray.hashCode());
	}
	
	public static void test4() {
		int[] oArray = { 10, 20, 30, 40 };
		int[] coArray = new int[4];
		coArray = Arrays.copyOf(oArray, oArray.length);
		
		System.out.println(Arrays.toString(oArray));
		System.out.println(Arrays.toString(coArray));
	}
	
}
