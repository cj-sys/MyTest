package io.object.model.vo;

//import java.io.Serializable;
//import 해서 impements Serializable 로 해도 된다.

public class Member implements java.io.Serializable {
	//imp해주면 클래스명에 노오랗게 표시가 된다 마우스 올려보면 시리얼버전을 해주라고 경고가 뜬다!!	

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	
	// serialversionUid 저장할때랑 불러올 때 다른 경우 오류 발생

	// 필드값으로 명시해 주지 않으면 jvm이 기본 값 지정
	// 클래스의 수정이 있을경우 jvm이 버전아이디를 다시 생성
	
	// 지금은 오류가 나지 않겠지만 우리는 나중에 유지보수나 버전같은것들을 업그레이드 할 것이다.
	// 이게 무슨 말이냐 Member 클래스를 수정하는 경우가 있을 것이다. --> 필드를 추가한다거나 삭제한다거나 등등...

	// 이럴 경우 필드로 버전아이디를 명시해 주지않으면
	// 클래스가 수정 될 때 jvm이 버전아이디를 바꿔버린다. --> 1버전으로 파일에 저장하고
	// --> 어떠한 유지보수 작업으로 객체클래스 Member 수정 (버전이 바뀜)
	// --> 파일에서 불러올 때 버전 아이디를 대조 할 때 달라서 오류 발생

	// 따라서 필드로 명시적으로 버전아이디를 표기 해주는게 좋다.
	// 그러면 내가 클래스를 수정할 때 마다 버전이 바뀌는게 아니라 내가 지정한 버전으로 그냥 계속 유지된다.

	private String name;
	private int age;
	private char gender;
	private double height;

//	private transient int aa;
	//직렬화 제외
	
	//시리얼버전아이디 할때 주석풀어보자
//	private double weight;

	public Member() {

	}

	public Member(String name, int age, char gender, double height) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", gender=" + gender 
				+ ", height=" + height /*+"weight="+weight*/+ "]";
	}

}