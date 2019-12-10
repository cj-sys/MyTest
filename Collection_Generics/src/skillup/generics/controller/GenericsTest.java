package skillup.generics.controller;

import java.util.ArrayList;
import java.util.List;

import skillup.generics.model.Child;
import skillup.generics.model.GrandChild;
import skillup.generics.model.GrandParent;
import skillup.generics.model.Parent;

public class GenericsTest {
	public void genericsTest() {
		//List list = new ArrayList();
		// 이전에는 이런 방법으로 만들었었죠...
		
		//스트링만 받고 싶다!! 할때.. 어떻게 할까요....
		List<String> list = new ArrayList<String>();
		//List<String> list = new ArrayList<>();
		//뒤에 있는 ㅡ트링 없어도되? 된다... 뒤에 있는 애가 앞에 있는거 그대로 따라 가기 때문이다.
		//내가 들어갈 방의 형태를 보니 스트링이네? 그럼 나도 스트링! 이라고 생각
		
		List<GrandParent> list1 = new ArrayList<GrandParent>();
		list1.add(new GrandParent());
		list1.add(new Parent());
		list1.add(new Child());
		list1.add(new GrandChild());
		//==============와일드카드
		//list1 = new ArrayList<Parent>();
		//에러가 뜬다..... 타입이 맞지 않다고 뜨는데..
		//제네릭 안에서는 다형성이 적용이 안되는게 확인 된다.
		
		//다형성을 배운 이유가 한 변수에 여러 타입을 넣으려는건데
		//제네릭은 왜 안되게 해놨을가요
		
		//이렇게 일반적으론 다형성을 적용 못하지만...
		//다형성을 적용할수있게 해주는게 
		
		//WildCard 이다!!!
		//T extends 객체   -> 이렇게 사용하면 객체에 자손들을 와일드 카드가 사용할수 있고
		//T super 객체 -> 이렇게 사용하면 객체의 부모,조상들을 받을 수 있따.
		// 이렇게 와일드카드 사용하는 이유가.... 제네릭에서 다형성을적용학 ㅣ위해서 이다...
		
		List<? extends Parent> list2 = new ArrayList<>();
		//와일드카드는(물은표는) Parent의 자식들을 받을수 있다.
		
		list2 = new ArrayList<Child>();
		list2 = new ArrayList<GrandChild>();
		//list2 = new ArryaList<GrandParent>();
		//안ㄴ되죠?? 왜요?? 자식을 받겠다고 했는데 조상을 받으려고 하니 에러
		
		List<? super Child> list3 = new ArrayList<>();
		//Child의 조상을 받겠다!!!!!
		
		list3 = new ArrayList<Parent>();
		list3 = new ArrayList<GrandParent>();
//		list3 = new ArrayList<GrandChild>();
//		빨간줄 뜨죠? 차일드의 자식이니까 그렇겟죠?
		
		
		//이전에 했던 것들을 확인하고 노란줄을 한번 지워 봅시다....
		//ArrayListTest부터 궈궈
		//엔트리부분도 가능
		//Set<Map.Entry> entry ==> Set<Entry<String,Score>> entry
	
	
	}
}
