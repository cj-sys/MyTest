package skillup.collection.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import skillup.collection.set.model.Score;

public class HashSetTest {
	public void TestSet() {
		// API 보면서.... 초기용량, load Factor란 16에 75만큼 차면 2배가 늘어난다....
		// arraylist는 꽉차면 늘어나지만 얘는 좀 다르다
		
		Set hs = new HashSet();
		hs.add("abc");
		hs.add("bcd");
		hs.add("cde");
		hs.add("abc");
		
		System.out.println(hs);
//		중복없이 들어간다.
		
		Set set = new HashSet(); // 다형성
		//객체를 add해보자.
		set.add(new Score("조보아", 99));
		set.add(new Score("정유미", 86));
		set.add(new Score("이민정", 77));
		set.add(new Score("조보아", 99));

		System.out.println(set);
		// 순서가 없다는것 확인
		// 중복값 없다고 했는데?? 조보아 2번 들어가는거 확인!!
		// 왜냐!! new로 객체 생성해서 넣었기 때문에!!
		// 여기서도 hashcode랑 equals를 오버랑딩 해야 한다!!
		
		//해쉬코드 비교하고
		// Score궈궈
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);
		
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
		System.out.println(i1.equals(i2));
		
		String str1 = new String("이창진");
		String str2 = new String("이창진");
		
		System.out.println(str1.equals(str2));
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		//해쉬코드도 같은걸 확인 
		//왜? String에서 오버라이딩 되어 있기 때문이다!
		
		
		Score s1 = new Score("이창진",99);
		Score s2 = new Score("이창진",99);
		
		//이퀄스만 오버라이딩 한다면 다른 해쉬코드
		System.out.println(s1.hashCode() == s2.hashCode());
		System.out.println(s1.equals(s2));
		//hashcode는 false, equals는 트루
		
		
		
		
		
		//해쉬코드 return을 123456으로 바꾼후에 확인
		Score s3 = new Score("이창진",88);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s1.hashCode() == s3.hashCode());
		System.out.println(s1.equals(s3));
		
		
		////////////////////////////////
		// 오버라이딩하고 다시 실행해 보면.. 중복 안되는게 확인 가능하다!!
		// 두개를 오버라이딩 하기 전에는 new로 객체를 새로 생성했기때문에~ 다른 객체로 인식하고 중복으로 들어간것처럼 보이는거다

		//둘중 하나만 오버로딩 하게 된다면 중복 제거가 안됨
		//hashcode() => 같은 객체 인지 비교
		//equals() => 같은 내용인지 비교 
		// 같은 놈인데 내용이 다르다~ 라고 해서 다르구나~
		// 내용은 같은데 다른다~ 라고 해서 다르구나~
		
		// hashCode는 해시테이블ㄹ이라는게 있는데 그걸 쓰기 위해 생성된 키라고 볼수 있다.
		// Integer나 String 클래스는 자동으로 어버라이딩 되어있다
		// 사용자 정의 클래스에서는 객체생성해서 해시코드 찍어보면
		// 객체안의 내용이 같다고 해도 해시코드가 다르다~~ 주소값이 다르기 때문
		// 객체 인식용 정수 ~

		/*
		 * (Set관점) 들어온 자료는 해시테이블의 키로 들어간다. 
		 * 키 값으로 들어간 자료는 해싱함수를 거치고 비교한다. 
		 * 해시코드값이 true,
		 * 이퀄스값도 true ==> 중복값이라고 생각하고 set안에 들어가지 않는다... 이퀄즈만 재정의 한다면... 내용은 같은데 해시코드값이
		 * 다르므로 다른애로 인식해서 Set에 들어가게된다.
		 */

		
		
		
		
		
		
		// list는 인덱스가 존재... 인덱스로 접근해서 get을 통해 데이터를 가져 왔었다
		// set은 순서가 없으므로 list와 다르게 index로 접근 불가능, get()메소드도 없다.

		// ==>[1] addAll() : addAll()를 사용하여 List에 넣고 접근한다.
		List list = new ArrayList();
		list.addAll(set); // set에 있는 것을 list에 다 저장하는 것
		for (Object o : list) {
			System.out.println(o);
		}

		// listAll은 잘 안쓴다..

		// ==>[2] Iterator
		// 컬렉션에 저장된 요소에 접근하는데 사용되는 인터페이스
		// 컬렉션 클래스에서 iterator()호출
		// 컬렉션에 저장된 요소들을 읽어오는ㄴ 방법 표준화 한것
		// 컬렉션에 저장된요소에 접근하는 방법을 Iterator인터페이스를 정의하고
		// collection인터페이스에서는 Iterator를 구현한 클래스의 인터페이스를 반환하는 iterator메소드를 정의
		// iterator는 Collection인터페이스에 정의된 것으로 이를 구현한 list, set도 포함된다.
		//  
		// ->list,set을 구현한 클래스는 각 컬렉션 특징에 알맞게 iterator를 작성함
		// 컬렉션 클래스에 iterator()   내용을 다 얻어 왔을경우 다시 받아서 얻어와야한다
		
		// ListIterator 같은 경우 양방향으로 이동하지만 Iterator는 단방향
		//Enumeration 인터페이스
		
		System.out.println("Iterator");
		// 컬렉션에 저장된 요소에 접근하는 Iterator생성
		Iterator it = set.iterator(); // Iterator() => Collection 인터페이스에 정의된 것이기에 Set, List 다 포함되어 있다.
		while (it.hasNext()) { // 다음에 요소가 있냐고 물어보고 있다믄 true
			System.out.println(it.next()); // 다음요소를 가지고 와서 출력
		}
		// 한번만 사용 가능... 가르키는 부분이 끝에 도달햇기에 재사용이 안됨.. 단방향
		// ListIterator라는 양방향이지만... 이터레이터만 잘 사용하면 된다.
		
		//c추가 -> "정유미"가 있다면 100으로 점수 변경
		transElem(set, "정유미", 100);

		/*
		 * 1. A.containsAll(b) : b가 a에 속해있는지... b의 값들이 다 a에 들어있는지... 수학에서 부분집합
		 * 2. A.addAll(b) : 두 set을 합친다. 합집합
		 * 3. A.retainAll(b) : 공통된 부분... 교집합
		 * 4. A.removeAll(b) : A에서 b를 뺀다.. 차집합
		 */
		
	}

	public void transElem(Set hs, String name, int score) {

		for (Object s : hs) {
			if (((Score)s).getName().equals(name)) {
				((Score)s).setScore(score);
			}
		}

		Iterator it = hs.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
	}

}
