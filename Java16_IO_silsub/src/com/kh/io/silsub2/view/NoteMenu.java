package com.kh.io.silsub2.view;

import java.util.Scanner;

import com.kh.io.silsub2.controller.NoteManager;

public class NoteMenu {

	public void menu() {
		
		NoteManager nm = new NoteManager();
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("=========== MyNote ===========");
			System.out.println();
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 끝내기");
			System.out.println();
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();
			
			switch(no) {
				case 1 : nm.fileSave(); break;
				case 2 : nm.fileOpen(); break;
				case 3 : System.out.println("Note프로그램을 종료합니다."); return;
				default : System.out.println("번호 선택이 잘못되었습니다.");
							System.out.println("다시 선택하십시오 \n");
				
			}
			
		}while(true);
		
	}

}
