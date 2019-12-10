package com.kh.io.silsub4.run;

import com.kh.io.silsub4.model.dao.BookDao;

public class Run {

	public static void main(String[] args) {
		BookDao bd = new BookDao();
		bd.fileSave();
		bd.fileRead();
	}

}
