package io.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedPrec {

	public static void main(String[] args) {
		byte[] bt = new byte[1024];

		//어제는 BufferedReader를 썻었쬬?? 그래서 InputStreamReader로 변환을 했던것이고!! 
		//이번엔 바이트형식의 BufferedInputStream으로 만들어보자.. 변환X 
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		System.out.println("입력한 것을 파일에 저장과 함께 콘솔에 출력해보기 ");
		System.out.println("================================");

		try {
			
			bis = new BufferedInputStream(System.in, 1024);
			System.out.print("입력: ");
			bis.read(bt);

			bos = new BufferedOutputStream(new FileOutputStream("input.txt"));
			bos.write(bt);

			System.out.print("출력: ");
			System.out.println(new String(bt));

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		//===================================================================================================
		//try with resource
		//===================================================================================================
/*
		try (BufferedInputStream bis= new BufferedInputStream(System.in, 1024);
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("input.txt"));){

			System.out.print("입력: ");
			bis.read(bt);

			bos.write(bt);

			System.out.print("출력: ");
			System.out.println(new String(bt));

		} catch (IOException e) {
			e.printStackTrace();
		}
	*/
	}
}
