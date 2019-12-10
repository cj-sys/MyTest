package io.file.fileChar.model.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharTest {
	
	public FileCharTest() {}
	
	//문자 기반 스트림으로 java에서는 한 문자를 의미하는 char형이 2byte이다.
	//1byte를 다루는 바이트 기반 스트림으로는 2byte인 문자를처리하기 어렵다.
	//이를 보완하기 위해 나온것
	
	// FileReader/Writer
	// CharArrayReader/Writer
	// PipedReader/Writer
	// StringReader/Writer
	
	//OutputStream에서 다루는 write메소드는 세가지
	//Writer에서 다루는 write메소드는 2개가 더 추가
	//write(int), write(char[]), write(char[],off,len)
	//+ write(String), write(String, int, int)
	
	public void fileSave() {
		//파일이 존재하지 않으면 자동으로 파일 생성
		//기존에 파일이 있으면 덮어 씌움
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("sample.txt");
//			fw = new FileWriter("sample.txt",true);
			//write()가 5개나 있다!! 스트링, 스트링의 길이제한하느것 두개가 추가됨
			fw.write("입출력 기술향상"); //write(String)
			
			char[] carr = new char[] {'a','b', 'c'};
			fw.write(carr);

			fw.write(carr,1,1);
			
			//write(String , off, len)
			fw.write("123456", 2, 3);
			
			//덮어쓰기 싫고 추가로 값을 넣고 싶을때는 매개변수 생성자에 true를 쓰면 된다..
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void fileRead() {
		FileReader fr = null;
		
		try {
			fr = new FileReader("sample.txt");
			
			int temp;
			while((temp = fr.read()) !=-1) {
				System.out.print((char)temp); //read를 temp에 담고
				//그냥 출력 하면 유니코드 값이니까 형변환
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
}
