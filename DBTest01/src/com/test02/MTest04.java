package com.test02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MTest04 {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";
		
		
		
		try {
			con = DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		PreparedStatement pstmt = null;
		int res =0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("번호: ");
		int mno = sc.nextInt();
		System.out.println("변경할 이름: ");
		String mname = sc.next();
		System.out.println("변경할 별명: ");
		String mnickname = sc.next();
		
		System.out.println(mno+"---"+mname+"---"+mnickname);
		
		String sql = "UPDATE MYTEST SET MNAME=?, NICKNAME=? WHERE MNO=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mname);
			pstmt.setString(2, mnickname);
			pstmt.setInt(3, mno);
			
			res = pstmt.executeUpdate();
			
			if(res>0 ) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		try {
			pstmt.close();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
