package skillup.collection.set.model;

public class Score {
	
	private int score;
	private String name;
	public Score() {
	}

	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// 여기까지 하고 컨트롤러로 가서 객체 생성해서 해보자...
	@Override
	public String toString() {
		return "[name=" + name + ", score=" + score + "]";
	}
	
	
	
	

	// 밑에 둘은 자동완성을 할수있다.. 그만큼 자주 사용된다는 말이겟죠?

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
//		return result;

				return 123456;
		// 이렇게 바꿔보고 s3 만든후에 확인해보자
	}
//	equals 메소드를 오버라이드 하는 모든 클래스에서는 반드시 hashcode 메소드도 오버라이드 해야 한다. 그렇지 않으면 Obejct.hashcode 메소드의 보편적 계약을 위반
// 지금 당장은 해코드가 필요는 없지만 나중에 hashmap, hashset을 할때 필요 하다~

	@Override
	public boolean equals(Object obj) {
		if (this == obj)// 만약에 지금 이 객체랑 들어온 obj랑 같다면?? 당연히 true
			return true;
		if (obj == null)// 들어온게 널이면?? 당연히 false
			return false;
		if (!(obj instanceof Score)) // obj, 즉 들어온 객체가 Score로 형변환이 가능하지 않다면.... false
			return false;
		// 여기까지는 당연한 것들... 걸러줘야 할것들을 걸러주는 부분이다. 필드값을 비교 하지 않앗져??
		// 들어온 오브젝트가 좀 이상한지 안한지를 우선으로 걸러주는거다.

		Score other = (Score) obj; // object는 모든 클래스의 조상이기에 형변환이 가능하다.
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)) // 여긴 스트링이죠?? name이라는건 String. == 로 비교못하죠?? name.equals 는 String 클래스의
												// 이퀄스이다~ ...
			return false;
		if (score != other.score)
			return false;
		// 위의 경우에 하나도 해당이 되지 않는다면 트루를 리턴 ~ 같다는 말이겟죠?
		// 이렇듯 실제 필드값을 비교하는 것을 자바에서 제공한다느거~ 잘 알아두시고 이러한것을 여러분이 오버라이딩 해서 사용 하면 된다~
		return true;
		// 개발자가 만든 클래스를 이클립스에서 동등한지 비교하긴 어렵기에 오버라이딩을 한다~

		// 지금은 이퀄스를이렇게 오버라이딩 하면 해쉬코드도 해야 한다정도만 알고 넘어갈게요~ 동등성 동일성까지 설명하기엔 그렇기에
		// equals 는 두 객체의 내용이 같은지, 동등성(equality) 를 비교하는 연산자
		//	hashCode 는 두 객체가 같은 객체인지, 동일성(identity) 를 비교하는 연산자

	}


	
}
