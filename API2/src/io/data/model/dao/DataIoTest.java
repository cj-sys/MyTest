package io.data.model.dao;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataIoTest {
	
	private String fileName = "member.txt";

	public DataIoTest() {

	}
	
	// DataInput/OutputStream은 바이트 기반 보조 스트림이다. 
	// 어떠한 데이터를 읽는데 1byte단위가 아니라 우리가 알고있는 8가지의 기본 자료형, String 참조자료형 단위로 읽고 쓸수 있다. 
	// 각타입에 해당하는 다양한 메서드가 존재한다.
	// 자바의 기본 자료형 데이터를 바이트 스트림으로 입출력하는 기능을 제공하는 ByteStream 클래스

	public void addData() {
		
		try(DataOutputStream dout = new DataOutputStream(new FileOutputStream(fileName))){
			
			//write가 엄청 많다!! 기본자료형별로 다 있다.
			//기본자료형을 가지고 자료형 까지 저장을 할수가 있다
			dout.writeUTF("홍길동");			// 이름(String)
			dout.writeInt(22);				// 나이(int)
			dout.writeChar('M');			// 성별(char)
			dout.writeDouble(180.5);		// 키(Double)
			
			// FileInputStream이랑 뭐가 다르냐 ..
			// FileInputStream으로 했을 경우 깨진다... 불러올때도 제대로 못불러온다.
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		// 메모장을 확인해보면 깨진거를 볼 수 있다.
		// 왜냐하면 Data를 쓸 경우 아까 말했다 시피 8가지 기본 자료형 단위로 읽고 쓴다 하지 않았냐
		// 그래서 값이 저장될때 해당 데이터형을 가지고 저장된다. 
		// "홍길동"을 저장할때 String자료형을 가지고 저장되고, 65를 저장할 때 int자료형을 가지고 저장되고 
		//사실상 깨지는게 맞긴하다
		//OS에서 자바 코드를 관리해주기 때문에 안깨지게 보이는거였는데.
		//지금은 자료형을 가지고 있기 때문에 인코딩이 안된체 가져오기에 깨져보인다.!!!!
		
		
		//MS949 환경인데!! utf8로 저장을 햇자나요?? 그래서 깨진다1!!!!!
		
		
		// 애들이 그래도 이해를 못함 왜깨지는지....
		// 사실상 우리가 작업하는 환경이 윈도우라서 MS949환경이다.
		// 그러면 텍스트 파일이나 그런것들도 MS949환경이다
		// 위에 우리가 어떤 String값을 넣기 위해 writeUTF()메소드를 사용했는데 사실 이게 UTF-8인코딩 작업을 한채로  들어간다.
		// 그래서 문자가 깨지는게 맞다.
		
		// 근데 그냥 바이트 단위나 문자단위 기반스트림을 가지고 문자열 넣을 때는 안깨지는게 맞는데
		// 왜그러냐면 이클립스 환경에서 자체적으로 인코딩 디코딩 기능을 갖추고 있어서 안깨지는거 처럼 보임ㅇㅇ
		
		// 근데 웹단 들어가면 우리는 보여지는 화면이 이클립스가 아니라 브라우저(웹)이다. 그런경우는 깨져보일것
		// 그래서 여러분들 웹단들어가면 선생님들이 문자셋 환경 다 UTF-8로 바꾸는 작업할꺼다 그니깐 지금 당장의 깨짐 안깨짐 생각하지 말라
		
		

	}
	
	//불러와보자!!!
	public void readData() {
		try(DataInputStream din = new DataInputStream(new FileInputStream(fileName))){
			//불러오려면
			//홍길동 22 M 180.5
			//data 입출력에서는 pipe 구조.. 먼저들어간게 먼저 나온다
			//얘 얘 얘 얘 순서대로 넣었으니 얘얘얘얘 순서대로 불러오면된다.
			//
			String name = din.readUTF();
			int age = din.readInt();
			char gender = din.readChar();
			double height = din.readDouble();
			
			System.out.println("name: "+name);
			System.out.println("age: "+age);
			System.out.println("gender: "+gender);
			System.out.println("height: "+height);
			
			
		/*	
			System.out.println(din.readInt());
			System.out.println(din.readInt());
			System.out.println(din.readChar());
			System.out.println(din.readDouble());
			*/
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
//	fileName = member.txt
// Scanner를 통해 키보드로 값을 입력 받고 저장
	public void addData2() {
		Scanner sc = new Scanner(System.in);
		
		try(DataOutputStream dout = new DataOutputStream(new FileOutputStream(fileName))){
			
			while(true) {
				System.out.print("이름을 입력하시오 : ");
				String name = sc.next();
				System.out.print("나이를 입력하시오 : ");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.print("성별을 입력하시오 : ");
				char gender = sc.nextLine().charAt(0);
				System.out.print("키를 입력하시오 : ");
				double height = sc.nextDouble();
				
				dout.writeUTF(name);
				dout.writeInt(age);
				dout.writeChar(gender);
				dout.writeDouble(height);
				
				System.out.print("입력을 끝내시겠습니까?? (y/n) :  ");
				char ch = sc.next().toUpperCase().charAt(0);
				
				if(ch == 'Y') {
					readData2();
					break;
				}
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//저장된 데이터를 모두 불러와보자!
	public void readData2() {
		//이름 나이 성별 키 이름 나이 성별 키 ... 이런순서대로 출력했다.
		try(DataInputStream din = new DataInputStream(new FileInputStream(fileName))){
			
			while(true) {
				System.out.println(din.readUTF());
				System.out.println(din.readInt());
				System.out.println(din.readChar());
				System.out.println(din.readDouble());
			}
			//이전에 가져올 데이터 없으면 -1 출력되는거 봤었쬬??
			//FileInputStream에서는 -1, BufferedReader에서는 null;
			//지금 DataInputStream에서는 -1이 나오는게 아니라 예외가 발생한다!! EOF익셉션!!!
			
			// 다음과 같이 실제 프로그램에서는 몇명의 정보가 들어있는지는 개발자는 모른다.
			// 그래서 무한루프로 출력하고 파일의 끝을 만나면 EOFException이 발생
			//->입력 스트림이 전 바이트를 읽어 들이기 전에 마지막에 이르렀을 경우
			//api가서 read~ 확인해보면 Throws에 EOF가있는걸 확인할수있따.
		
			// try catch를 이용하여 잡아준다. 
		}catch(EOFException e) {
			// 파일에 더이상 읽을 내용이 없을 경우 발생하는 exception
			// 발생할 수 밖에 없기 때문에 발생 했을 경우의 로직을 작성
			System.out.println("파일을 다 읽어왔습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}