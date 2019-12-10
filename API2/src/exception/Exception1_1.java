package exception;

public class Exception1_1 {

	// 다른 런타임익셉션 발생시켜보자
	public static void main(String[] args) {

//		try {
//			//우선 이것만 적어본다.
//			throw new Exception(); // Exception을 발생
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		
		
		//1.NullPointerException

/*		String str = "abc";

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
*/
		//2. ArrayIndexOutOfBoundsException
		int[] arr = new int[3];
		
			for(int i=0; i<4; i++) {
				arr[i]=i;
				System.out.println(i);
			}
		
		
		
		
		//3.ClassCastException :  cast 연산자 사용시 타입 오류
		//instanceof로 해결가능
		String str = "1";
		Object obj = str;
		Integer integer = (Integer)obj;
		
		System.out.println(integer);
		

	}

}
