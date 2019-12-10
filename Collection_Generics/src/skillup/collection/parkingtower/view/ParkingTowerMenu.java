package skillup.collection.parkingtower.view;


import java.util.List;
import java.util.Scanner;

import skillup.collection.parkingtower.controller.ParkingTowerManager;
import skillup.collection.parkingtower.model.Car;

public class ParkingTowerMenu {
	Scanner sc = new Scanner(System.in);
	
	private ParkingTowerManager ptm = new ParkingTowerManager();

	public ParkingTowerMenu() {
	}

	public void mainMenu() {
		while (true) {
			System.out.println("=== *주차 타워 관리* ===");
			System.out.println("1. 차량 주차");
			System.out.println("2. 차량 출자");
			System.out.println("3. 주차 차량 검색");
			System.out.println("4. 전체 출력");
			System.out.println("0. 끝내기");
			System.out.println("-------------------");
			System.out.println("메뉴 선택: ");
			int num = sc.nextInt();
			sc.nextLine(); // 엔터키 제거

			switch (num) {
			case 1:
				insertCar();
				break;
			case 2:
				deleteCar();
				break;
			case 3:
				searchCar();
				break;
			case 4:
				selectList();
				break;
			case 0:
				System.out.println("프로그램 종료!");
				return;
			default : System.out.println("잘못입력!!");
			}

		}
	}

	public void insertCar() {
		System.out.println("차량 번호: ");
		int carNum = sc.nextInt();
		sc.nextLine();

		System.out.println("차량 타입 (1.경차/2.세단/3.SUV/4.트럭): ");
		int carType = sc.nextInt();
		sc.nextLine();

		System.out.println("차주: ");
		String owner = sc.nextLine();

		Car car = new Car(carNum, carType, owner);

		ptm.insertCar(car); // 주차번호는 따로 입력하지 않는다.... 메서트 확인해보소
	}

	public void deleteCar() {
		System.out.println("차량 번호: ");
		int carNum = sc.nextInt();
		sc.nextLine();

		Car res = ptm.deleteCar(carNum); // ptManager의 deleteCar로 전달 후 리턴값 1 or 0

		if (res != null) {
			System.out.println("차량 출차 완료!");
			System.out.println(res);
		} else {
			System.out.println("입력하신 차량이 주차되어 있지 않습니다.");
		}
	}

	public void searchCar() {
		System.out.println("주차 차량 검색(차주 입력): ");
		String owner = sc.nextLine();

		List searchList = ptm.searchCar(owner); 
		// 입력한 owner와 동일한 데이터가 있으면 받아서 searchList에다 넣는다....

		if (searchList.isEmpty()) {
			System.out.println("검색한 차량이 존재하지 않습니다.");
		} else {
			for (int i = 0; i < searchList.size(); i++) {
				System.out.println(searchList.get(i));
			}
		}

	}

	public void selectList() {
		List<Car> searchList = ptm.selectList();

		if (searchList.isEmpty()) {
			System.out.println("주차된 차량이 없습니다.");
		} else {
			for (Object o : searchList) {
				System.out.println(((Car) o).toString());
			}
		}

	}

}
