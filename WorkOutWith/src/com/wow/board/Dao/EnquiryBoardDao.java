package com.wow.board.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.wow.board.contoller.EnquiryBoardController;
import com.wow.board.model.vo.EnquiryBoardVo;
import com.wow.common.JDBCTemplate;

public class EnquiryBoardDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection conn = null;
	
	public String getDate() {
		String sql = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return ""; //DB error
	}
	
	public int getNext() {
		String sql = "SELECT E_boardId FROM ENQUIRY_BOARD ORDER BY E_boardID DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1)+1;
			}
			return 1; // 첫번째 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return -1; //DB error
	}
	
//	public int write(String E_boardTitle, String E_userId, String E_boardContent) {	
//	}
	
	public int insertEnquiryPost(Connection conn, EnquiryBoardVo ev) {
		
		String sql = "INSERT INTO ENQUIRY_BOARD VALUES(?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, ev.getE_boardTitle());
			pstmt.setString(3, ev.getE_userId());
			pstmt.setString(4, getDate());
			pstmt.setString(5, ev.getE_boardContent());
			pstmt.setInt(6, 1);
			pstmt.setInt(7, 1);
			pstmt.setInt(8, 1);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result; //DB error
	}

	public ArrayList<EnquiryBoardVo> getList(int pageNumber){
		String sql = "SELECT * FROM ENQUIRY_BOARD WHERE E_boardNo < ? AND E_baordAvailable = 1 ORDER BY E_boardId DESC LIMIT 10";
		ArrayList<EnquiryBoardVo> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  getNext() - (pageNumber -1) * 10);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EnquiryBoardVo ev = new EnquiryBoardVo();
				ev.setE_boardNO(rs.getInt(1));
				ev.setE_boardTitle(rs.getString(2));
				ev.setE_userId(rs.getString(3));
				ev.setE_boardDate(rs.getString(4));
				ev.setE_boardContent(rs.getString(5));
				ev.setE_boardAvailable(rs.getInt(6));
				ev.setE_views(rs.getInt(7));
				ev.setE_likes(rs.getInt(8));
				list = new ArrayList<EnquiryBoardVo>();
				list.add(ev);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return list; //DB error
	}
	
	public boolean nextPage(int pageNumber) {
		String sql = "SELECT * FROM ENQUIRY_BOARD WHERE E_boardId < ? AND E_baordAvailable = 1";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  getNext() - (pageNumber -1) * 10);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return false; //DB error
	}
	
	public EnquiryBoardVo getEnquiryBoard(int E_boardNo) {
		String sql = "SELECT * FROM ENWUIRY_BOARD WHERE E_boardNo = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, E_boardNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EnquiryBoardVo ev = new EnquiryBoardVo();
				ev.setE_boardNO(rs.getInt(1));
				ev.setE_boardTitle(rs.getString(2));
				ev.setE_userId(rs.getString(3));
				ev.setE_boardDate(rs.getString(4));
				ev.setE_boardContent(rs.getString(5));
				ev.setE_boardAvailable(rs.getInt(6));
				ev.setE_views(rs.getInt(7));
				ev.setE_likes(rs.getInt(8));
				return ev;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return null; //DB error
	}
	
}
