package com.test01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest02 {

	public static void main(String[] args) {
		File fi = new File("a.txt");
		
		try {
			MyInPut(fi);	
			MyOutPut(fi);
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void MyInPut(File fi) throws IOException {
		FileReader fr = new FileReader(fi);
		
		//처음부터 file 내용 끝까지(-1) 한글자씩 일어서 출력
		int ch;
		
		while((ch=fr.read()) !=1) {
			System.out.println((char)ch);
		}
		fr.close();
	}
	
	private static void MyOutPut(File fi) throws IOException	{
		FileWriter fw = new FileWriter(fi);
		fw.write("Test~~~~~~\n");			//writer : 덮어쓰기	
		fw.append("addddddddddddddd\n");	//append : 추가하기
		
		fw.close();
	}

}
