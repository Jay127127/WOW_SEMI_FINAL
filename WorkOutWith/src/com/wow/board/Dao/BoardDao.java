package com.wow.board.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wow.board.model.vo.BoardVo;
import com.wow.common.JDBCTemplate;

import static com.wow.common.JDBCTemplate.*;

public class BoardDao {
 
//	=====================INSERT BOARD VALUES==============================
	public int insertBoard(Connection conn, BoardVo b) {
		String sql = "INSERT INTO BOARD"
				+ "(boardNo, boardCategory, boardTitle, userId, boardDate, boardContent,"
				+ "boardOpen_YN, boardDelete_YN)"
				+ "VALUES(SEQ_BOARD.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?, ?)";

		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBoardCategory());
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getUserId());  // 멤버 페이지에서 가져와야함.
			pstmt.setString(4, b.getBoardContent());
			pstmt.setString(5, b.getBoardOpen_YN());
			pstmt.setString(6, b.getBoardDelete_YN());
//			pstmt.setInt(7, b.getViewCount());
//			pstmt.setInt(8, b.getLikeCount());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
//	==========================(자유게시판) 게시글 숫자 세기================================
	public int countBoardAll(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(boardNo) FROM BOARD WHERE boardCategory ='board' and boardOpen_YN = 'Y'";
		
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}

