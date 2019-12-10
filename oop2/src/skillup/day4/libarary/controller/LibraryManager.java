package skillup.day4.libarary.controller;

import skillup.day4.libarary.model.vo.Book;
import skillup.day4.libarary.model.vo.ComicBook;
import skillup.day4.libarary.model.vo.CookBook;
import skillup.day4.libarary.model.vo.Member;

public class LibraryManager {

	private Member mem = null;
	private Book[] bList = {
			// 초기화
			new CookBook("백종원의 골목식당", "백종원", "스브스", true), 
			new ComicBook("금요일", "배진수", "네이버", 19),
			new ComicBook("원피스", "오다", "japan", 12), 
			new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false),
			new CookBook("안녕하세요 소프에요", "소프", "Youtube", true) };

	public LibraryManager() {
	}

	public void insertMember(Member m) {
		this.mem = m;
	}

	public Member myPage() {
		return mem;
	}

	public Book[] selectAll() {
		return bList;
	}

	public Book[] searchBook(String title) {
		Book[] searchList = new Book[5];
		int count = 0;

		for (int i = 0; i < bList.length; i++) {
			if (bList[i].getTitle().contains(title)) {
				searchList[count] = bList[i];
				count++;
			}

		}

		return searchList;
	}

	public int rentBook(int index) {
		int result = 0;

		if (bList[index] instanceof ComicBook) {
			if (((ComicBook) bList[index]).getAccessAge() > mem.getAge()) {
				result = 1;
			}
		} else if (bList[index] instanceof CookBook) {
			if (((CookBook) bList[index]).getCoupon() == true) {
				mem.setCouponCount(mem.getCouponCount() + 1);
				result = 2;
			}
		}

		return result;
	}
}
