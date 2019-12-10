package com.game;

public class PrintArr {

	private String[][] tmp;
	private String[][] original;

	public void start(String[][] arr) {
		tmp = new String[arr.length][arr.length];
		original = arr;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				tmp[i][j] = "■";
			}
		}
	}

	public void input(int x, int y) {
		int transX = tmp.length - 1 - x;
		tmp[transX][y] = original[transX][y];
	}

	public void prn() {
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp.length; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
