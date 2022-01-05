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
				"INSERT INTO MEMBER(MEMBER_NUM, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, MEMBER_GENDER, MEMBER_ADDRESS, MEMBER_EMAIL, MEMBER_NIK, PWD_NUM, PWD_ANSWER, QNA_1, QNA_2, QNA_3, QNA_4, QNA_5) "
				+ "VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getNick());
			pstmt.setInt(8, m.getQuestion_num());
			pstmt.setString(9, m.getQuestion_answer());
			pstmt.setString(10, m.getQna1());
			pstmt.setString(11, m.getQna2());
			pstmt.setString(12, m.getQna3());
			pstmt.setString(13, m.getQna4());
			pstmt.setString(14, m.getQna5());
			
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

	public int selectMemberById(Connection conn, String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	public MemberVo searchPwd(Connection conn, MemberVo m) {
String query = "SELECT * FROM MEMBER WHERE MEMBER_EMAIL = ? AND MEMBER_OUT = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo pwdSearch = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getEmail());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int memberNum = rs.getInt("MEMBER_NUM");
				String id = rs.getString("MEMBER_ID");
				String pwd = rs.getString("MEMBER_PWD");
				String name = rs.getString("MEMBER_NAME");
				String address = rs.getString("MEMBER_ADDRESS");
				String email = rs.getString("MEMBER_EMAIL");
				String nickname = rs.getString("MEMBER_NIK");
				int pwd_num = rs.getInt("PWD_NUM");
				String pwd_answer = rs.getString("PWD_ANSWER");
				
				pwdSearch = new MemberVo();
				pwdSearch.setNum(memberNum);
				pwdSearch.setId(id);
				pwdSearch.setPwd(pwd);
				pwdSearch.setName(name);
				pwdSearch.setAddress(address);
				pwdSearch.setEmail(email);
				pwdSearch.setNick(nickname);
				pwdSearch.setQuestion_num(pwd_num);
				pwdSearch.setQuestion_answer(pwd_answer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return pwdSearch;
	}
}
