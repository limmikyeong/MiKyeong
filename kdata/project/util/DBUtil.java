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
		try { // �޼ҵ尡 �ƴϿ��� throws�� ��
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// �����ͺ��̽� ���� �����ϴ� �޼ҵ� => �����ڴ� ��ȯ���ϱ� ������ �޼ҵ�getConnection() ����
	/**
	 * 
	 * @return Connection '�����ͺ��̽� ��������' ��ü ��ȯ
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(CON_URL, USER_NAME, USER_PWD);
	}

	/**
	 * ������ ���̽� ����� ����� �ڿ� ����
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