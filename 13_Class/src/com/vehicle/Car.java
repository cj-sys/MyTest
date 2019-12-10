package com.vehicle;

public class Car {
	private String color;
	private int speed;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String color) {
		super();
		this.color=color;
	}

	public Car(String color, int speed) {
		super();
		this.color = color;
		this.speed = speed;
	}

	//get&set
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void accelPedal() {
		System.out.println("속도가 올라갑니다.");
		setSpeed(getSpeed()-10);
	}
	
	public void breakPedal() {
		setSpeed(getSpeed()-10);
		if(getSpeed()>0) {
			System.out.println("속도가 줄어듭니다.");
		}else {
			setSpeed(0);
			System.out.println("멈췄습니다.");
		}
	}
	
	public String toString() {
		return "현재 속도는 "+speed+" 입니다.";
	}
	
	
}
