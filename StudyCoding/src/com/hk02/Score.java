package com.hk02;

public class Score {
	public double getAvg(int kor, int eng, int math) {
		double avg = (kor+eng+math)/3;
		return avg;
	}
	
	public char getGrage(double avg) {
		/*if(avg>90) {
			return 'A';
		} else if(avg > 80) {
			return 'B';
		} else if(avg > 70) {
			return 'C';
		}else if (avg>60) {
			return 'D';
		} else {
			return 'F';
		}*/
		
		char grade;
		
		switch((int)avg/10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default :
			grade='F';
			
		}
		
		return grade;
		
	}
}
