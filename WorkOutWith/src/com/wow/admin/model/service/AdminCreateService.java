package com.wow.admin.model.service;

import java.sql.Connection;
import java.util.List;

import com.wow.admin.model.dao.AdminDao;
import com.wow.admin.model.vo.AdminVo;
import static com.wow.common.JDBCTemplate.*;

public class AdminCreateService {
	

	
	
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

	
	//1-1. selectAdmin() 갖고오기????????? 유지보수를 위해????
	private AdminVo selectAdmin(Connection conn, AdminVo a) {
		return new AdminDao().selectAdmin(conn, a);
	}
	
}
