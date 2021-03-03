// 회원에 관한 데이터베이스 처리 기능을 전담하는 DAO 모델 객체

package com.dev.dao;

import java.sql.*;
import com.dev.vo.MemberVO;

public class MemberDAO {

	private static MemberDAO dao = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		return dao;
	}

	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (Exception ex) {
			System.out.println("오류발생 : " + ex);
		}
		return conn;
	}

	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
				System.out.println("오류발생 : " + ex);
			}
		}
		close(conn, ps);
	}

	public void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ex) {
				System.out.println("오류발생 : " + ex);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println("오류발생 : " + ex);
			}
		}
	}

	public void memberInsert(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMail());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt);
		}
	}

}
