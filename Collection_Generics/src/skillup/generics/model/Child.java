package skillup.generics.model;

public class Child<T extends Number> extends Parent {
	//private int num;
	//int 라고 정하면 오로지 정수형만 받을수 있다.
	//그게 싫어서.... 다른것도 다 받아보고 싶어 할때.. 클래스 선언부를 Child<T>라고 해준다.
	
	//그리고 필드 선언시에 T로 선언
	private T num;
	//근데 여기서 생각 해 볼게 저렇게만 해 두면 스트링인지.. 다른 클래스들도 들어온다....
	//java.lang의 number에 들어가보자.. 넘버라는 클래스 안에 보면 숫자만 있는게 가능하다...
	//Child<T extends Number> 이렇게 하면된다... 이말이 넘버라는 클래스를 상속받는 클래스들만 들어올수 있따~~ ㅏㄹ는 뜻.
	
}
