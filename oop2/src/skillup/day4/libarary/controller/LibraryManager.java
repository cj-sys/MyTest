package skillup.day4.libarary.controller;

import skillup.day4.libarary.model.vo.Book;
import skillup.day4.libarary.model.vo.ComicBook;
import skillup.day4.libarary.model.vo.CookBook;
import skillup.day4.libarary.model.vo.Member;

public class LibraryManager {

	private Member mem = null;
	private Book[] bList = {
			// �ʱ�ȭ
			new CookBook("�������� ���Ĵ�", "������", "���꽺", true), 
			new ComicBook("�ݿ���", "������", "���̹�", 19),
			new ComicBook("���ǽ�", "����", "japan", 12), 
			new CookBook("�������� �󸶳� ���ְԿ�", "������", "����", false),
			new CookBook("�ȳ��ϼ��� ��������", "����", "Youtube", true) };

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
