package skillup.collection.map.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import skillup.collection.map.model.Cafe;

/*
	Properties
	맵은 기본적으로 제네릭을 설정해 주지 않으면 Object 형식으로 저장이 된다.
	
	Map에 담을 수 있는 키와 같은 어느 값이든 가능한 Object 타입으로 받을 수 있는데
	키와 값 모두 String으로만 제한 되어 받을 수 있는 클래스가 있는데...
	바로 Properties.
	원래 properties는 Hashtable을 상속받아서 구현 한 것
	
	주로 프로퍼티 파일을 읽을 때 사용..
	api 보여주면서 해시테이블 아래에 있는걸 볼 수 있다.
 */

public class PropertiesTest {
	public void propertiesTest() {
		Properties prop = new Properties();

		prop.put(1, 4);
		// hashtable의 메소드, 따라서 들어가는 인자가 Object
		// hashtable에 있는 put을 상ㅇ한거다.. 마우스를 올려보면 확인 가능하다.. 확인해보자...
		System.out.println(prop);

		prop.setProperty("1", "4");
		// properties에 있는 메소드.... 그러므로 들어가는 인자가 String
		System.out.println(prop);
		// 만일 둘이 같다면 {1=4} 하나만 나오는 결과 값을 얻을수 있었을 텐데..
		// 둘의 타입이 다르기 때문에 각자 따로 인식해서 다르게 들어간다... Object,
		// 따라서 제대로 된 값을 넣기 위해서 properties를 쓸땐 setProperties를 쓰자

		prop.setProperty("1", "3");
		// 키는 같죠??? 데이터가 덮어 써 진다.
		System.out.println(prop);

		prop.setProperty("2", "2");
		prop.setProperty("3", "1");
		prop.setProperty("4", "0");
		System.out.println(prop); // 순서유지X, 키값중복X

		// 벨류 가져오기
		System.out.println();
		System.out.println(prop.get(1)); // hashtable
		System.out.println(prop.getProperty("1")); // properties

		prop.remove(1); // hashtable의 remove()
		System.out.println(prop);

		System.out.println();

		// ==> 전체 출력 1
		Set keySet = prop.keySet();
		Iterator itKey = keySet.iterator();
		while (itKey.hasNext()) {
			String key = (String) itKey.next();
			System.out.println("key: " + key + ", value: " + prop.getProperty(key));
		}

		/*
		 * 전체 출력 제니릭을 설정안해줘도 된다.....스트링으로만 하면. 오류가 발생.. 왜?? 해시테이블을 상속 받는건데... 잘 보면 오브젝트,
		 * 오브젝트라고 제네릭이 명시 되어있죠?? 아무리 스트링이 들어있어도 애초에 오브젝트로 명시를 해둿으니 안될수밖에없습니다~
		 * Set<Object> keySet = prop.keySet(); 
		 * Iterator<Object> itKey = keySet.iterator(); 
		 * while(itKey.hasNext()) { 
		 * String key = (String)itKey.next(); 
		 * //오브젝트로 제네릭햇으니.. 제네릭 안해줫어도 String으로 형변환해야함
		 * System.out.println("key : " + key + ", value : " + prop.getProperty(key)); }
		 * 
		 */

		// ==> 전체 출력 2
		/*
		 * Properties의 저장된 요소에 하나씩 접근하기 위해서는 Enumeration을 사용해야 한다. Enumeration :
		 * Iterator의 이전버전 Vector, HashTable등 컬렉션 이전에 사용되던 클래스들의 요소에 접근할 때 사용 사용 방법은
		 * 이터레이터와 거의 같다.
		 */

		// 키값만 출력 - 이너머레이션 키값
		Enumeration en = prop.keys();
		while (en.hasMoreElements()) { // == Iterator의 hasNext()
			System.out.println(en.nextElement());
		}

		// 벨류값만 출력 - 이너머레이션 벨류값
		Enumeration en2 = prop.elements();
		while (en2.hasMoreElements()) {
			System.out.println(en2.nextElement());
		}
		// 두개 다 하고~~ 제네릭.... 오브젝트로 붙여주면 노란색이 사라진다는거 보여주자....

		/*
		 * Enumeration<Object> en = prop.keys(); while(en.hasMoreElements()) {
		 * System.out.println(en.nextElement()); }
		 * 
		 * //벨류값만 출력 - 이너머레이션 벨류값 Enumeration<Object> en2 = prop.elements();
		 * while(en2.hasMoreElements()) { System.out.println(en2.nextElement()); }
		 */

		Enumeration em = prop.propertyNames(); // Enumeration 불러오기
		while (em.hasMoreElements()) {
			String key = (String) em.nextElement();
			System.out.println(key + " / " + prop.getProperty(key));
		}
		// 어디서 많이 봣죠?? 위에서 keySet + Iterator 와 거의 흡사 합니다.

	}

