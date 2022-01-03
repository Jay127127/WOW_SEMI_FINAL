package com.wow.login.model.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import static com.wow.common.JDBCTemplate.*;

import com.wow.login.model.dao.MemberDao;
import com.wow.login.model.vo.MemberVo;

public class MemberService {
	
	private String encrypt(String pwd) {
		// 패스워드 암호화
			StringBuilder sb = new StringBuilder();
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-512");
				md.update(pwd.getBytes());
				byte[] digest = md.digest();
				for(byte b : digest) {
					sb.append(String.format("%02x", b));
				}
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
		return sb.toString();
	}

	public int join(MemberVo m) {
		// 암호화
		m.setPwd(encrypt(m.getPwd()));
		
		// 커넥션 가져오기
		Connection conn = getConnection();
		
		// 쿼리 날리기 // insert
		int result = 0;
		try {
			result = insertMember(conn, m);
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
		} catch (SQLException e) {
 			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		//결과 반환해주기
		return result;
	}
	
	public int insertMember(Connection conn, MemberVo m) throws SQLException {
		//dao를 불러 쿼리 보낸후 결과 받기
		return new MemberDao().insertMember(conn, m);
	}

	public MemberVo login(MemberVo m) {
		// 커넥션 가져오기
		Connection conn = getConnection();
		
		// id 가지고 그 아이디의 비번 조회 // select
		MemberVo selectedMember = selectMember(conn, m);
		
		close(conn);
		
		if(selectedMember.getPwd().equals(encrypt(m.getPwd()))) {
			return selectedMember;
		}else {
			return null;
		}
	}
	
	public MemberVo selectMember(Connection conn, MemberVo m) {
		return new MemberDao().selectMember(conn, m);
	}

	public int dupCheck(String id) {
		Connection conn = getConnection();
		int result = selectMemberById(conn, id);
		close(conn);
		return result;
	}

	private int selectMemberById(Connection conn, String id) {
		return new MemberDao().selectMemberById(conn, id);
	}

	public MemberVo login(String name) {
		// 커넥션 가져오기
		Connection conn = getConnection();
		
		// name 가지고 그 이름의 이메일 조회 // select
		MemberVo selectedMember = selectMember(conn, name);
		
		close(conn);
		return selectedMember;
	}

	private MemberVo selectMember(Connection conn, String name) {
		return new MemberDao().selectMember(conn, name);
	}

}
