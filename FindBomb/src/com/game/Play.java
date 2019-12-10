package com.game;

import java.util.Scanner;

import com.make.Bomb;

public class Play {

	private static String[][] target;
	private static Scanner sc = new Scanner(System.in);
	
	public static void playing(int size) {
		Bomb bomb;
		if(size != 0) {
			bomb = new Bomb(size);
		}else {
			bomb = new Bomb();
		}
		
		target = bomb.make();
		boolean playing = true;
		
		PrintArr print = new PrintArr();
		print.start(target);
		
		do {
			int[] inputXY = input();
			
			print.input(inputXY[1], inputXY[0]);
			print.prn();
			System.out.println("* * * * * * * * * * *");
			
		}while(playing);
	}
	
	public static int[] input() {
		System.out.println("X Y 입력 : ");
		String[] in = sc.nextLine().split(" ");
		
		int[] out = new int[2];
		out[0] = Integer.parseInt(in[0]);
		out[1] = Integer.parseInt(in[1]);
		
		return out;
	}
}
