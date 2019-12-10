package exception;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("영문을 쓰시오(대문자 입력시 오류 발생): ");
		String input = sc.next();
		
		//[1]
		//문자 하나하나를 살펴보면서 대문자가 포함이 되어있다면 오류를 발생시킬것!!
		
/*		for(int i=0; i<input.length(); i++) {
 *			대문자일 경우에 throw를 통하여 예외처리를 발생시키자!
			if(input.charAt(i) >='A' && input.charAt(i)<='Z') {
				throw new CustomException();
				//예외를 직접 발생시킬대는 throw, 우리가 만든것이기떄문에 우리가 임의로 발생을 시켜야 한다.!! 대문자 있다면!! 얘 발생시켜!~~!
				
				//빨간줄 있을거다~~ 왜냐 .. 지금 커스텀익셉션이라는 클래스는 그냥 클래스이기때문이다...
				//그래서 그 친구를 예외클래스로 만들어 줘야 한다!! extends Exception을 해줘야지 얘는 예외클래스야~~ 라고 생각한다.
				//그렇게 해주지 않으면 throw 뒤에 그클래스를 발생을 못시킨다!!
				
				//extends를 안해주면, 나 예외처리를 할거야~ 라는걸 안해주는 거고
				//throw뒤에 클래스를 발생 시킬수 없다 그래서 extends exception을 해줘야한다...!!
				
				//그런다음 예외가 발생했으니 잡아줘야겟죠???
				//여기서 계속 작업을했으니 여기서 잡아주자~~ 
			}
	
		}
	*/		
		//[2] 위에꺼 설명한뒤에
		try {
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) >='A' && input.charAt(i)<='Z') {
					//1.기본생성자	throw new CustomException();
					//요렇게 해놓고 extends 해서 빨간줄 없애는거 까지 한다!!!
					
					//2. str를 상위로 넘기고 넘겨서 throwabl의 detailmesage에 등록이 된다.!
					//매개변수가 있는 생성자를 통해 메시지를 던져준다.
					
					/*throw new CustomException("대문자야!!!");*/
					
					//3. 다르게 한번 해봅시다...사용자정의예외처리니까 우리 맘대로 할수 있따!!!!
					throw new CustomException(input.charAt(i));
					//예외처리클래스로 가서 생성자 하나 더 만들자! 
					
				}
			}
		} catch (CustomException e) {
			//아직 커스텀익셉션을 체워주지 않았으니 여기까지 비워두고
			//체워주러 가자!!!
			
			//throwable에 등록된 메시지가 출력된다.
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
