package cmp.DB;

import java.sql.*;
import cmp.DB.DBConnectionMgr;


public class DBMgr {
	private DBConnectionMgr pool;
	
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	String sql2 = null;
	
	public DBMgr() {
		try {
			pool = DBConnectionMgr.getInstance();
			System.out.println("연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 직원 로그인
	public boolean EmployeeLoginCheck(String id, String pw) {
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select em_pw from employee where em_id = ? and em_pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(pw.equals(rs.getString("em_pw"))) {
					flag = true;
				}
				else {
					flag = false;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs); //con는 반납, pstmt/rs는 close
		}
		
		return flag;
	}
	
	//직원 회원가입
	public void signupEmployee(EmployeeBean bean) {
		try {
			con = pool.getConnection();
			sql = "insert into employee(em_id, em_pw, em_name, em_birthday, em_phone, em_position, em_department) values (?,?,?,?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPw());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getBirthday());
			pstmt.setString(5, bean.getPhone());
			pstmt.setString(6, bean.getPosition());
			pstmt.setString(7, bean.getDepartment());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 알바 로그인
	public boolean AlbaLoginCheck(String id, String pw) {
		boolean flag = false;
		try {
			sql = "select alba_pw from employee where alba_id = ? and alba_pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(pw.equals(rs.getString("alba_pw"))) {
					flag = true;
				}
				else {
					flag = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs); //con는 반납, pstmt/rs는 close
		}
		return flag;
	}
}
