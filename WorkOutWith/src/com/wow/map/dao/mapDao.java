package com.wow.map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wow.common.JDBCTemplate;
import com.wow.map.model.vo.MapModelVo;

public class MapDao {
	
	public int insertMember(Connection conn, MapModelVo m) throws SQLException {
		//쿼리 날리기
		
		String sql="INSERT INTO board_test(BOARD_NU, ID, PWD, NAME, DETAIL, ENROLL_DATE) "
				+ "VALUES (SEQ_BOARD.NEXTVAL , ?, ?, ?, ?, SYSDATE)";

		
		PreparedStatement pstmt = null;
		int result =0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setInt(4, -1);
			
			result = pstmt.executeUpdate();
		}finally {
			JDBCTemplate.close(pstmt);	
		}
		
		
		
		return result;
	}
	

}
