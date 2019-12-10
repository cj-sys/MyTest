package io.object.run;

import io.object.model.dao.ObjectIoTest;

public class Run {

	public static void main(String[] args) {
//		new ObjectIoTest().fileSave();
		//파일은 생성 되지만 write하는데 예외가 발생했다!! 
		//시리얼라이저블이 되지않았다는 건데
		
		new ObjectIoTest().fileRead();
		
		//시리얼 버전 확인
		//1. fileSave주석 후 read만 실행
		//2. 필드 추가 -> weight
		//InvalidClassException 발생 (시리얼버전이 다른 경우, 알수없는 데이터 타입 포함한경우, 기본생성자 없는 경
		//3.시리얼버전추가 후 save 실행!(weight 주석)
		//4. weight 추가 to String에 weight 출력문 작헝 -> save주석하고 read실행
		//5. weight는 0.0 출력되는거 확인(weight가 String이면 null)
		//시리얼버전 아이디가 같다면 멤벼변수(필드값)및메서드 추가는 크게 문제 없다.
		//멤버변수 제거 및 이름 변경을 해도 오류는 발생하지 않지만 데이터는 누락
		//자주 변경되는 클래스의 객체는 직렬화 하지지 않는 것이 좋다.
		//역직렬화가 되지 않는 경우를 생각해서 미리 예외처리해두는것이 좋다.
		
//		new ObjectIoTest().fileSaveList();
//		new ObjectIoTest().fileReadList();
//		
		
	}

}
