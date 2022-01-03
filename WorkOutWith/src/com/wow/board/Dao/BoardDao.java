package com.wow.board.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wow.board.model.vo.BoardVo;
import com.wow.board.model.vo.EnquiryBoardVo;

import static com.wow.common.JDBCTemplate.*;

public class BoardDao {

	public int insertPost(Connection conn, BoardVo b) {
		String sql = "INSERT INTO BOARD (boardNo, boardCategory, boardTitle, userId, boardDate, boardContent)"
				+ "VALUES(SEQ_BOARD.NEXTVAL, ?, ?, ?, SYSDATE, ?)";

		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getCategory_select());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, "userId");  // 멤버 페이지에서 가져와야함.
			pstmt.setString(4, b.getText_area());
//			pstmt.setString(4, b.getBoardAvailable());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
//	===========insert문 완료=================================================
	
	
//	===========selecAll문 시작===============================================
	public List<BoardVo> selectMemberAll(Connection conn, int startNo, int endNo){
		String sql = "SELECT * FROM BOARD";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> list = new ArrayList<BoardVo>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			BoardVo selectedBoard = null;
			
			
			while(rs.next()) {
				int boardNo = rs.getInt("boardNo");
				String category = rs.getString("boardCategory");
				String title = rs.getString("boardTitle");
				String userId = rs.getString("userId");
				Timestamp boardDate = rs.getTimestamp("boardDate");
				String boardContent = rs.getString("boardContent");
				
				selectedBoard = new BoardVo();
				selectedBoard.setBoardNo(boardNo);
				selectedBoard.setCategory_select(category);
				selectedBoard.setTitle(title);
				selectedBoard.setUserId(userId);
				selectedBoard.setBoardDate(boardDate);
				
				list.add(selectedBoard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
}



