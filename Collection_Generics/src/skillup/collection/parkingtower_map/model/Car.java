package skillup.collection.parkingtower_map.model;



public class Car {
	
	//parkingNum은 맵의 키값으로 사용하기 때문에 삭제
	private int carNum;
	private int carType;
	private String owner;
	
	public Car() {}

	public Car(int carNum, int carType, String owner) {
		this.carNum = carNum;
		this.carType = carType;
		this.owner = owner;
	}

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}

	public int getCarType() {
		return carType;
	}

	public void setCarType(int carType) {
		this.carType = carType;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		String str = "";
		if(carType == 1) {
			str="경차";
		} else if(carType == 2) {
			str="세단";
		} else if(carType == 3) {
			str="SUV";
		} else if(carType == 4) {
			str="트럭";
		}
		
		return "차량번호 : " + carNum + ", 차량종류 : " + str + ", 차주이름 : " + owner;
	}
	
	
	
}

