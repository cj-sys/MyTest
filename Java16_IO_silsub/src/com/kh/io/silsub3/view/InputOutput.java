package com.kh.io.silsub3.view;

import java.util.Scanner;

import com.kh.io.silsub3.model.dao.SungjukDao;
import com.kh.io.silsub3.model.vo.Sungjuk;

public class InputOutput {
	private Scanner sc = new Scanner(System.in);
	
	public void input(){		
		do{
			System.out.print("국어 : ");
			int kor = sc.nextInt();
			System.out.print("영어 : ");
			int eng = sc.nextInt();
			System.out.print("수학 : ");
			int math = sc.nextInt();
			
			Sungjuk s = new Sungjuk(kor, eng, math);
			
			SungjukDao sd = new SungjukDao();
			sd.sungjukSave(s);
			
			System.out.print("계속 저장하시겠습니까? (y/n) : ");
			
		}while(sc.next().toUpperCase().charAt(0) != 'N');
	}
	
	public void output(){
		SungjukDao sd = new SungjukDao();
		
		sd.sungjukOpen();
		
	}
}
