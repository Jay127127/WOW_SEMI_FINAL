package com.wow.board.service;

import static com.wow.common.JDBCTemplate.close;
import static com.wow.common.JDBCTemplate.commit;
import static com.wow.common.JDBCTemplate.getConnection;
import static com.wow.common.JDBCTemplate.rollback;

import java.io.PrintWriter;
import java.sql.Connection;

import com.wow.board.Dao.BoardDao;
import com.wow.board.Dao.EnquiryBoardDao;
import com.wow.board.model.vo.EnquiryBoardVo;

public class EnquiryBoardService {
	
	public int postingEnquiry(EnquiryBoardVo ev) {
		Connection conn = getConnection();
				
		//쿼리 날리기 //insert
		int result = 0;
		try {
			result = postingEnquiry(conn, ev);
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
	
	private int postingEnquiry(Connection conn, EnquiryBoardVo ev) {
		int result = new EnquiryBoardDao().insertEnquiryPost(conn, ev);
		return result;
	}
	
}
