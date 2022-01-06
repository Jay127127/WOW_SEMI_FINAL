package com.wow.admin.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.wow.admin.model.dao.AdBoardDao;
import com.wow.admin.model.vo.BoardVo;
import com.wow.board.Dao.BoardDao;

import static com.wow.common.JDBCTemplate.*;

public class AdminBoardService {
	
	private int maxPage = 0;
	private int prevPage = 0;
	private int nextPage = 0;
	private int maxYPage = 0;
	private int prevYPage = 0;
	private int nextYPage = 0;
	
	
//	===================처리함!!==================
	//5-0. 페이징 결합, 탐색 결과?를 list로 담아서 보여줌 
	public List<BoardVo> search(String type, String value, String currentPage){
		Connection conn = getConnection();
		
		//한 페이지 당 게시글 수
		int boardLimit = 5;
		//총 게시글 수 : select count (*)~~ (5-1)
		int totalBoardCount = 0;
		
		List<BoardVo> userList;
		if(type == null || value == null) {
			//총 게시글 수 : select count (*)~~ (5-1)
			totalBoardCount = countE_BoardAll(conn);
			System.out.println("타입없total:"+totalBoardCount);
		} else {
			//총 게시글 수 : select count (*)~~ (5-4)
			totalBoardCount = countSearchAll(conn, type, value);
			System.out.println("type:"+type);
			System.out.println("value:"+value);
			System.out.println("타입있total:"+totalBoardCount);
		}
		
		//마지막 페이지 maxPage
		// maxPage를 담을 함수 (5-4)
		maxYPage = totalBoardCount / boardLimit;
		if(totalBoardCount % boardLimit != 0) {
			maxYPage++;
		}
		System.out.println("maxYPage: "+maxYPage);
				
		int cPage = Integer.parseInt(currentPage);
		System.out.println("cPage: "+cPage);
				
		//이전 페이지 prevPage 설정
		prevYPage = (cPage == 1)? cPage : cPage-1;
		System.out.println("prevYPage: "+prevYPage);
				
		//다음페이지 nextPage 설정
		nextYPage = (cPage == maxYPage)? cPage : cPage+1;
		System.out.println("nextYPage: "+nextYPage);
				
		//현재 페이지의 마지막 글번호
		int endNo = cPage * boardLimit;
		//현재 페이지의 첫번째 글번호
		int startNo = endNo - boardLimit + 1;		

		if(type == null || value == null) {
			//탐색만 눌렀을 때 null, null이 나오는데, 이땐 전체 멤버 조회로 (5-3)
			userList = selectE_BoardAll(conn, currentPage, startNo, endNo);
		} else {
			//type과 value 둘다 값이 있을 경우, 즉 타입적용 (5-2)
			userList = selectE_BoardBySearch(conn, type, value, currentPage, startNo, endNo);
		}
		
		close(conn);
		
		return userList;
	}

	private int countSearchAll(Connection conn, String type, String value) {
		return new AdBoardDao().countSearchAll(conn, type, value);
	}


	//5-2. selectUserBySearch() 가져오기, 어드민 타입별 검색 결과
	private List<BoardVo> selectE_BoardBySearch(Connection conn, String type, String value, String currentPage, int startNo, int endNo) {
		return new AdBoardDao().selectE_BoardBySearch(conn, type, value, startNo, endNo);
	}


	//5-1. countUserAll() 가져오기, 어드민 개수
	private int countE_BoardAll(Connection conn) {
		return new AdBoardDao().countE_BoardAll(conn);
	}
	
	//5-3. seletUserAll() 가져오기, 어드민 모든 멤버 조회
	public List<BoardVo> selectE_BoardAll(Connection conn, String currentPage, int startNo, int endNo) {
		return new AdBoardDao().selectE_BoardAll(conn, startNo, endNo);
	}
	

	//5-4. maxPage를 담을 함수
	public int getMaxYPage() {
		return maxYPage;
	}
	
