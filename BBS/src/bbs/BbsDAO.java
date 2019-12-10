package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {
	private Connection conn;
	private ResultSet rs;
	private String driver = "oracle.jdbc.driver.OracleDriver";

	public BbsDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbID = "kh";
			String dbPassword = "kh";
			Class.forName(driver);
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("생성!!!!!!!!!!!!!!!!");
	}

	public String getDate() {
		String SQL = "SELECT to_char(sysdate,'yyyymmddhh24') from dual";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// System.out.println(rs.getString(1) instanceof String);
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public int getNext() {
		String SQL = "SELECT bbsID FROM BBSS ORDER BY bbsID DESC";

		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int write(String bbsTitle, String userID, String bbsContent) {
		String sql = "INSERT INTO BBSS VALUES(?,?,?,sysdate,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, userID);
			// pstmt.setString(4, getDate());
			pstmt.setString(4, bbsContent);
			pstmt.setInt(5, 1);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public ArrayList<Bbs> getList(int pageNumber) {
//		String SQL = "SELECT * FROM BBSS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC  ROWNUM <=10";
		System.out.println("페이지 넘버!!!!!!!!!!!!! ->" + pageNumber);
		//String SQL = "SELECT * FROM (SELECT * FROM BBSS WHERE bbsID < ? AND bbsAvailable =1) WHERE rownum <=10 ";
		String SQL = "SELECT * FROM BBSS WHERE bbsID <= ? AND bbsID >= ? AND bbsAvailable =1";
		// bbsID가 ? 보다 작고 Available가 1일때
		ArrayList<Bbs> list = new ArrayList<Bbs>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
//			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			
			pstmt.setInt(1, ((pageNumber) * 10) );
			pstmt.setInt(2, (1+(pageNumber -1)*10));
			
			// 10깨자 쿼리문으로 제한 걸어 두고 여기서 저장된 게시물의 겟수를 계산하여 출력

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Bbs bbs = new Bbs();

				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));

				list.add(bbs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int cnt=0;
		System.out.println("================bbsDAO에서 게싶판글 긁어왓다잉!");
		for(Bbs b : list) {
			cnt++;
			System.out.print(cnt+"-> ");
			System.out.print(b.getBbsID() + " ");
			System.out.print(b.getBbsTitle()+ " ");
			System.out.print(b.getUserID()+ " ");
			System.out.println();
			
		}
		return list;

	}

	// 10단위 페이징 처리 위해.... 특정페이지(마지막페이지)가 존재하는지 확인..하는...
	public boolean nextPage(int pageNumber) {
		String SQL = "SELECT * FROM BBSS WHERE bbsID < ? AND bbsAvailable =1";

		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);

			rs = pstmt.executeQuery();
			
			//결과가 하나라도 존재한다면 트루를 리턴
			if(rs.next()) {
				return true;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Bbs getBbs(int bbsID) {
		//Bbs 객체를 생성해서 db에 있는 데이터를 담아서 전달한다. 리턴한다.
		String SQL = "SELECT * FROM BBSS WHERE bbsID = ? ";

		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);

			rs = pstmt.executeQuery();
			
			//결과가 하나라도 존재한다면 트루를 리턴
			if(rs.next()) {
				Bbs bbs = new Bbs();
				
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				
				System.out.println("content!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println(bbs.getBbsContent());
				
				return bbs;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(int bbsID, String bbsTitle, String bbsContent) {
		String sql = "UPDATE BBSS SET bbsTitle = ?, bbsContent =? WHERE bbsID = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bbsTitle);
			pstmt.setString(2, bbsContent);
			pstmt.setInt(3, bbsID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
	
	public int delete(int bbsID) {
		String sql = "UPDATE BBSS SET bbsAvailable=0 WHERE bbsID = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbsID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
	

}