	// store(OutputStream os, String comments);
	public void filseSave() {
		/*
		 * 우선 이 코드를 사용해서 스트링이 아닌것은 사용이 안된다는걸 보여주자!!! 
		 * Properties prop = new Properties();
		 * prop.put("아메리카노", new Cafe("커피",2800)); 
		 * // System.out.println(prop);
		 * System.out.println(prop.get("아메리카노")); //프린트는 된다...... 
		 * try{ 
		 * 	prop.store(new FileOutputStream("test1.properties"),"test~ file"); 
		 * } catch (IOException e) {
		 * e.printStackTrace(); 
		 * } ===>요렇게만 하면 예외가 발생한다........ 왜냐.... snack이란타입을
		 * String으로 형변환이 안되서 에러가 난다... 즉 무조건 스트링만을 써라!!!!
		 */

		Properties prop = new Properties();

		// 지정된 K, V를 K=V 형태로 저장
		prop.setProperty("title", "Properties 연습");
		prop.setProperty("witdh", "1920");
		prop.setProperty("height", "1080");
		prop.setProperty("language", "kor");

		try {
			prop.store(new FileOutputStream("test.properties"), "test__file");
			//store(아웃풋스트림,코멘트) 코멘트 : 파일 상단에 넣을 코멘트 작성
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 성공!!! 프로젝트 안에 프로퍼티 파일이 생긴걸 확인 가능하다.
	}

	// xml 파일로 저장하는 기능도 제공한다.
	public void fileSave2() {
		Properties prop = new Properties();

		// 지정된 K, V를 K=V 형태로 저장
		prop.setProperty("id", "abcd1234");
		prop.setProperty("password", "1q2w3e4r");
		prop.setProperty("ip", "192.168.0.1");
		prop.setProperty("version", "1.0.2.2");

		try {
			prop.storeToXML(new FileOutputStream("testXML.xml"), "This is XML test file");
			System.out.println("XML 파일 생성");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * XML 파일은 스프링 들어가면 수도 없이 보는 파일이다. 왜냐! 호환성이 기가막히다. 자바, c 등등 여러곳에서 호환이 된다. 그래서
		 * 프로퍼티스의 장점중 하나 XML로 저장이 가능하다...
		 */

	}

	/*
	 * 장점 1. -드라이버 설정할때.. id라던지, pw,ip 등을 이렇게 저장해 두고 파일로 제공 
	 * 실제 개발자가 프로그램 다 짜고 기본정보를 ㅜ이렇게 프로퍼티스 파일등으로 제공한다. 
	 * 만약에 ip 주소가 바꼇다!! 하면 이 파일으 열어서 주소만 변경하면 되겠쪄?? 
	 * 코딩을 모르는 사람도 그정도는 가능 하겟죠???
	 * 
	 * sql 구문을 이렇게 프로퍼티스로 저장해서 사용을 많이 한다. -프로그램이 변경되어서 쿼리문을 변경해야 할때.... 일일이 코드 열어서
	 * 수정하는게 아니라 프로퍼티스만 열어서 수정하면 된다.
	 * 
	 * 장점 2. xml 저장이 가능하다~ 스프링 들어가시면 많이 보는데 설정파일을 xml로 많이 저장한다.
	 */

	public void fileOpen() {
		
		// try-with-resource문
		try (FileInputStream fis1 = new FileInputStream("test.properties");	FileInputStream fis2 = new FileInputStream("testXML.xml")) {

			Properties prop = new Properties();

			System.out.println("\n*** test.properties 파일 열기 ***");
			prop.load(fis1);
			System.out.println(prop);

			System.out.println("\n*** testXML.xml 파일 열기 ***");
			// prop.clear(); //이어 붙어서 나오는 것을 방지
			prop.loadFromXML(fis2);
			System.out.println(prop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
