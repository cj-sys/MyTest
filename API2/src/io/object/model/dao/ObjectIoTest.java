package io.object.model.dao;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import io.object.model.vo.Member;
/*
  Member 클래스 만들어 봅시다요!!!!
 */


public class ObjectIoTest {
//ObjectInpt/OutputStream
	//객체단위(자바) ---> 직렬화 --> 바이트단위(파일)
	//바이트단위(파일) --> 역직렬화 --> 객체단위(자바)
	
	public ObjectIoTest() {	}
	
	//이제 오브젝트 단위로 데이터를 저장하고 불러올거다!
	
	public void fileSave() {
		Member mem1 = new Member("제임스", 20, 'M', 160.2);
		Member mem2 = new Member("엘리스", 10, 'F', 140.5);
		
		//지금하려는게.. 
		//writeInt, WriteUTF ,writeDouble 일일이 하기 귀찮다!! 한번에 넣겠다!! 라는 거죠
		
		
		try(ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("memberobject.txt"))){
			
			objout.writeObject(mem1);
			objout.writeObject(mem2); 
			// 직렬화 안되었다는 예외 발생 NotSerializable~ 
			// 쉽게 생각해서 이~~ 만한 객체단위가 쩌만한 바이트단위로 들어가려니까 에러 날수 밖에 없겟죠 
			//멤버클래스에 imp 해줘야 한다!! 궈궈
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//잘 생길거다!! 그치만 우리가 알수 없는 생김새로들어가있다!!!!!!
		//우리 눈으로는 확인이 안되니 자바코드로 불러와서 함 봐보자!!!
		
	}
	
	public void fileRead() {
		try(ObjectInputStream objin = new ObjectInputStream(new FileInputStream("memberobject.txt"))){
//			 ObjectInputStream ois =  new ObjectInputStream(new BufferedInputStream (new FileInputStream("memberobject.txt")));
			
			Member m1 = (Member)objin.readObject();
			Member m2 = (Member)objin.readObject();
//			Member m3 = (Member)ois.readObject();

			System.out.println(m1);
			System.out.println(m2);
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		/*** 
		//시리얼 ID 시작해보자!!!! 
		Member클래스로 가서 노란줄 확인! 
		ㅑID를 통해 비교해보고 같은 놈인지를 확인해본다.
		안하면 JVM이 자동으로 설정해준다.
		Member클래스를 변경 후에 불러오기를 해보자!
		안된다! jvm이 다른 id를 부여한다.
		***/
		// 보조 하나 더 단다--> 속도향상을 위해 Buffered관련 보조스트림을 더 달경우
		// BufferedInputStream bis = new BufferedInputStream(new ObjectInputStream)이 맞냐
		// ObjectInputStream ois =  new ObjectInputStream(new BufferedInputStream)이 맞냐
		
		// 하나만 생각 해보면 쉽다. 우리는 결국 object를 출력하기 위해 readObject()메소드를 사용해야되는데
		// bis레퍼런스가 readObject()메소드를 제공하냐? 아니다. ois가 제공한다....
		
		
		// 따라서 보조를 여러개 달고 싶을때 
		// Data~,Object~  ( Buffered~ ( InputStreamReader,OutputStreamWriter (기반))))
		// 이 순서로 외워라
		
		
		
		
	}
	
	
	////////////////////////
	//한번 해보소////////////////
	/////////////////////////
	
	//여러개의 객체를 ArrayList에 담아서 입출력 해보바
	public void fileSaveList() {
		ArrayList<Member> list = new ArrayList<Member>();
		
		list.add(new Member("제이스", 20, 'M', 161.2));
		list.add(new Member("엘리스", 31, 'F', 182.8));
		list.add(new Member("마이크", 42, 'M', 173.0));
		list.add(new Member("나타샤", 53, 'F', 155.3));
		list.add(new Member("이창진", 33, 'M', 177.4));
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("memberList.txt"))){
			
			// 1. 인덱스를 통해 한 Member객체씩 넣는 경우 for문 이용
			for(int i=0; i<list.size(); i++) {
				oos.writeObject(list.get(i));
			}
			
			//2. ArrayList 리스트 통으로 한번에 넣는 경우
//			oos.writeObject(list);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void fileReadList() {
		ArrayList<Member> list = new ArrayList<Member>();
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("memberList.txt"))){
			
			// 1. 한 Member 객체씩 불러올 때 while 무한 루프 돌리고 EOFException 발생할 때 처리해줌
			while(true) {
				list.add((Member)ois.readObject());
			}
			
			// 2. 리스트를 통으로 넣은 경우 불러올때도 통으로 리스트를 불러와야됨 .. 반복문 통해 한 객체씩 불러오면 오류..
//			list.addAll((ArrayList<Member>)ois.readObject());
			
		}catch(EOFException e) {
			System.out.println("파일을 다 읽었습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<list.size(); i++ ) {
			System.out.println(list.get(i));
		}
		
	}
	
}