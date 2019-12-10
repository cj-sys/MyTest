package com.score;

public class Score {

	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Score() {
	
	}
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		int sum = getKor() + getEng() + getMath();
		return sum;
	}
	
	public double getAvg() {
		double avg = (double)getSum()/3;
		
		return avg;
	}
	
	public char getGrade() {
		switch ((int)getAvg()/10) {
		case 10:
		case 9 :
			return 'A';
		case 8 :
			return 'B';
		case 7 :
			return 'C';
		case 6 :
			return 'D';
		default :
			return 'F';
		}
	}
	@Override
	public String toString() {
		return String.format("%s %d %d %d %d %.2f %c",getName(),getKor(),getEng(),getMath(),getSum(),getAvg(),getGrade());
	}
	
}








