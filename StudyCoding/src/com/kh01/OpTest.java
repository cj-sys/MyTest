package com.kh01;

public class OpTest {
	public static final int num=2;
	
	/*
	 * 숫자 2개를 parameter로 받아서
	 * 사칙연산
	 * @param a 입력값
	 * @param b 입력값
	 */
	
	public static void Op01(int a, int b) {
		//1.사칙ㄱ연산(%나머지)
		System.out.printf("%d + %d = %d 입니다.\n",a,b,a+b);
		System.out.printf("%d - %d = %d 입니다.\n",a,b,a-b);
		System.out.printf("%d * %d = %d 입니다.\n",a,b,a*b);
		System.out.printf("%d / %d = %d 입니다.\n",a,b,a/b);
		System.out.println("------------------");
		
	}
	public static void Op02(int a, int b) {
		//2. 대입연산자 +=, *=, /=, -=, %=
		int res=0;
		res=a;
		
		System.out.println("x= " + a + " y= " +b + " res= " + res);
		
		res +=10;
		System.out.println("res + 10 =" +res);
		
		res-=10;
		System.out.println("res - 10 =" +res);
		
		System.out.println("-------------------");
		
	
	/*
	 * 3. 증감연산자(--) 증가연산자(++) : 변수의 앞뒤로 선택해서 증감.증가연산자를 덧붙이게 되면 변수가 가진 값을 1씩 증감/증가 시켜준다
	 * -후위 연산자 : 연산자를 변수 뒤에 붙여서 값을 먼저 리턴하고 연산은 나중에 하게 되는 연산자.
	 * -전위 연산자 : 연산자를 변수 앞에 붙여서 연산을 먼저 하고 값을 나중에 리턴하는 연산자.
	 */
		System.out.println(a);
		System.out.println(++a);
		System.out.println(a++);
		System.out.println(a);
		res=0;
		
		res = a++ + ++b + --b + b-- + ++a;
		//11(12) + 3(3) + 2(2) + 2(1) + 13(13) = 31
		System.out.println(res);
		System.out.println("=================");
	}
	
	public static void Op03() {
		//4.비트 연산자 &,|, ^, ~  -> 수치를 0,1 비트 상태에서 연산한 결과를리턴한다.
		int a = 10; // 0000 0000 0000 0000 0000 0000 0000 1010(8byte/32bit)
		int b = 2; // 0000 0000 0000 0000 0000 0000 0000 0010
		
		System.out.println(a&b);
		/*  0000 0000 0000 0000 0000 0000 0000 1010
		 * &0000 0000 0000 0000 0000 0000 0000 0010
		 * ----------------------------------------
		 *  0000 0000 0000 0000 0000 0000 0000 0010
		 */
		
		System.out.println(~a);
		/*
		 * 0000 0000 0000 0000 0000 0000 0000 1010
		 * ----------------------------------------
		 * 1111 1111 1111 1111 1111 1111 1111 0101
		 */
		
		System.out.println("===========================");
		int c=10;
		System.out.println(Integer.toBinaryString(c>>2) + "=2(2진법 10)");
		//00 0000 0000 0000 0000 0000 0000 0000 10
		System.out.println(c<<2);
		//00 0000 0000 0000 0000 0000 0000 1010 00
		
		c=-10;
		System.out.println(Integer.toBinaryString(c));
		//0->1, 1->0 한 다음 +1 하면
		
		System.out.println(Integer.toBinaryString(c<<2));
		System.out.println(c<<2);
		
		c=-10;
		System.out.println(Integer.toBinaryString(c>>2));
		System.out.println(c>>2);
		
		c=-10;
		System.out.println(Integer.toBinaryString(c>>>2));
		System.out.println(c>>>2);
		//>>연산자의 경우는 부호비트는 고정되고 쉬프트 되지만 >>> 연산자는 부호비트도 함께 쉬프트 됩니다.
		System.out.println("=========================");
		//왼쪽으로 한번 shift 해주면, *2 (오른쪽으로 한번 =/2) 실제적인 */ 보다 조금 더 빠르다.
		
		
	}
	
	public static void Op04() {
		//5. 논리연산자 &&, || : true, false
		System.out.println(true && true);
		System.out.println(false && true);
		System.out.println(true && false);
		System.out.println(false && false);
		System.out.println("");
		
		System.out.println(true || true);
		System.out.println(false || true);
		System.out.println(true || false);
		System.out.println(false || false);
		
		System.out.println("");
		
		int a=2, b=3;
		System.out.println((a>b) && (a<b)); // &&연산자는 앞의 결과가 false일 경우 뒤의 연산은 ㄴ하지 않는다.
		System.out.println("a= " +a+"\t b= "+b);
		System.out.println("========================");
	}
	/*
	 * 숫자 두개를 받아서 true/false 리턴
	 * 
	 * @param a 입력값
	 * @param b 입력값
	 * @return boolean
	 */
	public static boolean Op05(int a, int b) {
		boolean res = (a>b?true:false);
		System.out.println(res);
		
		int i = (a==b?a+b:a-b);
		System.out.println(i);
		
		String s= (a<b?"a가 작다":"b가 작다");
		System.out.println(s);
		return res;
	}
	public static void main(String[] args) {
		Op01(9,num);
		Op02(9,num);
		
		Op03();
		Op04();
		System.out.println("main  " + Op05(9,num));
	}
}
