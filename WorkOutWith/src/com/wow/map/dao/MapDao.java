package com.wow.map.dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wow.common.JDBCTemplate;
import com.wow.map.model.vo.MapModelVo;

public class MapDao {
	
	public int insertMember(Connection conn, MapModelVo m) throws SQLException {
		//쿼리 날리기
		
		//지금 id pwd name 다 null 로나옴
		
		String sql="INSERT INTO BOARD_TEST_T(BOARD_NU, TITLE, NAME, CONTENT, ENROLL_DATE, OPEN_YN,QUIT_YN) "
				+ "VALUES(SEQ_board_test_t.NEXTVAL, ?, ?, ?, SYSDATE,DEFAULT,DEFAULT)";
		
		PreparedStatement pstmt = null;
		int result =0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getTitle());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getContent());

			
			result = pstmt.executeUpdate();
		}finally {
			JDBCTemplate.close(pstmt);	
		}
		
		
		
		return result;
	}
	
	
	
	
public List<MapModelVo> selectMemberAll(Connection conn,int startNo, int endNo) {
		
		String sql= "SELECT * "
				+ "FROM ( "
				+ "SELECT ROWNUM AS RNUM , m.* FROM MEMBER m WHERE QUIT_YN ='N' AND OPEN_YN ='Y' "
				+ ") "
				+ "WHERE RNUM BETWEEN ? AND ?" ;
		
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<MapModelVo> list= new ArrayList<MapModelVo>();
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			MapModelVo selectedMember = null;
			
			
			while(rs.next()) {
				int boardNo = rs.getInt("BOARD_NU");
				String title = rs.getString("TITLE");
				String name = rs.getString("NAME");
				String content = rs.getString("CONTENT");
				int detail = rs.getInt("DETAIL");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
	
				
				selectedMember = new MapModelVo();
				selectedMember.setBorardNo(boardNo);
				selectedMember.setTitle(title);
				selectedMember.setName(name);
				selectedMember.setContent(content);
				selectedMember.setEnrollDate(enrollDate);
				selectedMember.setModifyDate(modifyDate);
				
				list.add(selectedMember);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		
		return list;
	}


public int countMemberAll(Connection conn) {
	 PreparedStatement pstmt = null;
	 ResultSet  rs = null;
	 int result = 0;
	 
	 String sql="SELECT COUNT(BOARD_NU) FROM BOARD_TEST_T WHERE QUIT_YN='N' AND OPEN_YN='Y'";
	 
	 try {
		pstmt = conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs.next()){
		result = rs.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
	}
			 
	return result;
}


public List<MapModelVo> selectMemberBySearch(Connection conn, String type, String value) {
	
	PreparedStatement pstmt =null;
	ResultSet rs=null;
	String sql="SELECT * FROM BOARD_TEST_T WHERE %s LIKE ?";
	sql = String.format(sql, type);
	List<MapModelVo> list = new ArrayList<MapModelVo>();
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+value+"%");
		
		MapModelVo selectedMember= null;
		
		rs=pstmt.executeQuery();
		
		while(rs.next()) {
			MapModelVo m =new MapModelVo();
			int memberNo = rs.getInt("BOARD_NU");
			String id = rs.getString("TITLE");
			String pwd = rs.getString("NAME");
			String name = rs.getString("CONTENT");
			Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
			Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");	
			
			selectedMember = new MapModelVo();
			selectedMember.setBorardNo(memberNo);
			selectedMember.setTitle(id);
			selectedMember.setName(pwd);
			selectedMember.setContent(name);
			selectedMember.setEnrollDate(enrollDate);
			selectedMember.setModifyDate(modifyDate);
			
			list.add(selectedMember);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return list;
}






	
	
	







	
	
	
	

}
