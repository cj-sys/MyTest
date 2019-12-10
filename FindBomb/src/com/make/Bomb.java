package com.make;

public class Bomb {

	private int size;
	private String[][] arr;
	
	public Bomb() {
		size = 10;
	}	
	public Bomb(int size) {
		this.size = size;
	}
	
	public String[][] make() {
		arr = new String[size][size];
		
		fillTheZero();
		
		randomFill();
		
		procRes();
		
//		prnTest();
		
		return arr;
	}
	
	//먼저 0으로 전체를 체운다
	private void fillTheZero() {
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[i].length ; j++) {
				arr[i][j] = "0";
			}
		}
	}
	
	//랜덤으로 폭탄 체우기
	private void randomFill() {
		int cnt = size;
		
		while(cnt != 0) {
			
			int ranX = (int)(Math.random()*size);
			int ranY = (int)(Math.random()*size);
			
			if(!arr[ranX][ranY].equals("*")) {				
				arr[ranX][ranY] = "*";
				cnt--;
			}else {
				
			}
		}
	}
	
	
	//주위에 *있으면 cnt 
	private int proc(int x, int y) {
		int cnt = 0;
		for(int i = x-1; i<=x+1; i++) {
			for(int j = y-1; j<=y+1 ; j++) {
				if(arr[i][j].equals("*")) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private void procRes() {
		for(int i = 1 ; i < arr.length-1; i ++) {
			for(int j = 1 ; j < arr[i].length-1 ; j++) {
				//arr[i][j] = String.valueOf(proc(i,j));
				if(!arr[i][j].equals("*")) {
					arr[i][j] = String.valueOf(proc(i,j));
				}
			}
		}
	}
	
	private void prnTest() {
		for(int i = 0; i < arr.length;i++) {
			for(int j = 0 ; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
