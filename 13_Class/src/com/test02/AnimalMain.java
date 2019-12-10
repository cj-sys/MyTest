package com.test02;

public class AnimalMain {

	public static void main(String[] args) {
/*		Cat cat = new Cat();
		Dog dog = new Dog();
		
		cat.Bark();
		dog.Bark();
		*/
		Animal some = new Dog();
		some.Bark();
		
		some = new Cat();
		some.Bark();
		
		/*
		 * 다형성
		 * 1. 부모(선조)의 타입으로 자식(후손) 생성
		 * Parent p = new Child();
		 * 2. 부모의 이름으로 자식 대입
		 * Child c = new Child();
		 * Parent p = c;
		 * 3. 부모의 메서드를 자식의 메서드로 호출
		 * 
		 * 같은 부모를 갖고 있는 자식 클래스는 컴파일에서는 형태변환이 발생하지만 
		 * 실행시(runtime)에 ClassCastException을 발생 시킨다
		 */
	}
}


