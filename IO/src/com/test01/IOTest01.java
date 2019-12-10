package com.test01;

import java.io.File;
import java.io.IOException;

public class IOTest01 {
	public static void main(String[] args) {
		
		//해당 경로에 fi(Test)를 생성
		File fi = new File("C:\\Test_IO");
		
		
		if(fi.exists()) {
			System.out.println("exists");
		}else {
			System.out.println("new!!");
			fi.mkdirs();
		}
		
		//fi(c://Test_IO) 밑에 AA 생성
		File fic1 = new File(fi,"AA");
		fic1.mkdir();
		
		
		File fic2 = new File("c:\\Test_IO", "BB");
		fic2.mkdir();
		
		//t_file(a.txt)라는 애를 fic1(AA) 밑에다 생성
		File t_file = new File(fic1, "a.txt");
		
		try {
			//checked exception
			t_file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
