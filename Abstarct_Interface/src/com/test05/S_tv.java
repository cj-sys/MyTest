package com.test05;

public class S_tv implements Tv {

	private int vol;
	
	public  S_tv() {
		super();
		System.out.println("sTV 켜짐");
	}
	
	
	
	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}



	@Override
	public int volUp() {
		setVol(getVol()+3);
		return getVol();
	}

	@Override
	public int volDown() {
		setVol(getVol()-3);
		return getVol();
	}
	
	public void tvClose() {
		System.out.println("sTv가 꺼짐");
	}

}
