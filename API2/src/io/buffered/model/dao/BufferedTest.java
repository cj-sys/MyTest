package io.buffered.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedTest {
		
	public BufferedTest() {
		
	}
	
	public void output() {
		//보조스트림 - BufferedWriter
		//기반스트림 - FileWriter
		//외부자원 - sample2.txt 
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("sample2.txt"))){
			
			bw.write("안녕하세요 여러분");	// 이어쓸것
			bw.write(" 창진쌤입니다\n");	// 개행하고 싶을때 \n을 직접입력해도되고
			bw.write("언제나 항상 여러분들을 응원합니다.");
			bw.newLine();				// 다음과 같이 newLine메소드를 이용해서 개행해도 된다. BufferedWriter에만 가지고 있는 메소드
			bw.write("뽜이팅!!");
			
			//개행 -> \n, newLine()
			
		} catch ( IOException e) {
			e.printStackTrace();
		}
	
	
	}
	
	public void input() {
		try(BufferedReader br = new BufferedReader(new FileReader("sample2.txt"))){
			
			// 사실상 BufferedReader를 쓰는 이유는 readLine을 사용하기 위해서이다.
			// readLine은 읽어올때 한줄 씩 불러오는 역할을 한다. 
			/*System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());*/
			
			//출력문 막 해보자!!! 몇줄 있을지 모르니!!!
			//null 출력되는거 확인할수있따!!! 즉 끝을 만나면 null이 들어온다!
			
			//한줄 전체를 읽어서 String형태로 리턴을 해주기에 readLine했을대 아무것도 읽을게 없기에 null리턴
			//그전에 FileInputStream,FileReader에서 read했는데 읽어올 데이터 없을때 -1 리턴받았던거 기억나나??
			//api 가서 read확인해봅시다!FileReader에서 read() 매서드의 return을 확인해보자
			//그친구는 데이터가 없다! 라고 하면 정수형을 리턴받으니 null이 들어갈수 없어서 -1!
			
			
			String value="";
			while((value=br.readLine()) != null) {
				System.out.println(value);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//output2()를 만들어 output()에서 작성한 내용에 덮어쓰지말고 내용을 추가해보자
	//api 들어가서 FileWriter에서 찾아보고 해보세요
	public void output2() {
		/*
	 	현재 input*()은 새로 실행하면 덮어 씌우는 거다!!
	 	이어서 하고 싶다!!!! 라고 하면
	 	BufferedWriter bw = new BufferedWriter(new FileWriter("simple.txt",true)))
	 	FileWriter(파일이름, boolean) 이런 매개변수를 가진 생성자로 변경을 하면 추가가된다!!!!
	 */
		
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("sample2.txt",true))) {
			
			bw.newLine();
			bw.write("추가추가추가욥!");
			bw.newLine();
			bw.append("축하도 추가요!");
			//charSequence
			//String의 상위! 인터페이스이다.
			//거의 비슷 한데 String기본자료형 취급을 받은놈이니 은좀더 사용하기 편리한 메서드들이 많다는 정도~
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
}
