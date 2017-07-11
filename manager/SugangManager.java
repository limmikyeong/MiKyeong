package kdata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SugangManager {

	

	public static void insert(Sugang sg) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			String sql = "insert into sugang values(?,?,?,default)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sg.getSnum());
			pstmt.setString(2, sg.getSubcode());
			pstmt.setString(3, null);
			//pstmt.setDate(4, sg.getDate());
			pstmt.executeUpdate();
		}

		finally {
			DBUtil.close(pstmt, con);

		}

	}

	//학번, 이름, 과목명
	public static List<Sugang> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Sugang> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			String sql = "select student.snum,student.sname,subname " + 
					"from sugang inner join student on sugang.snum = student.snum "+ 
					"inner join subject on sugang.subcode = subject.subcode ";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Sugang sg = new Sugang(rs.getString("snum"), rs.getString("sname"), rs.getString("subname"));
				list.add(sg);

			}

		}

		finally {
			DBUtil.close(rs, pst, con);

		}
		return list;

	}

	public static void delete(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = DBUtil.getConnection();
			String sql = "delete from sugang where snum=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
		}

		finally {
			DBUtil.close(pst, con);

		}

	}

	public static void gradeUpdate(int grade, String ids, String subnum) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = DBUtil.getConnection();
			String sql = "update sugang set grade=? where snum=? and subcode=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, grade);
			pst.setString(2, ids);
			pst.setString(3, subnum);
			pst.executeUpdate();
		}

		finally {
			DBUtil.close(pst, con);

		}

	}

}
