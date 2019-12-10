package io.object.test.model.vo;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Book implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7711328684601220441L;
	
	private String title;			// 도서명
	private String author;			// 저자
	private int price;				// 가격
	private Calendar dates;			// 출판날짜
	private double discountRate;	// 할인율
	
	public Book() {}
	
	public Book(String title, String author, int price, Calendar dates, double discountRate) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.dates = dates;
		this.discountRate = discountRate;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Calendar getDates() {
		return dates;
	}
	public void setDates(Calendar dates) {
		this.dates = dates;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 출간 ");
		//날싸 형식을 변경... 입력한 형식으로 날짜를 변경하겟다!
		String str=sdf.format(dates.getTime());
		//simpleDateFormat의로 등록한 형식에 getTime으로 저장한 시간을 가져와서 담은뒤에 str에 담은것!
		return title+" "+author+" "+price+" "+str+discountRate;
	}
}

