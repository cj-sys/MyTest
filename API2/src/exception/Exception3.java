package exception;

import java.util.Scanner;

public class Exception3 {

	public static void main(String[] args) {
		//배열만들어서 크 입력
		//스캐너 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.println("배열을 만들자!");
		int arr[];
		
		
		//[1]
/*		System.out.println("배열 크기를 입력하시오(양수): ");
		int length = sc.nextInt();
		arr = new int[length];
*/	
		//잘 될거다! 
		//그치만 꼭 삐뚤어진 친구가 있다.. 음수를 ㄹ입력하는 경우 어떻게 될까요???
		//NagativeArraySizeException이라는 음수입력할수없다~~ 라는 익셉션이 발생할거다..!!
		//어디서??????? 
		//arr = new int[length];  여기서!!
		
	
		//[2] 예외처리
/*		System.out.println("배열 크기를 입력하시오(양수): ");
		int length = sc.nextInt();
		
		try {
			arr = new int[length];
		} catch (NegativeArraySizeException e) {
			System.out.println("배열 크긱 ㅏ어떻게 음수 일수 있겟니~~ 잘못입력햇어!!!");
		}
*/	
		//요렇게 까지 예외를 처리하면 프로그램이 끝난다~~
		//아! 그렇다면 잘못입력했을땐 끝내지 말고 다시 입력받게 하고 싶으면~~~?
	
		
		
		//[3]예외처리시 다시 입력
/*		while(true) {
		System.out.println("배열 크기를 입력하시오(양수): ");
		int length = sc.nextInt();
		
		try {
			arr = new int[length];
			break; 
			//브레이크문 없다면 무한으로 돌기때문에 빨간줄이 생긴다!
		} catch (NegativeArraySizeException e) {
			System.out.println("배열 크긱 ㅏ어떻게 음수 일수 있겟니~~ 잘못입력햇어!!!");
		}
		
		//여기에 문자 넣었을때 발생하는 exception inputmismatchexception을 추가 해도 된다!!1
		//한번 해보세요!!
		
		}
*/		
	
		//[4]if문으로 예외처리
		//NegativeArraysizeException 할때 실행하기전에 빨간줄 없었다!!! 런타임 익셉션중 하나라는 것!
		//예외처리 해도 되고 안해도 되고~~ 
		//런타임은 if문으로 예외처리하는것을 권장
		// 한번 해보소~~~
		
		while(true) {
			System.out.println("배열 크기를 입력하시오(양수): ");
			int length = sc.nextInt();
			
			if(length > 0) {
				arr = new int[length];
				break;
			} else {
				System.out.println("배열 크긱 ㅏ어떻게 음수 일수 있겟니~~ 잘못입력햇어!!!");
			}
		}
		//프로그램의 의도만 잘 생각해보면 if문을 가지고도 예외를(양수를 입력 외의 입력) 처리할수 있다.
		
		System.out.println("프로그램을 종료합니다.");
		
		
		
		
	}

}
