package com.kh.io.silsub1.model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest {

	public void fileSave() {
		BufferedReader br = null;
		FileWriter fw = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("파일명을 입력하세요 : ");
			String fileName = br.readLine();

			fw = new FileWriter(fileName);

			String str = null;


			while(true) {
				System.out.print("파일에 저장할 내용을 입력하세요 : ");
				str = br.readLine();
				char[] carr = str.toCharArray();
				if(!str.equals("exit")) {
					fw.write(carr);
				}else {
					System.out.println("파일에 성공적으로 저장하였습니다.");
					break;
				}

			}


		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}


	public void fileRead() {
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("읽을 파일 이름을 입력하세요 : ");
			String fileName = br.readLine();

			fr = new FileReader(fileName);
			int value;
			StringBuilder sb = new StringBuilder();

			while((value = fr.read()) != -1) {
				sb.append((char)value);
			}

			String str = sb.toString();
			System.out.println(str);


		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}


}
