package com.kh.silsub3.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ForWhile {
	public void selectMenu() {
		System.out.println("***메뉴를 선택하세요***");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		char chuga = 'y';
		String menu[]= {"불고기버거","치킨버거","감자튀김","치즈스틱","샐러드","콜라","에이드","커피"};
		int menum;
		int count;
		int countt[]={0,0,0,0,0,0,0,0};
		int price[]={0,0,0,0,0,0,0,0};
		int totalp=0;
		
		
		
		while (chuga == 'y') {
			System.out.println("추가변수!!!!!!!!!!!!!"+chuga);
			
			System.out.println("햄버거*************");
			System.out.println("1.불고기버거	3500원");
			System.out.println("2.치킨버거		3200원");
			System.out.println("추가*************");
			System.out.println("3.감자튀김		1000원");
			System.out.println("4.치즈스틱		3500원");
			System.out.println("5.샐러드		3500원");
			System.out.println("음료수*************");
			System.out.println("6.콜라		3500원");
			System.out.println("7.에이드		3500원");
			System.out.println("8.커피		3500원");
			System.out.println("*****************");

			System.out.println("메뉴선택: ");
			
			menum = sc.nextInt();

			switch (menum) {
			case 1:
				System.out.println("불고기버거를 선택하셨습니다.");
				System.out.println("수량은 ? ");
				count=sc.nextInt();
				countt[0]+=count;
				System.out.println(count+"개 주문하셨습니다.");
				price[0] += (3500*count);
				break;
			case 2:
				System.out.println("치킨버거를 선택하셨습니다.");
				System.out.println("수량은 ? ");
				count=sc.nextInt();
				countt[1]+=count;
				System.out.println(count+"개 주문하셨습니다.");
				price[1]=3200*count;
				break;
			case 3:
				System.out.println("감자스튀김 선택하셨습니다.");
				System.out.println("수량은 ? ");
				count=sc.nextInt();
				countt[2]+=count;
				System.out.println(count+"개 주문하셨습니다.");
				price[2]=1000*count;
				break;
			case 4:
				System.out.println("치즈스틱를 선택하셨습니다.");
				System.out.println("수량은 ? ");
				count=sc.nextInt();
				countt[3]+=count;
				System.out.println(count+"개 주문하셨습니다.");
				price[3]=400*count;
				break;
			case 5:
				System.out.println("샐러드를 선택하셨습니다.");
				System.out.println("수량은 ? ");
				count=sc.nextInt();
				countt[4]+=count;
				System.out.println(count+"개 주문하셨습니다.");
				price[4]=2000*count;
				break;
			case 6:
				System.out.println("콜라를 선택하셨습니다.");
				System.out.println("수량은 ? ");
				count=sc.nextInt();
				countt[5]+=count;
				System.out.println(count+"개 주문하셨습니다.");
				price[5]=700*count;
				break;
			case 7:
				System.out.println("에이드를 선택하셨습니다.");
				System.out.println("수량은 ? ");
				count=sc.nextInt();
				countt[6]+=count;
				System.out.println(count+"개 주문하셨습니다.");
				price[6]=1200*count;
				break;
			case 8:
				System.out.println("커피를 선택하셨습니다.");
				System.out.println("수량은 ? ");
				count=sc.nextInt();
				countt[7]+=count;
				System.out.println(count+"개 주문하셨습니다.");
				price[7]=1000*count;
				break;
			/*
			 * default: System.out.println("다시선택"); break;
			 */
			}

			System.out.println("추가주문하시겠습니까?(y/n): ");
			chuga=sc.next().charAt(0);
			
			if (chuga == 'n') {
				break;
			}
		}
		
		System.out.println("*주문하신 정보는 다음과 같습니다.\n------------------------");
		for(int i=0; i<menu.length;i++) {
			if(price[i]!=0) {
				System.out.println(menu[i]+" : "+countt[i]+"개 - "+price[i]+"원");
				totalp +=price[i];
			}
		}
		System.out.println("------------------------\n총 가격 : "+totalp+"원");
		
	}

	public void contInput() {
		String s = null;
		char c;
		int cnt=0;
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.println("문자열 입력 : ");
		s=sc.nextLine();
		System.out.println("문자 입력 :");
		c=sc.next().charAt(0);
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)==c) {
				cnt++;
			}
		}
		System.out.println("포함된 갯수 : "+cnt+"개");
		System.out.println("================");
		} while(Pattern.matches("[a-z]", s) && Pattern.matches("[A-Z]", s));
	
	}
}
