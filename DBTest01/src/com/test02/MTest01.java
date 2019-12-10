package com.test02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MTest01 {

	public static void main(String[] args) throws SQLException {
		
		//1.Driver연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		//2.계정연결
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		//3.쿼리준비
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMP";
		
		stmt = con.createStatement();
		
		//4.쿼리실행 및 리턴
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.printf("%d %s %s %d %s %d %.2f %d\n\n", rs.getInt(1), rs.getString(2), rs.getString("JOB"),rs.getInt("MGR"), 
					rs.getString(5),rs.getInt(6), rs.getDouble("COMM"), rs.getInt(8));
		}
		
		
		
		//5.디비종료
		rs.close();
		stmt.close();
		con.close();
		
		
	}

}
