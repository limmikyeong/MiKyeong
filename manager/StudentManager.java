package kdata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {

static Scanner sc = new Scanner(System.in);
	
	//학생정보추가 => 각 메소드 마다 con생성하고 close()하는게 좋다(과부화 방지)
	public static int insert(Student s) throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try{
		//2. 데이터 데이스 연결
		con = DBUtil.getConnection();
		
		//3, 4
		//?를 먼저 값과 셋팅해줘야함.
		String sql = "insert into student values(?,?,?)";
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1,s.getSnum());
		pstmt.setString(2,s.getSname());
		pstmt.setString(3,s.getSgender());
		
		//5.
		result = pstmt.executeUpdate();
		
		return result;
		//6. 예외발생하든말든 close되야 함 => finally
		}finally{
		DBUtil.close(pstmt,con);
		}
	}
	//학생 리스트 출력
	public List<Student> selectAll() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Student> list = new ArrayList<>();
		
		try{
			con = DBUtil.getConnection();
		
			String sql = "select *"
				+ " from Student "
				+ " order by sname";
			pstmt = con.prepareStatement(sql);
		
			rs = pstmt.executeQuery();
		
		//행 갯수만큼 추가(반복문)
		while(rs.next()){
			String snum;
			String sname;
			String sgender;
			Student s= new Student(rs.getString("snum"),rs.getString("sname"),rs.getString("sgender"));
			
			//오버라이드한 toString 출력
			//System.out.println(s);
			list.add(s);
		}
		
		}finally {
			DBUtil.close(rs,pstmt,con);
		}
		return list;
		
	}
	
	public Student selectByName(String sname) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Student student = null;
		
		try {
			con = DBUtil.getConnection();
			String sql = "select *  from student where sname = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,sname);
			rs = pstmt.executeQuery();
			//System.out.println(s.getSname());
			
			if(rs.next()){
				student = new Student(rs.getString("snum"), rs.getString("sname"), rs.getString("sgender"));
				
			}
			return student;
		}finally{
			DBUtil.close(rs,pstmt,con);
			
		}

	}
}
