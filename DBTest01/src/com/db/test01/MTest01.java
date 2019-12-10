package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MTest01 {

	/*
	 * 자바 db 커넥션
	 * j   db c 
	 */
	public static void main(String[] args) throws SQLException {
		
		//1.driver연결 : ojdc6.jar 꼭 추가하자!!!!!
		try {
			//해당 클래스를 가져와 주겟다~~ 라는 말... OracleDriver라는 클래스를 객체를 가져와 주게다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//2.계정연결
		Connection con = null;
		try {
			//db서버의 url이다~~
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");
			//로그인한 결과가 con에 담김
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3.쿼리준비
		//객체가 필요.... 쿼리를 준비해주는애
		Statement stmt = null;
		
		//리절트 셋이라는 객체도 만들어주자
		//셀렉트해서 나온 테이블을 리절트 셋이라는 객체에 담긴다.(셋임... 소름)
		ResultSet rs = null;
		
		//
		String sql = "SELECT * FROM EMP";
		
		
		//스테이트먼트 객체를 만들어 준다.
		stmt = con.createStatement();
		
		//4.쿼리실행및 리턴
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			//컬럼의 순서로 가져오가나 컬럼의 이름으로 가져 올수 잇다.. 둘다 가능...
			System.out.printf("%d %s %s %d %s %d %.2f %d\n\n", rs.getInt(1), rs.getString(2), rs.getString("JOB"),rs.getInt("MGR"), 
															rs.getString(5),rs.getInt(6), rs.getDouble("COMM"), rs.getInt(8));
		}
		
		//5. 디비종료 커넥션이 열려있으면 메모리를 계속 잡아먹으니 종료해줘야 한다.~
		rs.close();
		stmt.close();
		con.close();
		
	}

}
