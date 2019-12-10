package com.test05;

public class L_tv implements Tv {
	private int vol;
	
	public L_tv() {
		super();
		System.out.println("lTv켜짐");
	}
	
	
	public int getVol() {
		return vol;
	}


	public void setVol(int vol) {
		this.vol = vol;
	}


	@Override
	public int volUp() {
		setVol(getVol()+1);
		return getVol();
	}

	@Override
	public int volDown() {
		setVol(getVol()-1);
		return getVol();
	}
	
	public void tvClosed() {
		System.out.println("lTv꺼짐");
		
	}

}
