package io.conversion.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//바이트 기반 스트림을 문자스트림으로 바꿔주는 보조 스트림은??
//InputStreamReader, OutputStreamWriter
public class ByteToCharTest {

	// 매개변수로 외부자원을 선택한다면 기반!
	// 매개변수로 어떠한 스트림을 선택하는게 보조!!

	// ->보조는 단독으로 사용 불가, 항상 기반스트림클래스를 생성하고 그 객체를 가지고 보조스트림 클래스를 사용해야한다.

	public ByteToCharTest() {
	}

	public void input() {
		// 키보드로 입력받는 경우 두가지 => Scanner , BufferedReader
		// 1. Scanner로 쓸 경우 --> sc.nextInt(), sc.nextDouble()... 자료형에 맞춰서 메소드 실행하는 단점
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		double b = sc.nextDouble();

		// 표준입출력이란?
		// System.in(키보드로(콘솔)값을 입력), System.out(모니터(콘로값을 출력), System.err
		// JVM이 자동으로 스트림을 제공해주므로 우리가 생성같은게 필요없다.(스트림을 열고 닫아줄 필요없다.) --> new를 통해 어떤 작업을 할
		// 필요없이
		// 바로 기반으로 인식(외부자원으로 콘솔(키보드, 모니터)를 선정한채로)
		// 얘는 내부저긍로 아~ 너키보드쓸거야~ 라고 기본적으로 JVM이 제공해준다..
		// (system.in 만써도 되는거다. new ~ stream 필요없이)

		
		
		
		// 2.BufferedReader로 쓸 경우 -->br.readList() 하나만으로 내가 어떤 값을 입력하든 Strirng으로 입력하는 장점
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 아~ 어떤 외부자원으로 키보드를 선택한 이 기반스트림을 보조해주는 얘를 같이 사용한 상황

		//보조 인스턴스 = new 보조(new 보조(new 기반))  !!!!!
		
		
		// 표준입출력이란?
		// System.in(키보드로값을 입력), System.out(모니터로값을 출력), System.err
		// JVM이 자동으로 스트림을 제공해주므로 우리가 생성같은게 필요없다.(스트림을 열고 닫아줄 필요없다.) --> new를 통해 어떤 작업을 할
		// 필요없이
		// 바로 기반으로 인식(외부자원으로 콘솔(키보드, 모니터)를 선정한채로)

		try {
			System.out.println("값을 입력하세요 : ");
			String value = br.readLine();

			System.out.println("value: " + value);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//바이트기반스트림 system.in -> InputSteamReader을 통해 변환 -> BufferedReader의 readLine()사용해서 속도를향상시킨것
		
		
		// 2.파일로 읽어보자!!!

		// 먼저 이렇게 해보자!!!
		// BufferedReader br2 = new BufferedReader(new InputStreamReader("sample.txt"));
		// ㄷ안되죠?? 왜그럴까요? 기반 스트림이 없어서 그렇다! 이전에 system.in이 기반스트림이었고 JVM이 자동으로 생성 해주기에 new
		// 없이 사용을 했었다!
		BufferedReader br2 = null;
		try {
			// BufferedReader br2 = new BufferedReader(new InputStreamReader(new
			// FileInputStream("sample.txt")));
			br2 = new BufferedReader(new InputStreamReader(new FileInputStream("sample.txt")));
			System.out.println("바이트기반스트림 + 문자보조스트림");
			System.out.println(br2.readLine());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// System.in 자체가 기반스트림!!!!!
		// 콘솔을 외부자원으로 선택한 표준입출력이다.
		InputStream i = System.in;

		// sys.in 은 Inputstream(바이트스트림)유형이다.
		// ->그래서 여기에 (new InputStreamReader(system.in))
		// 그래서 보조스트림인 InputStreamReader와 사용되는것이다.

		// System.in은 바이트기반이기 때문에 문자 기반을 요하는 BufferReader에서는 바로 사용이 안됨
		// 그래서 바이트 기반을 문자기반으로 바꿔주는, 변환작업해주는 보조스트림이 필요
		// ->InputSteramReader,OutputStreamReader

		// InputStreamReader로만 객체생성해서 사용해도 되는데
		// InputStreamReader isr = new InputStreamReader(System.in);
		// 이렇게는 보통 사용안하고 BufferedReader를 같이 사용한다. 왜냐면 readLine()메소드를 이용하기 위해서..!!!!!!!!

		// new BufferedReader(System.in); 이렇게 쓰면 안되나??????
		// sysem.in이 바이트 단위 기에 바이트 단위 보조를 가지고 해야 되는데.. 버퍼드리더는 문자 기반이다!!
		// 그래서 inputstream을 통해 변환작을 해줘야 하는것이다!
		// 이런식으로 세트로 묶여서 자주 사용된다!!!

		// ==>이렇게 하신분들도 있으실거다!!!
		// 그치만 이렇게하던 이유갸 system.in이 바이트형 스트림이고 bufferedReader이 문자형이어서 InputStreamReader로
		// 변형을 해준거다!!
		// 그러니 기반스트림을 문자형으로 변경하면 굳이 이렇게 변형을 해줄필요가 사라지는거다!
		// 그렇다면 여기서 문자기반스트림은 어떤것일가요?
		
		  BufferedReader br3=null; 
		  try { 
		  	br3 = new BufferedReader(new FileReader("sample.txt")); 
		  	System.out.println("문자기반 스트림+문자보조스트림 ");
		  	System.out.println(br3.readLine()); 
		  } catch (FileNotFoundException e) {
		  	e.printStackTrace(); 
		  } catch (IOException e) { 
		  	e.printStackTrace(); 
		  } finally { 
		  		try { 
		  			br3.close(); 
		  		} catch (IOException e) { 
		  			// TODO Auto-generated catch
		  			 e.printStackTrace(); 
		  			} 
		  		}
		

	}

	public void output() {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// => 이렇게도 변경가능하다!!
//		OutputStreamWriter osw= new OutputStreamWriter(System.out);
//		BufferedWriter bw = new BufferedWriter(osw);

		
		// 클로즈 없이 실행 -> flush해주고 실행 -> 클로즈해주고 실행
		try {
			bw.write("hello everyone");
			//write() ->버퍼에 넣는다.  / flush() -> 버퍼에 넣은걸 뺀다
			
			// bw.flush();
			// 버퍼드리더나, 버퍼드라이터는 버퍼에 데이터가 쌓이고~~ 한번에 붜억!
			// 지금 버퍼에 데이터가 "hello everyone"이 쌓여있긴한데
			// 빼줘야지 출력이 되는데!! 안해줬어요!!

			// 클로즈를 하면 ㅏㅈ동으로 되는거였다.!!!

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		// 여기서 나오는게 try with resource
		// finally를 이용하여 close() 반드시 처리해주는 내용과 달리
		// try(객체생성){} catch(예외 레퍼런스) {}
		// 와 같이 실행하면 자동으로 close() 처리된다!!!!
		
		//매개변수로 들어가있는 스트림을 알아서 내부적으로 닫는 작업을 한다.
		
		/*
		  try(BufferedWriter bw = new BufferedWriter(new
		  OutputStreamWriter(System.out))){ 
		  	bw.write("hello everyone");
		  
		  }catch(IOException e) { 
		  	e.printStackTrace(); 
		  }
		 */

		/*
		 * 이번에 실습한 내용 BufferedReader의 readLine()을 사용하면 정말 쉽게 입력을 받을수 잇다!!! 하지만
		 * BufferedReader는 문자형스트림! System.in은 InputStream(바이트스트림)유옇ㅇ이므로 두개가 맞지 않다!! 그래서
		 * InputStreaReader로 통해 변환시켜주는거다!!!
		 * 
		 */

		// 2
		try(BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test2.txt")))) {
			bw2.write("지금은");
			bw2.write("입출력 기슬향상 ");
			bw2.write("시간입니다!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
