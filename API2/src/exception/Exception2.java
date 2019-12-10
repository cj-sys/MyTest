package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception2 {

	//Exception1이 랜던값으로 나눴다면
	//이번엔 우리가 입력한 값을 나눌거다
	public static void main(String[] args) {
		//입력을 받아야하니 Scanner 객체 생성
		Scanner sc = new Scanner(System.in);
		
		//결과값을 담을 변수 선언
		int res = 0;
		
		System.out.println("나눌 숫자 하나 입력: ");
//		int num = sc.nextInt();
		
		
		//우선 먼저 try없이 실행해보자~
		//[1] try/catch 없이
//		int num = sc.nextInt();
//		res = 10/num;
//		System.out.println(res);
		
		
		//[2] try/catch
/*		int num = sc.nextInt();
		try {
			res = 10/num;
			System.out.println(res);
		} catch (ArithmeticException e) {
			System.out.println("0을 넣으니까 안되지!!!");
		}
*/		
		//0을 입력해도 잘 처리가 된다!
		//catch 안의 출력문이 실행되는게 확인 된다.
		//근데 여기서 a를 입력해버린다면.....
		//InputMismatchingException 발생한다!! 확인해바바바!!!!!!
		
		//여러분들이 디버깅 할때 모든 경우의 수를 다 돌려 봐야 한다... 
		//그래야 이렇게 다른 익셉션이 발생한다는거 발견하고 처리를 할수 있다!
		
		
		//[3] 문자 입력할때!!!!
//		int num = sc.nextInt(); 요놈에서 미스 매치 일어나니까 try 안에 넣어줘야한다.!!!!
/*		try {
			//try문 밖에 있던걸 안으로 넣어준다.!!
			//catch문까지 다 적어주고 넣어주자
			//int num = sc.nextInt();
			
			res = 10/num;
			System.out.println(res);
		} catch (ArithmeticException e) {
			System.out.println("0을 넣으니까 안되지!!!");
		} catch (InputMismatchException e ) {
			System.out.println("마! 문자 안되 넣지마!!!");
			//근데.. 잘 생각 해보면... inputmismatchingException 얘는 
			//num에 문자를 넣으려할때 발생하는거자나????
			//잡아주기 위해서는 try 안에 넣어줘야 하겟죠?? 묶어준다!
		}
	*/	
		
		/*
		java.lang의  (쓰로어블을 상속받는 자식들중 두 개) 
		throwable --> Error : sys에러, 다룰수 없다
				  --> Exception : 얘는 예외 --->runtimeException ( 지금 작업하는 것들은 얘의 하위, 아리스틱, 인풉미스매칭 등등...)
										 --->런타임을 제외한 모든 익셉션
		 */
		
		
		
		/*
		 우리가 다룰 익셉션의 최상위 클래스는??? 쓰로어블이 아니라 익셉션이다..!! 왜냐! 우리가 다룰 익셉션들은 모두 Exception클래스의 하위이고
		Throwable 클래스에는 Exception 외에도 우리가 다룰수 없는 Error 도 포함 되었기 때문이다!!!!!!!!
		
		이걸 왜 얘기하나... 캐치문을 여러개~ 작성 할수 있다~ 바로 위처럼... 
		근데 귀찮차~ 한번에 처리 하고 싶어~~ 라고 생각 한다면 	아래처럼 하면 된다.!!1 
		 
		 */
		
		//[4]
//		try {
//			int num = sc.nextInt();
//
//			result = 10 / num;
//			System.out.println(result);			
//		}catch(/*Runtime*/Exception e) {
//			System.out.println("너가 0 아니면 문자 입력했겠지 뭐든 안돼!!");
//		}
		
		//그런데 이렇게 한번에 처리하면 편리하긴 하겟죠??
		//하지만 내가 0을 입력햇을땐~~ 이프로그램, 문자 입력했을땐~~ 저프로그램 쓴다고 했을때 
		//각각 예외처리를 해주는 것이 좋다.
		
		//[5]
		try {
			int num = sc.nextInt();

			res = 10 / num;
			System.out.println(res);			
		}catch(ArithmeticException e) {
			System.out.println("0 안된다니깐");
		}catch(InputMismatchException e) {
			System.out.println("문자안되임마");
		}catch(Exception e) {
			System.out.println("너가 0 아니면 문자 입력했겠지 뭐든 안돼!!");
		}
		
		//그리고 catch의 순서는 
		//큰놈에서 작은놈으로~~~ 
		//왜냐하면 위에 놓았다고 하면... 큰놈이 먼저 예외를 잡아버리기에
		//다른 작은 애들은 예외처리를 할일이 없다!
		//항상 작은거 부터 쓰고 큰걸 아래에 써라~

	
	}
}