//	=======================(자유게시판) 게시글 전체 가지고 오기=============================
	public List<BoardVo> selectBoardAll(Connection conn, int startNo, int endNo) {
		String sql = "SELECT * FROM ("
				+ "SELECT ROWNUM AS RNUM , b.* FROM BOARD b WHERE boardCategory ='board' and boardOpen_YN = 'Y') ORDER BY RNUM DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> list = new ArrayList<BoardVo>();
	
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			BoardVo selectedBoard = null;
			
			while(rs.next()) {
				int boardNo = rs.getInt("RNUM");
				String category = rs.getString("boardCategory");
				String boardTitle = rs.getString("boardTitle");
				String userId = rs.getString("userId");
				Date boardDate = rs.getDate("boardDate");
				String boardContent = rs.getString("boardContent");
				
				selectedBoard = new BoardVo();
				selectedBoard.setBoardNo(boardNo);
				selectedBoard.setBoardCategory(category);
				selectedBoard.setBoardTitle(boardTitle);
				selectedBoard.setUserId(userId);
				selectedBoard.setBoardDate(boardDate);
				selectedBoard.setBoardContent(boardContent);
				
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

//	=========================(자유게시판) 리스트 순서 찾기============================
	public List<BoardVo> selectBoardByType(Connection conn, String selectType) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM"
				+ "(SELECT ROWNUM AS RNUM, b.* FROM BOARD b WHERE boardCategory ='board' and boardOpen_YN = 'Y' order by RNUM desc)"
				+ "order by nlssort("+ selectType +", 'NLS_SORT=generic_m_ci') desc";
//		sql = String.format(sql, selectType);
		System.out.println("SQL :::" + sql);
		
		List<BoardVo> list = new ArrayList<BoardVo>(); 
		
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, selectType);
			
			BoardVo selectedBoard = null;
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int boardNo = rs.getInt("RNUM");
				String category = rs.getString("boardCategory");
				String boardTitle = rs.getString("boardTitle");
				String userId = rs.getString("userId");
				Date boardDate = rs.getDate("boardDate");
				String boardContent = rs.getString("boardContent");
				String boardOpen_YN = rs.getString("boardOpen_YN");
				String boardDelete_YN = rs.getString("boardDelete_YN");
				String viewCount = rs.getString("viewCount");
				String likeCount = rs.getString("likeCount");

				selectedBoard = new BoardVo();
				selectedBoard.setBoardNo(boardNo);
				selectedBoard.setBoardCategory(category);
				selectedBoard.setBoardTitle(boardTitle);
				selectedBoard.setUserId(userId);
				selectedBoard.setBoardDate(boardDate);
				selectedBoard.setBoardContent(boardContent);
				
				list.add(selectedBoard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

//	==========================(문의게시판) 게시글 숫자 세기================================
	public int countE_BoardAll(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(boardNo) FROM BOARD WHERE boardCategory ='enquiry' and boardOpen_YN = 'Y'";
		
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
	
//	=======================(문의게시판) 게시글 전체 가지고 오기=============================
	public List<BoardVo> selectE_BoardAll(Connection conn, int startNo, int endNo) {
		String sql = "SELECT * FROM ("
				+ "SELECT ROWNUM AS RNUM , b.* FROM BOARD b WHERE boardCategory ='enquiry' and boardOpen_YN = 'Y') ORDER BY RNUM DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> list = new ArrayList<BoardVo>();
	
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			BoardVo selectedBoard = null;
			
			while(rs.next()) {
				int boardNo = rs.getInt("RNUM");
				String category = rs.getString("boardCategory");
				String boardTitle = rs.getString("boardTitle");
				String userId = rs.getString("userId");
				Date boardDate = rs.getDate("boardDate");
				String boardContent = rs.getString("boardContent");
				
				selectedBoard = new BoardVo();
				selectedBoard.setBoardNo(boardNo);
				selectedBoard.setBoardCategory(category);
				selectedBoard.setBoardTitle(boardTitle);
				selectedBoard.setUserId(userId);
				selectedBoard.setBoardDate(boardDate);
				selectedBoard.setBoardContent(boardContent);
				
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


	public List<BoardVo> selectE_BoardByType(Connection conn, String selectType) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM"
				+ "(SELECT ROWNUM AS RNUM, b.* FROM BOARD b WHERE boardCategory ='enquiry' and boardOpen_YN = 'Y' order by RNUM desc)"
				+ "order by nlssort("+ selectType +", 'NLS_SORT=generic_m_ci') desc";
		
		System.out.println("SQL :::" + sql);
		
		List<BoardVo> list = new ArrayList<BoardVo>(); 
		
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, selectType);
			
			BoardVo selectedBoard = null;
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int boardNo = rs.getInt("RNUM");
				String category = rs.getString("boardCategory");
				String boardTitle = rs.getString("boardTitle");
				String userId = rs.getString("userId");
				Date boardDate = rs.getDate("boardDate");
				String boardContent = rs.getString("boardContent");
				
				selectedBoard = new BoardVo();
				selectedBoard.setBoardNo(boardNo);
				selectedBoard.setBoardCategory(category);
				selectedBoard.setBoardTitle(boardTitle);
				selectedBoard.setUserId(userId);
				selectedBoard.setBoardDate(boardDate);
				selectedBoard.setBoardContent(boardContent);
				
				list.add(selectedBoard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	
	
//	==========================(갤러리) 게시글 숫자 세기================================
	public int countG_BoardAll(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(boardNo) FROM BOARD WHERE boardCategory ='gallery' and boardOpen_YN = 'Y'";

		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}

//	========================(갤러리) 게시글 전체 가지고 오기=============================
	public List<BoardVo> selectG_BoardAll(Connection conn, int startNo, int endNo) {
		String sql = "SELECT * FROM ("
				+ "SELECT ROWNUM AS RNUM , b.* FROM BOARD b WHERE boardCategory ='gallery' and boardOpen_YN = 'Y') ORDER BY RNUM DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> list = new ArrayList<BoardVo>();
	
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			BoardVo selectedBoard = null;
			
			while(rs.next()) {
				int boardNo = rs.getInt("RNUM");
				String category = rs.getString("boardCategory");
				String boardTitle = rs.getString("boardTitle");
				String userId = rs.getString("userId");
				Date boardDate = rs.getDate("boardDate");
				String boardContent = rs.getString("boardContent");
				
				selectedBoard = new BoardVo();
				selectedBoard.setBoardNo(boardNo);
				selectedBoard.setBoardCategory(category);
				selectedBoard.setBoardTitle(boardTitle);
				selectedBoard.setUserId(userId);
				selectedBoard.setBoardDate(boardDate);
				selectedBoard.setBoardContent(boardContent);
				
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

//	==========================(갤러리) 리스트 순서 찾기================================
	public List<BoardVo> selectG_BoardByType(Connection conn, String selectType) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM"
				+ "(SELECT ROWNUM AS RNUM, b.* FROM BOARD b WHERE boardCategory ='gallery' and boardOpen_YN = 'Y' order by RNUM desc)"
				+ "order by nlssort("+ selectType +", 'NLS_SORT=generic_m_ci') desc";
//		sql = String.format(sql, selectType);
		System.out.println("SQL :::" + sql);
		
		List<BoardVo> list = new ArrayList<BoardVo>(); 
		
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, selectType);
			
			BoardVo selectedBoard = null;
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int boardNo = rs.getInt("RNUM");
				String category = rs.getString("boardCategory");
				String boardTitle = rs.getString("boardTitle");
				String userId = rs.getString("userId");
				Date boardDate = rs.getDate("boardDate");
				String boardContent = rs.getString("boardContent");
				
				selectedBoard = new BoardVo();
				selectedBoard.setBoardNo(boardNo);
				selectedBoard.setBoardCategory(category);
				selectedBoard.setBoardTitle(boardTitle);
				selectedBoard.setUserId(userId);
				selectedBoard.setBoardDate(boardDate);
				selectedBoard.setBoardContent(boardContent);
				
				list.add(selectedBoard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
//	===========================(루틴공유) 게시글 숫자 세기================================
	public int countR_BoardAll(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(boardNo) FROM BOARD WHERE boardCategory ='routine' and boardOpen_YN = 'Y'";
		
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}

//	==========================(루틴공유) 게시글 전체 가지고 오기=============================
	public List<BoardVo> selectR_BoardAll(Connection conn, int startNo, int endNo) {
		
		String sql = "SELECT * FROM ("
				+ "SELECT ROWNUM AS RNUM , b.* FROM BOARD b WHERE boardCategory ='routine' and boardOpen_YN = 'Y') ORDER BY RNUM DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> list = new ArrayList<BoardVo>();
	
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			BoardVo selectedBoard = null;
			
			while(rs.next()) {
				int boardNo = rs.getInt("RNUM");
				String category = rs.getString("boardCategory");
				String boardTitle = rs.getString("boardTitle");
				String userId = rs.getString("userId");
				Date boardDate = rs.getDate("boardDate");
				String boardContent = rs.getString("boardContent");
				
				selectedBoard = new BoardVo();
				selectedBoard.setBoardNo(boardNo);
				selectedBoard.setBoardCategory(category);
				selectedBoard.setBoardTitle(boardTitle);
				selectedBoard.setUserId(userId);
				selectedBoard.setBoardDate(boardDate);
				selectedBoard.setBoardContent(boardContent);
				
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

//	===========================(루틴공유) 리스트 순서 찾기================================
	public List<BoardVo> selectR_BoardAll(Connection conn, String selectType) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM"
				+ "(SELECT ROWNUM AS RNUM, b.* FROM BOARD b WHERE boardCategory ='routine' and boardOpen_YN = 'Y' order by RNUM desc)"
				+ "order by nlssort("+ selectType +", 'NLS_SORT=generic_m_ci') desc";
//		sql = String.format(sql, selectType);
		System.out.println("SQL :::" + sql);
		
		List<BoardVo> list = new ArrayList<BoardVo>(); 
		
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, selectType);
			
			BoardVo selectedBoard = null;
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int boardNo = rs.getInt("RNUM");
				String category = rs.getString("boardCategory");
				String boardTitle = rs.getString("boardTitle");
				String userId = rs.getString("userId");
				Date boardDate = rs.getDate("boardDate");
				String boardContent = rs.getString("boardContent");
				
				selectedBoard = new BoardVo();
				selectedBoard.setBoardNo(boardNo);
				selectedBoard.setBoardCategory(category);
				selectedBoard.setBoardTitle(boardTitle);
				selectedBoard.setUserId(userId);
				selectedBoard.setBoardDate(boardDate);
				selectedBoard.setBoardContent(boardContent);
				
				list.add(selectedBoard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
//	===========================(viewDetail)VIEW COUNT UPDATE================================

	public int boardViewUpdate(Connection conn, BoardVo b) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		String sql = "UPDATE BOARD SET viewCount=(SELECT IFNULL(MAX(viewCount)+1,0) FROM BOARD WHERE boardNo = ? WHERE boardNo = ?";
		
		System.out.println("sql: " +sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBoardNo());
			pstmt.setInt(2, b.getBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	


	

}



