package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest03 {

	public static void main(String[] args) throws SQLException {
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";
		
		try {
			con = DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Statement stmt = null;
		int res = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("번호: ");
		int mno = sc.nextInt();
		System.out.println("이름: ");
		String mname = sc.next();
		System.out.println("별명: ");
		String mnickname = sc.next();
		
		String sql = "INSERT INTO MYTEST VALUES("+mno+ ", '"+mname+"', '"+mnickname+"')";
		
		
		stmt = con.createStatement();
		//적용된 로우의 갯수가 리턴된다.
		res = stmt.executeUpdate(sql);
		
		if(res >0 ) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
		
		stmt.close();
		con.close();
		
	}

}