	//5-5. prevPage를 담을 함수
	public int getPrevYPage() {
		return prevYPage;
	}
	
	//5-5. nextPage를 담을 함수
	public int getNextYPage() {
		return nextYPage;
	}
	
	
//	========== 처리안함****** ==========
	
	public List<BoardVo> searchNo(String type, String value, String currentPage){
		Connection conn = getConnection();
		
		//한 페이지 당 게시글 수
		int boardLimit = 5;
		//총 게시글 수 : select count (*)~~ (5-1)
		int totalBoardCount = 0;
		
		List<BoardVo> userList;
		if(type == null || value == null) {
			//총 게시글 수 : select count (*)~~ (5-1)
			totalBoardCount = countNoE_BoardAll(conn);
			System.out.println("타입없total:"+totalBoardCount);
		} else {
			//총 게시글 수 : select count (*)~~ (5-4)
			totalBoardCount = countNoSearchAll(conn, type, value);
			System.out.println("type:"+type);
			System.out.println("value:"+value);
			System.out.println("타입없total:"+totalBoardCount);
		}
		
		//마지막 페이지 maxPage
		// maxPage를 담을 함수 (5-4)
		maxPage = totalBoardCount / boardLimit;
		if(totalBoardCount % boardLimit != 0) {
			maxPage++;
		}
		System.out.println("maxPage: "+maxPage);
				
		int cPage = Integer.parseInt(currentPage);
		System.out.println("cPage: "+cPage);
				
		//이전 페이지 prevPage 설정
		prevPage = (cPage == 1)? cPage : cPage-1;
		System.out.println("prevPage: "+prevPage);
				
		//다음페이지 nextPage 설정
		nextPage = (cPage == maxPage)? cPage : cPage+1;
		System.out.println("nextPage: "+nextPage);
				
		//현재 페이지의 마지막 글번호
		int endNo = cPage * boardLimit;
		//현재 페이지의 첫번째 글번호
		int startNo = endNo - boardLimit + 1;		

		if(type == null || value == null) {
			//탐색만 눌렀을 때 null, null이 나오는데, 이땐 전체 멤버 조회로 (5-3)
			userList = selectNoE_BoardAll(conn, currentPage, startNo, endNo);
		} else {
			//type과 value 둘다 값이 있을 경우, 즉 타입적용 (5-2)
			userList = selectNoE_BoardBySearch(conn, type, value, currentPage, startNo, endNo);
		}
		
		close(conn);
		
		return userList;
	}

	private List<BoardVo> selectNoE_BoardBySearch(Connection conn, String type, String value, String currentPage,
			int startNo, int endNo) {
		return new AdBoardDao().selectNoE_BoardBySearch(conn, type, value, startNo, endNo);
	}

	private List<BoardVo> selectNoE_BoardAll(Connection conn, String currentPage, int startNo, int endNo) {
		return new AdBoardDao().selectNoE_BoardAll(conn, startNo, endNo);
	}

	private int countNoSearchAll(Connection conn, String type, String value) {
		return new AdBoardDao().countNoSearchAll(conn, type, value);
	}

	private int countNoE_BoardAll(Connection conn) {
		return new AdBoardDao().countNoE_BoardAll(conn);
	}
	
//	========== 수정(문의글 처리) ===========
	public int updateBoard(int boardNo) {
		Connection conn = getConnection();
		int result = new AdBoardDao().updateBoard(conn, boardNo);
		// result > 0 수정완료
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
//	========== 수정(문의글 ->N 처리) ===========
	public int updateNoBoard(int boardNo) {
		Connection conn = getConnection();
		int result = new AdBoardDao().updateNoBoard(conn, boardNo);
		// result > 0 수정완료
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	//5-4. maxPage를 담을 함수
	public int getMaxPage() {
		return maxPage;
	}
	
	//5-5. prevPage를 담을 함수
	public int getPrevPage() {
		return prevPage;
	}
	
	//5-5. nextPage를 담을 함수
	public int getNextPage() {
		return nextPage;
	}


}
