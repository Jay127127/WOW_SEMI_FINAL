package com.wow.admin.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wow.admin.model.vo.AdminVo;
import com.wow.admin.model.vo.BoardVo;
import com.wow.admin.model.vo.UserVo;
import com.wow.common.JDBCTemplate;

import static com.wow.common.JDBCTemplate.*;

public class AdBoardDao {
 


//	==========================(문의게시판) +처리함!! 게시글 숫자 세기================================
	public int countE_BoardAll(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(boardNo) FROM BOARD WHERE boardCategory ='enquiry' and boardOpen_YN = 'Y' and dealEnq = 'Y'";
		
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
		System.out.println("처리함+게시글수:"+result);
		return result;
	}
	
//	==========================(문의게시판) 게시글 +처리안함** 숫자 세기================================
	public int countNoE_BoardAll(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(boardNo) FROM BOARD WHERE boardCategory ='enquiry' and boardOpen_YN = 'Y' and dealEnq = 'N'";
		
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
		System.out.println("처리노+게시글수:"+result);
		return result;
	}
	
	
//	==============================탐색별조회 시+처리함!! 문의게시판 게시글 개수 세기===============
	public int countSearchAll(Connection conn, String type, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) "
				+ "FROM "
				+ "( "
				+ "SELECT ROWNUM AS RNUM, b.* "
				+ "FROM (SELECT * FROM BOARD "
				+ "WHERE boardCategory ='enquiry' and boardOpen_YN = 'Y' and %s LIKE ? and dealEnq = 'Y') b) ";
		
		sql = String.format(sql, type);
		int result = 0;
		System.out.println("sql: "+sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+value+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}		
//		System.out.println("탐색별조회시 총 인원: "+result);
		return result;
	}	
	
//	==============================탐색별조회 시 +처리안함** 문의게시판 게시글 개수 세기===============
	public int countNoSearchAll(Connection conn, String type, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) "
				+ "FROM "
				+ "( "
				+ "SELECT ROWNUM AS RNUM, b.* "
				+ "FROM (SELECT * FROM BOARD "
				+ "WHERE boardCategory ='enquiry' and boardOpen_YN = 'Y' and %s LIKE ? and dealEnq = 'N') b) ";
		
		sql = String.format(sql, type);
		int result = 0;
		System.out.println("sql: "+sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+value+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}		
//		System.out.println("탐색별조회시 총 인원: "+result);
		return result;
	}	
	
	
	
