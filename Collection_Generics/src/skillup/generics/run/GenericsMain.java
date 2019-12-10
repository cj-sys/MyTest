package skillup.generics.run;
/*
List
Set
Map 
선언할때.. 객체 생성할때... 노란색줄.. 기억나져? 왜그러냐 하면 ...
제네릭을 선언안해줘서 그런거다...

컬렉션 프레임워크 에서 위에 저 것 세가지는 인티저든 클래스든 뭐든지 들어갈수있따..
왜냐!!! 오브젝트 타입으로 들어가기 때문이다...
여기서! 문제가 생긴다.
리스트 솔팅 할때 컴퍼러블 컴퍼래이터 임플을 했엇져? 
스튜던트 라는걸 넣었었는데.... 스투던트 말고 끝에 아무거나 넣더라도 들어가져??? 
근데 정렬을 할때는 아무렇게나 들어간건 없애고 했었는데...
객체들과 스트링의 정렬기준이 다르기에 주석처리했었다.

여기서 보듯이 아무거나 넣을수 있게 해놨더니 진짜 아무렇게나 막 집어 넣어서 오류가 너무 생기더라~~
그래서 여기에는 인티저만.. 여기에는 스트링만.... 넣게 정하는게 제네릭스 이다.
 */


/*
 * 1.메인 만들고 컨트롤러 만들고 model 만들러 가자
 * 
 */


import skillup.generics.controller.GenericsTest;

public class GenericsMain {

	public static void main(String[] args) {
		GenericsTest gt = new GenericsTest();
		
		gt.genericsTest();
	}

}
