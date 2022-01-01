package com.wow.admin.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.wow.admin.model.dao.AdminDao;
import com.wow.admin.model.vo.AdminVo;
import static com.wow.common.JDBCTemplate.*;

public class AdminCreateService {
	
	//2. admin 계정 생성
	public int create(AdminVo a) {
			
		//DB Connection 가져오기
		Connection conn = getConnection();
			
		//쿼리 날리기, insert!!!
		int result = 0;
		
		try {
			result = insertAdmin(conn, a);
			
			//계정이 생성됐으면
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
		} catch (Exception e) {
			System.out.println("계정생성에 오류생김!!");
		} finally {
			close(conn);
		}
			
		return result;
	}


	//2-1. 유지보수를 위해.. AdminDao().insertAdmin() 을 오버로딩
	private int insertAdmin(Connection conn, AdminVo a) throws SQLException {
		//dao 불러서 쿼리 실행
		//dao한테 쿼리 실행 결과 받기
		//throws로 캐치블럭 없음
		int result = new AdminDao().insertAdmin(conn, a);
		//계정생성되면 result==1
		return result;
	}
	
	//1. admin 로그인
	public AdminVo adLogin(AdminVo a) {
		//커넥션 가져오기(디비 가져오기?)
		Connection conn = getConnection();
		
		//1-1. admin_id로 그 아이디의 비번 조회
		AdminVo selectedAdmin = selectAdmin(conn, a);
		
		close(conn);
		
		//가져온 pwd와 사용자가 입력한 pwd가 같은지 비교, 같으면
		if(selectedAdmin.getAdmin_pwd().equals(a.getAdmin_pwd()))
			//결과 리턴
			return selectedAdmin;
		else
			return null;
	}

	
	//1-1. selectAdmin() 갖고오기?? 유지보수를 위해??
	private AdminVo selectAdmin(Connection conn, AdminVo a) {
		return new AdminDao().selectAdmin(conn, a);
	}

	
	//3. admin아이디 중복 체크
	public int dupCheck(String id) {
		Connection conn = getConnection();
		int result = selectAdminById(conn, id);
		
		close(conn);
		return result;
	}


	//3-1. selectAdminById() 갖고오기
	private int selectAdminById(Connection conn, String id) {
		return new AdminDao().selectAdminById(conn, id);
	}
	

	
}
