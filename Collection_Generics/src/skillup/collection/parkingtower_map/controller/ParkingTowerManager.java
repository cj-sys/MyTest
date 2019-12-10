package skillup.collection.parkingtower_map.controller;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import skillup.collection.parkingtower_map.model.Car;

public class ParkingTowerManager {
	
	private Map<Integer,Car> carMap = new HashMap<>();
	//주차 차량의 모든 데이터가 담겨 있는 carMap
	//이 리스트에 차량 정보가 저장, 삭제, 검색이 되는것이다.
	
	public ParkingTowerManager() {}
	
	public void insertCar(Car car) {
		int lastNo=0;
		
		Iterator<Integer> it = carMap.keySet().iterator();	//keySet()의 Iterator를 ㄹ통해 key들의 집합을 반복문을 통해 확인
		while(it.hasNext()) {
			lastNo = it.next(); // 반복문의 최종값이 결국 차량의 마지막 번호 -->lastNo에 대입
		}
		
		carMap.put(lastNo+1, car);		   //carMap에 넣는다.
		
	}

	public int deleteCar(int carNum) {
		Car del = null; // 삭제되는 도서를 담을 변수
		
		
		Set<Entry<Integer, Car>> entry = carMap.entrySet();
	
		
		for(Map.Entry<Integer, Car> me : entry) {
			if(me.getValue().getCarNum() == carNum) {
				del = carMap.remove(me.getKey());
			}
		}
		
		
		if(del!=null) { //del이 존재할 경우 --> 즉 삭제된 경우 1 리턴
			return 1;
		}else {			//del이 존재 하지 않는 경우 --> 즉 전달받은 차량번호와 일치하는 차량이없는 경우 0리턴
			return 0; 
		}
	}

	public Map<Integer, Car> searchCar(String owner) { //제네릭으로 Car를 선언하고 해보자..
		
		Map<Integer, Car> searchMap = new HashMap<Integer, Car>(); //전달받은 도서명을 포함한 도서들을 보관할 searchMap 공간 생성
		
		Iterator<Map.Entry<Integer, Car>> it = carMap.entrySet().iterator(); //이터레이터는 키벨류를 관리 못함... 엔트리셋으로 받고난 다음에 이터레이터로 변환
		while(it.hasNext()) {
			Map.Entry<Integer, Car> entry = it.next();
			
			if(entry.getValue().getOwner().contains(owner)) {
				searchMap.put(entry.getKey(), entry.getValue());
			}
		}
		
		
		return searchMap;	//일치하는 차량정보가 담긴 리스트를 리턴한다.
	}

	public Map<Integer, Car> selectMap() {
		// TODO Auto-generated method stub
		return carMap;
	}

	
}
