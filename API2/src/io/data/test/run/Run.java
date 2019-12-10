package io.data.test.run;

import io.data.test.controller.SungjukProcess;

public class Run {

	public static void main(String[] args) {
		SungjukProcess sp = new SungjukProcess();
		sp.sungjukSave();
		sp.scoreRead();
	}

}
