package com.wow.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wow.admin.model.vo.UserVo;
import static com.wow.common.JDBCTemplate.*;

public class UserDao {

	
	//5-1. 모든 유저 조회, 모든 유저를 담은 list 반환
	public List<UserVo> selectUserAll(Connection conn, int startNo, int endNo) {
		String sql = "SELECT * "
				+ "FROM "
				+ "( "
				+ "SELECT ROWNUM AS RNUM, m.*  "
				+ "FROM ( "
				+ "SELECT * FROM MEMBER "
				+ "ORDER BY MEMBER_NUM ASC) m "
				+ ") "
				+ "WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVo> list = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			UserVo selectedUser = null;
			list = new ArrayList<UserVo>();
			
			while(rs.next()) {
				int rNum = rs.getInt("RNUM");
				int member_num = rs.getInt("MEMBER_NUM");
				String member_id = rs.getString("MEMBER_ID");
				String member_name = rs.getString("MEMBER_NAME");
				String member_gender = rs.getString("MEMBER_GENDER");
				String member_address = rs.getString("MEMBER_ADDRESS");
				String member_email = rs.getString("MEMBER_EMAIL");
				String member_nik = rs.getString("MEMBER_NIK");
				
				//만들고
				selectedUser = new UserVo();
				selectedUser.setrNum(rNum);
				selectedUser.setMember_num(member_num);
				selectedUser.setMember_id(member_id);
				selectedUser.setMember_name(member_name);
				selectedUser.setMember_gender(member_gender);
				selectedUser.setMember_address(member_address);
				selectedUser.setMember_email(member_email);
				selectedUser.setMember_nik(member_nik);
				
				//담아주고
				list.add(selectedUser);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	//5-1. 유저 총 인원 세기
	public int countUserAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT (MEMBER_NUM) FROM MEMBER";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}		
		return result;
	}
	
	//5-2. 타입별조회(예: 아이디, 이름...)해서 모든 유저 찾아오기
	public List<UserVo> selectUserBySearch(Connection conn, String type, String value, int startNo, int endNo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String sql = "SELECT a.*, ap.admin_power_name "
//				+ "FROM admin a "
//				+ "LEFT JOIN admin_power ap ON(a.admin_power_code = ap.admin_power_code) "
//				+ "WHERE %s LIKE ?";
		String sql = "SELECT * "
				+ "FROM "
				+ "( "
				+ "SELECT ROWNUM AS RNUM, m.*  "
				+ "FROM ( "
				+ "SELECT * FROM MEMBER "
				+ "WHERE %s LIKE ? "
				+ "ORDER BY %s ASC) m "
				+ ") "
				+ "WHERE RNUM BETWEEN ? AND ?";
		sql = String.format(sql, type, type);
		//%s : 타입
//		type 여러개 넣을 수 있다.
//		System.out.println("sql: "+sql);
		
		List<UserVo> list = null;
		list = new ArrayList<UserVo>();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+value+"%");
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			System.out.println("sql: "+sql);
			
			UserVo selectedUser = null;
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rNum = rs.getInt("RNUM");
				int member_num = rs.getInt("MEMBER_NUM");
				String member_id = rs.getString("MEMBER_ID");
				String member_name = rs.getString("MEMBER_NAME");
				String member_gender = rs.getString("MEMBER_GENDER");
				String member_address = rs.getString("MEMBER_ADDRESS");
				String member_email = rs.getString("MEMBER_EMAIL");
				String member_nik = rs.getString("MEMBER_NIK");
				
				//만들고
				selectedUser = new UserVo();
				selectedUser.setrNum(rNum);
				selectedUser.setMember_num(member_num);
				selectedUser.setMember_id(member_id);
				selectedUser.setMember_name(member_name);
				selectedUser.setMember_gender(member_gender);
				selectedUser.setMember_address(member_address);
				selectedUser.setMember_email(member_email);
				selectedUser.setMember_nik(member_nik);
				
				//담아주고
				list.add(selectedUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//5-2. 탐색별조회 시 유저 총 인원 세기
	public int countSearchAll(Connection conn, String type, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) "
				+ "FROM "
				+ "( "
				+ "SELECT ROWNUM AS RNUM, m.* "
				+ "FROM (SELECT * FROM MEMBER  "
				+ "WHERE %s LIKE ? "
				+ "ORDER BY %s ASC) m "
				+ ") ";
		sql = String.format(sql, type, type);
		int result = 0;
		System.out.println("sql: "+sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+value+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}		
//		System.out.println("탐색별조회시 총 인원: "+result);
		return result;
	}	
	
	
	//6. 유저 계정 삭제
	public int deleteUser(Connection conn, String member_id) {
		String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			result = pstmt.executeUpdate();
			//업뎃된 행의 개수?
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	

	
 
}
