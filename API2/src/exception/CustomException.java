package exception;


//run에서 
//throw new CustomException(input.charAt(i));
//이거 하고 난 후에 extens 추가!!!  처음엔 그냥 클래스만 두자!! 휑하니~
public class CustomException extends Exception {
	
	
	/*
	  
	 */
	
	
	public CustomException() {}
	
	
	public CustomException(String str)  {
		//보통 예외클래스를 보면  이런식으로 되어있다..
		//그걸 따라 갈게요
		
		//일반적으로 super로 내가 받아온 메시지를 넘기도록 되있을거다!! 
		super(str);
		//커스텀익셉션 -> Exception -> throwable 까지 올라간다.
		//super를 사용하면 최상이인 throwable까지 올라가서 getMessage로 간다.
		//run으로 돌아가서
	}
	
	
	//나중에 추가
	public CustomException(char ch) {
		
		super(ch+"는 대문자이므로 논리적 오류(예외상황발생)");
		
	}
}
