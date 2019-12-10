package com.test01;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MTest04 {
	public static void main(String[] args) {
		
		Connection con  = getConnection();
		
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("번호: ");
		int mno = sc.nextInt();
		System.out.println("변경할 이름: ");
		String mname = sc.next();
		System.out.println("변경할 별명: ");
		String mnickname = sc.next();
		
		
		int res =0;
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
		
		
		close(pstmt);
		close(con);

	}
}
