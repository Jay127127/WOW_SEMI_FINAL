package com.wow.login.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import static com.wow.common.JDBCTemplate.*;

import com.wow.login.model.dao.MemberDao;
import com.wow.login.model.vo.MemberVo;

public class MemberService {

	public int join(MemberVo m) {
		
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
		
		if(selectedMember.getPwd().equals(m.getPwd())) {
			return selectedMember;
		}else {
			return null;
		}
	}
	
	public MemberVo selectMember(Connection conn, MemberVo m) {
		return new MemberDao().selectMember(conn, m);
	}

}
