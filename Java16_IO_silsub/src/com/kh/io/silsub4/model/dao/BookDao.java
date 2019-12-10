package com.kh.io.silsub4.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;

import com.kh.io.silsub4.model.vo.Book;

public class BookDao {
	public void fileSave(){
		Book[] brr = {new Book("자바의정석", "남궁성", 30000, new GregorianCalendar(2000,01,01), 0.1),
						new Book("홍길동전", "허균", 60000, new GregorianCalendar(1800,01,02), 0.2),
						new Book("칭찬은고래도춤추게한다", "고래", 34000, new GregorianCalendar(2001,05,01), 0.13),
						new Book("거위의꿈", "거위", 20000, new GregorianCalendar(1998,03,01), 0.15),
						new Book("난쟁이가쏘아올린작은공", "난쟁이", 40000, new GregorianCalendar(1880,01,03), 0.3)};
		
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.dat"));){
			
			
			for (int i = 0; i < brr.length; i++) {
				oos.writeObject(brr[i]);
			}
			
			System.out.println("books.dat 에 저장 완료!");
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead(){
		Book[] brr = new Book[10];
		
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"));){
			
			
			for (int i = 0; i < brr.length; i++) {
				brr[i] = (Book) ois.readObject();
				System.out.println(brr[i]);
			}
			
			
			
		} catch(EOFException e){
			System.out.println("books.dat 읽기 완료!");
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
