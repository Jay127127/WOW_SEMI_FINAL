package com.wow.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.wow.board.Dao.BoardDao;
import com.wow.board.model.vo.BoardVo;
import static com.wow.common.JDBCTemplate.*;

public class NewPostService {

	public int post(BoardVo b) throws SQLException {
		//DB Connection 가져오기
		Connection conn = getConnection();
		
		//쿼리 날리기 //insert
		int result = 0;
		try {
			result = postBoard(conn, b);
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
		} finally {
			close(conn);
		}
		//결과 반환해주기
		return result;
	}

	private int postBoard(Connection conn, BoardVo b) {
		int result = new BoardDao().insertPost(conn, b);
		return result;
	}

	public List<BoardVo> search(String type, String value, String currentPage) {
		
		return null;
	}



}