//	=======================(문의게시판) 게시글 전체 +처리함!! 가지고 오기=============================
	public List<BoardVo> selectE_BoardAll(Connection conn, int startNo, int endNo) {
		String sql = "SELECT * FROM "
				+ "("
				+ "SELECT ROWNUM AS RNUM , b.* "
				+ "FROM BOARD b "
				+ "WHERE boardCategory ='enquiry' and boardOpen_YN = 'Y' and dealEnq = 'Y')  "
				+ "WHERE RNUM BETWEEN ? AND ? "	
				+ "ORDER BY RNUM DESC ";
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
				int rNum = rs.getInt("RNUM");
				int boardNo = rs.getInt("boardNo");
				String category = rs.getString("boardCategory");
				String boardTitle = rs.getString("boardTitle");
				String userId = rs.getString("userId");
				Date boardDate = rs.getDate("boardDate");
				String boardContent = rs.getString("boardContent");
				String dealEnq = rs.getString("dealEnq");
				
				selectedBoard = new BoardVo();
				selectedBoard.setrNum(rNum);
				selectedBoard.setBoardNo(boardNo);
				selectedBoard.setBoardCategory(category);
				selectedBoard.setBoardTitle(boardTitle);
				selectedBoard.setUserId(userId);
				selectedBoard.setBoardDate(boardDate);
				selectedBoard.setBoardContent(boardContent);
				selectedBoard.setDealEnq(dealEnq);
				
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
	
//	=======================(문의게시판) 게시글 전체+처리안함** 가지고 오기=============================
	public List<BoardVo> selectNoE_BoardAll(Connection conn, int startNo, int endNo) {
		String sql = "SELECT * FROM "
				+ "("
				+ "SELECT ROWNUM AS RNUM , b.* "
				+ "FROM BOARD b "
				+ "WHERE boardCategory ='enquiry' and boardOpen_YN = 'Y' and dealEnq = 'N') "
				+ "WHERE RNUM BETWEEN ? AND ? "	
				+ "ORDER BY RNUM DESC ";
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
				int rNum = rs.getInt("RNUM");
				int boardNo = rs.getInt("boardNo");
				String category = rs.getString("boardCategory");
				String boardTitle = rs.getString("boardTitle");
				String userId = rs.getString("userId");
				Date boardDate = rs.getDate("boardDate");
				String boardContent = rs.getString("boardContent");
				String dealEnq = rs.getString("dealEnq");
				
				selectedBoard = new BoardVo();
				selectedBoard.setrNum(rNum);
				selectedBoard.setBoardNo(boardNo);
				selectedBoard.setBoardCategory(category);
				selectedBoard.setBoardTitle(boardTitle);
				selectedBoard.setUserId(userId);
				selectedBoard.setBoardDate(boardDate);
				selectedBoard.setBoardContent(boardContent);
				selectedBoard.setDealEnq(dealEnq);
				
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

	
	//===============타입별 조회해서+처리함!! 모든 문의 게시글 찾아오기=================
	public List<BoardVo> selectE_BoardBySearch(Connection conn, String type, String value, int startNo, int endNo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String sql = "SELECT a.*, ap.admin_power_name "
//				+ "FROM admin a "
//				+ "LEFT JOIN admin_power ap ON(a.admin_power_code = ap.admin_power_code) "
//				+ "WHERE %s LIKE ?";
		String sql = "SELECT * "
				+ "FROM "
				+ "( "
				+ "SELECT ROWNUM AS RNUM, b.*  "
				+ "FROM (SELECT * FROM BOARD "
				+ "WHERE boardCategory ='enquiry' and boardOpen_YN = 'Y' and %s LIKE ? and dealEnq = 'Y') b) "
				+ "WHERE RNUM BETWEEN ? AND ? "
				+ "ORDER BY RNUM DESC";

		sql = String.format(sql, type);
		//%s : 타입
//		type 여러개 넣을 수 있다.
//		System.out.println("sql: "+sql);
		
		List<BoardVo> list = null;
		list = new ArrayList<BoardVo>();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+value+"%");
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			System.out.println("sql: "+sql);
			
			BoardVo selectedBoard = null;
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rNum = rs.getInt("RNUM");
				int boardNo = rs.getInt("boardNo");
				String category = rs.getString("boardCategory");
				String boardTitle = rs.getString("boardTitle");
				String userId = rs.getString("userId");
				Date boardDate = rs.getDate("boardDate");
				String boardContent = rs.getString("boardContent");
				String dealEnq = rs.getString("dealEnq");
				
				selectedBoard = new BoardVo();
				selectedBoard.setrNum(rNum);
				selectedBoard.setBoardNo(boardNo);
				selectedBoard.setBoardCategory(category);
				selectedBoard.setBoardTitle(boardTitle);
				selectedBoard.setUserId(userId);
				selectedBoard.setBoardDate(boardDate);
				selectedBoard.setBoardContent(boardContent);
				selectedBoard.setDealEnq(dealEnq);
				
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
	
	//===============타입별 조회해서+처리안함** 모든 문의 게시글 찾아오기=================
	public List<BoardVo> selectNoE_BoardBySearch(Connection conn, String type, String value, int startNo, int endNo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String sql = "SELECT a.*, ap.admin_power_name "
//				+ "FROM admin a "
//				+ "LEFT JOIN admin_power ap ON(a.admin_power_code = ap.admin_power_code) "
//				+ "WHERE %s LIKE ?";
		String sql = "SELECT * "
				+ "FROM "
				+ "( "
				+ "SELECT ROWNUM AS RNUM, b.*  "
				+ "FROM (SELECT * FROM BOARD "
				+ "WHERE boardCategory ='enquiry' and boardOpen_YN = 'Y' and %s LIKE ? and dealEnq = 'N') b) "
				+ "WHERE RNUM BETWEEN ? AND ? "
				+ "ORDER BY RNUM DESC";
		
		sql = String.format(sql, type);
		//%s : 타입
//		type 여러개 넣을 수 있다.
//		System.out.println("sql: "+sql);
		
		List<BoardVo> list = null;
		list = new ArrayList<BoardVo>();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+value+"%");
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			System.out.println("sql: "+sql);
			
			BoardVo selectedBoard = null;
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rNum = rs.getInt("RNUM");
				int boardNo = rs.getInt("boardNo");
				String category = rs.getString("boardCategory");
				String boardTitle = rs.getString("boardTitle");
				String userId = rs.getString("userId");
				Date boardDate = rs.getDate("boardDate");
				String boardContent = rs.getString("boardContent");
				String dealEnq = rs.getString("dealEnq");
				
				selectedBoard = new BoardVo();
				selectedBoard.setrNum(rNum);
				selectedBoard.setBoardNo(boardNo);
				selectedBoard.setBoardCategory(category);
				selectedBoard.setBoardTitle(boardTitle);
				selectedBoard.setUserId(userId);
				selectedBoard.setBoardDate(boardDate);
				selectedBoard.setBoardContent(boardContent);
				selectedBoard.setDealEnq(dealEnq);
				
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
	

	
//	========= 수정(처리여부->Y) ================
	public int updateBoard(Connection conn, int boardNo) {
		int result = 0;
		
//		String sql = "SELECT a.*, ap.admin_power_name "
//				+ "FROM admin a "
//				+ "LEFT JOIN admin_power ap ON(a.admin_power_code = ap.admin_power_code) "
//				+ "WHERE admin_id = ?";
		String sql = "UPDATE BOARD "
				+ "SET dealEnq = 'Y' "
				+ "WHERE boardCategory ='enquiry' and boardOpen_YN = 'Y' and dealEnq = 'N' and boardNo = ?";
		System.out.println("수정->y"+sql);
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("수정Yresult"+result);
		return result;
	}
	
//	========= 수정(처리여부-> N) ================
	public int updateNoBoard(Connection conn, int boardNo) {
		int result = 0;
		
//		String sql = "SELECT a.*, ap.admin_power_name "
//				+ "FROM admin a "
//				+ "LEFT JOIN admin_power ap ON(a.admin_power_code = ap.admin_power_code) "
//				+ "WHERE admin_id = ?";
		String sql = "UPDATE BOARD "
				+ "SET dealEnq = 'N' "
				+ "WHERE boardCategory ='enquiry' and boardOpen_YN = 'Y' and dealEnq = 'Y' and boardNo = ?";
		
		PreparedStatement pstmt = null;
		System.out.println("수정->n"+sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("수정Nresult"+result);
		return result;
	}


	


	

}



