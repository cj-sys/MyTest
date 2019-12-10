package exception;

public class Exception1_2 {

	public static void main(String[] args) {
		
		
		//난수 저장 변수
		int ran=0;
		
		//결과값 저장 변수
		double res = 0.0;
		
		
		//난수 0~9 발생 -> 10/ran
		//만약에 ran이 0이면 안되겟죠? 어떠한 예외가 생기는지 확인해볼것이다.
		//ArithmeticException 발생한다.~ 
//		for(int i=0; i<10; i++) {
//			//0~9까지의 난수 생성
//			//random*10 이 -> 0~9.9999999 까지 이니까 int로 바꿔주면 0~9
//			ran = (int)(Math.random()*10);
//			res = 10/ran;
//			System.out.printf("ran : %d => %f\n",ran, res);
//		}
//		
		

		//try catch 하기전에 그냥 한번 실행해 본다.
		//아리스메틱 이라는 Exception 발생하는거 확인 가능하다!!! 
		
		//확인 했다면 try catch 한번 해보자
		
		try {
			//1~9까지는 문제없이 나눗셈이 되지만 0으로 나누느 경우
			//-->ArithmeticException 발생
			for(int i=0; i<10; i++) {
				//0~9까지의 난수 생성
				//random*10 이 -> 0~9.9999999 까지 이니까 int로 바꿔주면 0~9
				ran = (int)(Math.random()*10);
				res = 10/ran;
				System.out.printf("ran : %d => %f\n",ran, res);
			}
			
		} catch(ArithmeticException e) {
			e.printStackTrace();
//			System.out.println("예외발생~~");
		}
	
		
		/*
		try {
			result = 10/ran;	예외가 발생할 부분
			syso();
			
			여기 안에 있는 명렁문들을 트렌젝션이라는 일의 단위로 묶어 버림.
			위의 두 명령어가 하나의 묶음으로 묵여버렸으니까... 0일 경우에는 syso도 실행이 안되는 거다.
		} catch(exception ) {
			syso(예외발생~)
			예외가 발생했을때 예외가 처리할 부분
			
		}
	
	*/
		System.out.println("프로그램이 종료되었씁니다.");
		
	}

}
