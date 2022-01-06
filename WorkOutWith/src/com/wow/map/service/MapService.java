package com.wow.map.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
	
	public List<MapModelVo> selectMemberAll(Connection conn, String currentPage,int startNo, int endNo) {	
		return new MapDao().selectMemberAll(conn,startNo,endNo);
	}

	
public List<MapModelVo> search(String type, String value, String currentPage) {
		
		
		Connection conn =getConnection();
		int totalBoardCount =countMemberAll(conn);;//총회원수  //총 게시글 수  
		int pageLimit=5;	//		페이징 목록 최대개수
		int boardLimit=5;	//		한 페이지당 게시글 수		
		int maxPage = 0;  //		마지막 페이지
		
		maxPage = totalBoardCount/ boardLimit;
		if(totalBoardCount%pageLimit != 0) {
			maxPage++;
		}
		System.out.println("maxPage : " + maxPage);//swy
		
		//(currentPage * boradLimit)- boardLimit +1 ~ currentPage *  boardLimit
		
		int p = Integer.parseInt(currentPage);
		int endNo 	=	p* boardLimit;
		int startNo	=	endNo- boardLimit + 1;
		
		List<MapModelVo> memberList;
		if(type==null||value==null) {
			 memberList= selectMemberAll(conn,currentPage,startNo, endNo);
		}else {
			 memberList= selectMember(conn,type,value);
		}
		close(conn);
		
		
		//애는 모든것을 조회해오는것
//		List<MemberVo> memberList= selectMemberAll(conn);
		//커밋 롤백도 처리해줘야함.. 잠깐 킵...
//		close(conn);
		
		return memberList;
	}
private int countMemberAll(Connection conn) {
	
	return new MapDao().countMemberAll(conn);
}

private List<MapModelVo> selectMember(Connection conn, String type, String value) {
	
	return new MapDao().selectMemberBySearch(conn,type,value);
}
	




}
