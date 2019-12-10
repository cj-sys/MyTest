package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//회원 DB에접근할수 잇게 데이터베이스 접근 객체의 약자
//DB에 회원정보 불러오거나 넣을때 사용
//data 접근 객체
public class UserDAO {
	
	//db에 접긴하기 위한 객체...
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	public UserDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbID = "kh";
			String dbPassword = "kh";
			Class.forName(driver);
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String userID, String userPassword) {
		
		String sql = "SELECT userPassword FROM BBS WHERE userID = ?";
		System.out.println(userID);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			//매개변수로 넘어오는 id를 위에 sql문의 ?에 넣는다... 들어갈수 잇게 해줘서 실제 db에는 id 입력받아서 
			//실제로 존재하는지 .. 존재한다면 비번이 뭔지 가져오도록 한다.
			rs= pstmt.executeQuery();
			//결과 객체에 쿼리문 실행후 결과를 넣는다.
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1;// 로그인 성공,,,, 비번깥지 같다면.
				} else {
					return 0;// 비밀번호가 다르다..... 아이디는 같으나...
				}
			}
			return -1; 	// 아이디가 없다면 if를 뛰어 넣어서 리턴을 한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -2;	//db오류를 말한다.. -2라는것은...
	}
	
	//
	public int join(User user) {
		String sql = "INSERT INTO BBS VALUES (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			return pstmt.executeUpdate();
			//성공하면 0이상의 숫자가 반환 되기때문에 실패한것이 아니다라는걸 알수 잇다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
