package com.wow.login.model.dao;

import static com.wow.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wow.common.JDBCTemplate;
import com.wow.login.model.vo.MemberVo;

public class MemberDao {

	public int insertMember(Connection conn, MemberVo m) throws SQLException {
		//쿼리 날리기
		String sql =
				"INSERT INTO MEMBER(MEMBER_NUM, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, MEMBER_ADDRESS, MEMBER_EMAIL, MEMBER_NIK) "
				+ "VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getNick());
			
			result = pstmt.executeUpdate();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public MemberVo selectMember(Connection conn, MemberVo m) {
		
		String query = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_OUT = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo selectedMember = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getId());
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int memberNum = rs.getInt("MEMBER_NUM");
				String id = rs.getString("MEMBER_ID");
				String pwd = rs.getString("MEMBER_PWD");
				String name = rs.getString("MEMBER_NAME");
				String address = rs.getString("MEMBER_ADDRESS");
				String email = rs.getString("MEMBER_EMAIL");
				String nickname = rs.getString("MEMBER_NIK");
				
				selectedMember = new MemberVo();
				selectedMember.setNum(memberNum);
				selectedMember.setId(id);
				selectedMember.setPwd(pwd);
				selectedMember.setName(name);
				selectedMember.setAddress(address);
				selectedMember.setEmail(email);
				selectedMember.setNick(nickname);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return selectedMember;
	}

}
