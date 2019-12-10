package io.object.test.controller;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

import io.object.test.model.vo.Book;


public class BookManager {

	public void fileSave() {
		Book[] bk = new Book[5];
		
		bk[0] = new Book("JAVA", "김씨", 10000, setCalendar(2012,2,2), 0.1);
		bk[1] = new Book("C언어", "이씨", 20000, setCalendar(2013,3,3), 0.2);
		bk[2] = new Book("파이썬", "박씨", 30000, setCalendar(2014,4,4), 0.3);
		bk[3] = new Book("코틀린", "서씨", 40000, setCalendar(2015,5,5), 0.4);
		bk[4] = new Book("연금술사", "최씨", 50000, setCalendar(2016,6,6), 0.5);	
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.txt"))){
			for(int i=0;i<bk.length;i++) {
				oos.writeObject(bk[i]);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public Calendar setCalendar(int year, int month, int date) {
		//Calendar 클래스는 추상 클래스이므로 객체를 직접 생성할 수는 없지만, getInstance() 메소드를 이용하여 시스템의 날짜와 시간 정보를 표현할 수 있다
		Calendar pDate = Calendar.getInstance();

		pDate.set(year, month-1, date);
		//month의 값이 5일 경우 6월을 의미, 그래서 -1한다.
		
		return pDate;
	}
	
	public void fileRead() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.txt"))){
			while(true) {
				System.out.println((Book)ois.readObject());
			}
		}catch(EOFException e) {
			System.out.println("books.txt 읽기 완료!");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
