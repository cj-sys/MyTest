package com.kh.io.silsub2.controller;

import java.util.Scanner;

import com.kh.io.silsub2.model.dao.NoteDao;

public class NoteManager {
	private Scanner sc = new Scanner(System.in);

	public void fileSave() {
		StringBuilder sb = new StringBuilder();
		
		System.out.print("파일에 저장할 내용을 입력하세요 : ");
		
		while(true){
			String s = sc.nextLine();
			
			if(s.equals("exit")){
				break;
			}
			
			sb.append(s + "\n");
			
		}
		
		System.out.print("저장하시겠습니까?(y/n) : ");
		char yn = sc.nextLine().toUpperCase().charAt(0);
		
		if(yn == 'Y'){
			System.out.print("저장할 파일명을 입력하세요 : ");
			String fileName = sc.nextLine();
			
			NoteDao nd = new NoteDao();
			
			nd.fileSave(sb, fileName);
			
		}else{
			System.out.println("저장하지 않고 메뉴로 돌아갑니다.");
			return;
		}
		
	}

	public void fileOpen() {
		System.out.print("열기할 파일명을 입력하세요 : ");
		String fileName = sc.nextLine();
		
		StringBuilder sb = new NoteDao().fileOpen(fileName);
		
		System.out.println(sb);
		
	}

	

}
