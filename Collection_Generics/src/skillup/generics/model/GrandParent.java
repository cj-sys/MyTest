package skillup.generics.model;

//여기에 제네릭을 적용해 보자
public class GrandParent<T> {
	private T value;
	//그랜드패런트를 만들때 제네릭으로 스트링을 넣는다고 하면... 여기서도 스트링으로 value가 적용된다.
	//GrandParent를 인스턴스화 시킬때 제네릭에 값을 넣으면 같은 값이 T에 들어간다.
	//GrandParent<String> gp = new GrandParent<String>();
	
	public GrandParent() {}
	public GrandParent(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "GrandParent [value=" + value + "]";
	}
	
	
}
