package skillup.collection.list.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import skillup.collection.list.model.Score;

public class ArrayListTest {
	public void testList() {
		/*
		 * int[] arr = new int[3];
		 *  arr[0]=1;
		 *  arr[1]=2;
		 *  arr[2]=3;
		 *  arr[3]=4;
		 */

		
		//score를 만들고 진행
		
//		List list = new List();
		//안된다 왜??? 인터페이스나 추상클래스 배우셧죠?
		// 인터페이스와 추상클래스 new를 통해서 객체 생성이 된다 햇나 안된다고 햇나
		
		List list = new ArrayList(3);
		
		//1.list에 데이터 추가 add(E e);
//		list.add(14);
//		list.add("ABC");
//		list.add(new Score("이창진",99));
		
//		System.out.println(list);
		
		//크기가 3인 ArrayList생성
		//list에 여러가지를 담을수 있게 하기 위해서 타입을 List로 정한거다(다형성)
		
		list.add(new Score("이창진",99));
		list.add(new Score("홍길동",75));
		list.add(new Score("이순진",88));
		//우선 3개만 입력해서 출력해보자...
		
		//더 추가를 해보자
		list.add(new Score("김준현", 72));
		list.add(new Score("유리나",62));
		list.add(new Score("강철수", 32));
		//3개더 추가하고 출력
		
		//이것도 되나 확인해보자~
//		list.add("끄으읕");
		System.out.println("list: " + list);
		
		//지정한 크기보다 많이 넣어도 오류가 나지 않는다. 장점:크기의 제한이 없다 
		//다른 타입이 들어가도 상관 없다 	장점:여러 타입을 받을 수 있다.
		
		//====================================================
		//2. add(index, e)
		//원하는 위치에 데이터 추가
		list.add(3, new Score("추가연",84)); //3번째 인덱스에 데이터를 추가!!
		System.out.println("list: " + list);
		
		
		//3. set(index, e) 수정.. 원하는 위치의 데이터를 수정해보자~
		list.set(3, new Score("이수정", 77));
		System.out.println("list: " + list);
		
		
		//4. size()
		System.out.println("size: "+ list.size());
		//확인하고 싶은 메서드나 클래스 등에 커서 옮기고쉬프트+f2 api를 이클립스에서 확인 가능하다.
		
		//5. remove(index) 해당 인덱스의 인스턴스를 제거
		//우선 이렇게 한번 해보자~~~
		list.remove(3);
		System.out.println("list: " + list);
		
		//6. get  해당 인덱스의 인스턴스를 조회
		Score s = (Score)list.get(0);
		System.out.println(s);		
		
		//7. contains(object o)  => 리스트에  o가 있다면 true, 아니면 false 리턴
		System.out.println("7777");
		System.out.println(list.contains(new Score("김준현",72)));
		
		
		
		
		
		//실행~
		//false가 나오는 이유?? 같은 내용일지라도 new로 인해 새로운 객체가 생성 되었다. 주소가 다르겟죠?? 그래서 안된다.
		
		
		//contains()=> indexof() => equals()
		//equals() -> 최상위클래스인 Object 클래스의 equals()를 사용하여 주소값을 비교 하는것
		//이를 오버라이딩 해서 실제 데이터를 비교 ->ex) String클래스의 equals()
		
		//contains라는 것은 내부에서 indexof()라는 메서드를 사용하는데.. indexof()메서드에서 equals라는 메서드를 사용한다...
		//object클래스의 이퀄스롭 비교를 하는데  주소값을 비교 한다.
		//그래서 여러분들은 주소값을 비교 하는게 아니라~~ 실제 들어있는 필드값들을 비교.. 즉 데이터를 비교해서 같은지 확인해야 합니다. 
		//필드값들을 비교하기위해서 Score에 이퀄스를 오버라이딩!! 해줘야 한다.
		//indexof()에서 사용되는 equals는 object의 이퀄스를 사용하는거다~ 
		
		//Score로 가서 이퀄스 오버라이딩 해주자
		
		//오버라이딩 후 다시 한번 실행 해 보면 contains가 true를 리턴하는걸 확인할수 잇따.
		
		System.out.println("hashcode");
		System.out.println(list.get(0).hashCode());
		System.out.println(new Score("이창진",99).hashCode());
		System.out.println(list.get(0).equals(new Score("이창진",99)));
		
		
		//8. sublist(fromIndex, toIndex)
		List sub = list.subList(0, 2);
		System.out.println(sub);
		
		//9.addAll()
		list.addAll(sub);
		System.out.println(list);
		
		//10. isEmpty()
		System.out.println(list.isEmpty());
		
		//9. retainAll(collection c) : c와 겹치는 부분만 남기고 모두 삭제~
		List list2 = new ArrayList(list.subList(2, 5));
		list.retainAll(list2);
		System.out.println("리스트" +list);
		
		//9. clear
		System.out.println("9999");
		list2.clear();
		System.out.println(list2);
		System.out.println(list2.isEmpty());
		

		//정렬
		//Comparable과 Comparator
		//오름차순~ 내림차순~ 이런게 잇죠? 정렬?
		
		//이런것들을 제공하는게 인터페이스 Comparable과 Comparator이다.... 인터페이스라고 했죠?
		//그렇다는건 두가지를 imp하면 무조건 구현 해야 하는 메서드가 있다는 거겟죠? 
		
		//내가 새롭게 정렬 순서를 정의하고 싶거나 정렬에 사용될 값을 지정할때 사용하는 것이 Comparable과 Comparator이다.
		
		
		//1.Comparable -  기본 정렬 기준을 구현, 기본적으로 적용되는 정렬기준
		// 이 인터페이스를 구현한 객체 스스로에게 부여하는 한가지 기본정렬규칙을 설정하는 목적으로 사용
		//자바에서 제공되는 정렬이 가능한 클래스들은 모두 Comparable 인터페이스를 구현하고 있다. 
		//Score라는 객체는 정렬!! 이라고 한다면 
		//이거는 예를 들어 Score를 점수순으로 정렬하고 싶다 할때 Student안에 Comparable을 사용하여 기본정렬! 기준을 구현한거
		
		//2.Comparator - 기본 정렬 기준 외에 다른 기준으로 정렬
		//이 인터페이스를 구현한 클래스는 정렬 규칙 그 자체를 의미, 기본정렬 규칙과 다르게 원하는대로 지정할때 사용
		//점수외에 다르게 또 정렬하는걸 만들고 싶을때에는 Comparator를 사용한다.
		//이름같은걸로 말이져, 즉 기본정렬 기준 외에 다른 기준으로 정렬하고자 할때 사용한다. 얘는 다른 클래스에서 구현한 뒤에 가져와서 사용해야 한다.
		
/*		
		compareTo() 메서드 작성법
		오름차순
		현재 객체 < 파라미터로 넘어온 객체: 음수 리턴
		현재 객체 == 파라미터로 넘어온 객체: 0 리턴
		현재 객체 > 파라미터로 넘어온 객체: 양수 리턴
		음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.
*/		
		
		
		// Score에 imple Comparable을 한다~~~
		System.out.println("[[Comparable]]");
		Collections.sort(list);
		System.out.println("list: " + list);
		
		//클래스 하나 만들고 imple comparator 한다.
		//실햏ㅇ해보자
		System.out.println("[[Comparator]]");
		Collections.sort(list, new ScoreSorting());
		System.out.println(list);
		
		
		//또다른 하나... 컬렉션이 제공하는게 아니라 리스트 자체에서 제공하는게 있습니다.
		list.sort(new ScoreSorting()); // 컴퍼레이터를 임플리먼츠한 스코어솔팅을 넣는게 보이죠?
		System.out.println(list);
		
		
		
		//제네릭 간단하게
		List<Score> ll = new ArrayList<Score>();
//		ll.add(14);
//		ll.add("abc");
		//정수, 문자열 add 불가
		ll.add(new Score("abc",99));
		//제네릭 간단하게

		//메서드 만들러 고고 generic
		
		Score ss = generic().get(0);
		Score ss2 = generic().get(1);
		//인덱스 1인 곳에는 정수가 들어 잇지만 메서드의
		//반환형이 List<Score> 이기에 
		//아~ 스코어 구나~ 라고 생각하고 컴파일 에러가 발생지 않는다.
		//그렇지만 실행 해 보면 런타임 에러가 발생
		System.out.println(ss);
		System.out.println(ss2);
		
/*		
		//Vector~~~~~~~~
		//Vector(),    Vector(iCa),    Vector(iCa,capaInc)
				//			iCa만큼 용량을 만든다  / iCa를 넘기면 capaInc만큼 용량(capacity)이 증가한다.
				Vector<Integer> v = new Vector<Integer>(10,5);
				System.out.println(v.size() + " : " + v.capacity());
				
				//Vector v1 = new Vector(); //타입을 정하지않고 객체를 생성하면
											//add()시에 넣는 어떠한타입의 데이터라도 대입이 가능하다.
				
				 다양한 선언 방법들이 있다.
				 Vector tmp = new Vector();

				Vector<> members = new Vector<>();	

				Vector<Member>  members = new Vector<Member>();

				Vector<Integer> num     = new Vector<>();	

		 		Vector<Integer> num2    = new Vector<Integer>();

		 		Vector<String>  str     = new Vector<String>();

		 		Vector<String>  str2    = new Vector<String>(10);
				
				
				
				//size()는 벡터 크기를 불러오는 함수
				//capacity()는 벡터의 용량을 불러오는 함수
				for(int i = 0 ; i < 10 ; i++) {
					v.add(i);
				}
				System.out.println(v);
				System.out.println(v.size() + " : " + v.capacity());
				System.out.println(v.get(0);//get(index) 을 통해 index 위치의 데이터를 가져 올수 있다.
				
				v.add(10);
				System.out.println(v);
				System.out.println(v.size() + " : " + v.capacity());
*/
			
		
	}


	//1. 우선 제네릭 없이 반환형 List로 선언
	//2. 반환형 제네릭선언 List<Score>
	public List<Score> generic(){
		List list = new ArrayList();
		//우선 list 제네릭 선언 하지 말고
		list.add(new Score("홍길동",90));
		list.add(123);
		return list;
		//list 선언시 generic 선언 하지 않아도 리턴이 된다.
	}
}
