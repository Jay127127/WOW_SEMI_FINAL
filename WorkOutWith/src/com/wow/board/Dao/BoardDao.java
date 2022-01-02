package com.wow.board.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.wow.board.model.vo.BoardVo;
import static com.wow.common.JDBCTemplate.*;

public class BoardDao {

	public int insertPost(Connection conn, BoardVo b) {
		String sql = "INSERT INTO BOARD (BOARD_NUM, CATEGORY, BOARD_TITLE, WRITER, BOARD_CONTENT, SECRET, BOARD_DATE)"
				+ "VALUES(SEQ_BOARD.NEXTVAL, ?, ?, WRITER, ?, ?,SYSDATE)";

		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getCategory_select());
			pstmt.setString(2, b.getTitle());
//			pstmt.setString(3, m.getName());  // 멤버 페이지에서 가져와야함.
			pstmt.setString(3, b.getText_area());
			pstmt.setString(4, b.getSecret());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}



