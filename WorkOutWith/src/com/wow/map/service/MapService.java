package com.wow.map.service;

import java.sql.Connection;
import java.sql.SQLException;

import static com.wow.common.JDBCTemplate.*;

import com.wow.map.dao.MapDao;
import com.wow.map.model.vo.MapModelVo;

public class MapService {
	
	public int join(MapModelVo m) {
		
		//DB Connection 가져오기
		Connection conn = getConnection();
		
		//쿼리 날리기 //insert쿼리 날리기
		int result =0;
		try {
			result = insertMember(conn,m);
			if(result>0)
				commit(conn);
			else
				rollback(conn);
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			close(conn);
		}
		//결과 반환해주기
		
		return result;	
	}
	
	public int insertMember(Connection conn, MapModelVo m) throws SQLException {
		//dao 불러서 쿼리 날려주고 쿼리 실행해주고
		//dao 한테 쿼리 샐행 결과 받아서, 비지니스 로직 처리
		return new MapDao().insertMember(conn,m);
		
	}


}
