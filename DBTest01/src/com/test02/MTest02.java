package com.test02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MTest02 {

	public static void main(String[] args) {
		//1.드라이버 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//2.계정연결
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","kh");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3.쿼리준비
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM DEPT";
		
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//4.쿼리실행 및 리턴
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.printf("%d %s %s\n", rs.getInt(1),rs.getString(2), rs.getString("LOC"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//5. 종료
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
