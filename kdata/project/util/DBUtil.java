package kdata.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	private static final String CON_URL = "jdbc:oracle:thin:@localhost:1521";
	private static final String USER_NAME = "test";
	private static final String USER_PWD = "1234";
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	static {
		try { // 메소드가 아니여서 throws안 씀
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 데이터베이스 서버 연결하는 메소드 => 생성자는 반환안하기 때문에 메소드getConnection() 생성
	/**
	 * 
	 * @return Connection '데이터베이스 연결정보' 객체 반환
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(CON_URL, USER_NAME, USER_PWD);
	}

	/**
	 * 데이터 베이스 연결시 사용한 자원 해제
	 * 
	 */

	public static void close(PreparedStatement pstmt, Connection con) {
		if (pstmt != null)
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		if (pstmt != null)
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}