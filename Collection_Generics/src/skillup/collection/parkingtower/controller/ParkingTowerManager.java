package skillup.collection.parkingtower.controller;


import java.util.ArrayList;
import java.util.List;

import skillup.collection.parkingtower.model.Car;

public class ParkingTowerManager {
	
	private List<Car> carList = new ArrayList<>();
	//주차 차량의 모든 데이터가 담겨 있는 carList
	//이 리스트에 차량 정보가 저장, 삭제, 검색이 되는것이다.
	
	public ParkingTowerManager() {}
	
	public void insertCar(Car car) {
		int lastNo=0;
		
		try {
			lastNo = carList.get(carList.size()-1).getParkingNum() +1; // 첫번째 차량ㅇ ㅣ아닌 경우 마지막 차량의 주차번호를 알아오고 1을 추가한 값을 lastNo에 대입
		} catch (ArrayIndexOutOfBoundsException e) {
			lastNo = 1; //처음 차량을 주차할 경우(list가 비어있는 경우) AIOOBExceptioon 발생... -> 
						//chtch안에 처음 도서이기 때문에 1로 초기화 한다... if로도 대체가능
		}
		
		car.setParkingNum(lastNo); //주차 번호를 초기화 하고
		carList.add(car);		   //carList에 넣는다.
		
	}

	public Car deleteCar(int carNum) {
		Car del = null; // 삭제되는 도서를 담을 변수
		
		for(int i=0; i<carList.size(); i++) {
			if(carList.get(i).getCarNum() == carNum) {// 전달받은 차량번호와 일치하는 차량일 경우
				del = carList.remove(i);			//삭제하고 del에 담아준다.
			}
		}
		
		return del;
	}

	public List<Car> searchCar(String owner) { //제네릭으로 Car를 선언하고 해보자..
		List<Car> searchList = new ArrayList<Car>(); //전달받은 차주이름을 포함한 차량을 저장할 searchList 생성
		
		for(int i=0; i<carList.size(); i++) { //주차 차량의 모든 데이터가 담겨 있는 carList
			if(carList.get(i).getOwner().contains(owner)) {
				searchList.add(carList.get(i));	//carList에 전달받은 차주이름과 같은 것이 있다면 searchList에 담는다.
			}
		}
		
		return searchList;	//일치하는 차량정보가 담긴 리스트를 리턴한다.
	}

	public List<Car> selectList() {
		
		return carList;
	}

}


