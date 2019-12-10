package io.object.test.run;

import io.object.test.controller.BookManager;

public class Run {

	public static void main(String[] args) {
		BookManager bm = new BookManager();
		bm.fileSave();
		bm.fileRead();
	}

}
