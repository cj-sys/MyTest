package com.test02;

import java.util.Scanner;

public class asdffsa {

	public static void main(String[] args) {
		System.out.print("양의 정수 입력 : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (i == 0 || i == num - 1) {
					System.out.print("*");
				} else {
					if (j == 0 || j == num - 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}

	}

}
