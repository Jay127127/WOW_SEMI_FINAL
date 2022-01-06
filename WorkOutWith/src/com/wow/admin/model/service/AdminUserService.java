package com.wow.admin.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.wow.admin.model.dao.UserDao;
import com.wow.admin.model.vo.UserVo;
import static com.wow.common.JDBCTemplate.*;

public class AdminUserService {
	
	private int maxPage = 0;
	private int prevPage = 0;
	private int nextPage = 0;
	
	

	//5-0. 페이징 결합, 탐색 결과?를 list로 담아서 보여줌 
	public List<UserVo> search(String type, String value, String currentPage){
		Connection conn = getConnection();
		
		//한 페이지 당 게시글 수
		int boardLimit = 5;
		//총 게시글 수 : select count (*)~~ (5-1)
		int totalBoardCount = 0;
		
		List<UserVo> userList;
		if(type == null || value == null) {
			//총 게시글 수 : select count (*)~~ (5-1)
			totalBoardCount = countUserAll(conn);
		} else {
			//총 게시글 수 : select count (*)~~ (5-4)
			totalBoardCount = countSearchAll(conn, type, value);
			System.out.println("type:"+type);
			System.out.println("value:"+value);
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
			userList = seletUserAll(conn, currentPage, startNo, endNo);
		} else {
			//type과 value 둘다 값이 있을 경우, 즉 타입적용 (5-2)
			userList = selectUserBySearch(conn, type, value, currentPage, startNo, endNo);
		}
		
		close(conn);
		
		return userList;
	}

	private int countSearchAll(Connection conn, String type, String value) {
		return new UserDao().countSearchAll(conn, type, value);
	}


	//5-2. selectUserBySearch() 가져오기, 어드민 타입별 검색 결과
	private List<UserVo> selectUserBySearch(Connection conn, String type, String value, String currentPage, int startNo, int endNo) {
		return new UserDao().selectUserBySearch(conn, type, value, startNo, endNo);
	}


	//5-1. countUserAll() 가져오기, 어드민 개수
	private int countUserAll(Connection conn) {
		return new UserDao().countUserAll(conn);
	}
	
	//5-3. seletUserAll() 가져오기, 어드민 모든 멤버 조회
	public List<UserVo> seletUserAll(Connection conn, String currentPage, int startNo, int endNo) {
		return new UserDao().selectUserAll(conn, startNo, endNo);
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
	
	
	//6-1. 유저 계정 삭제
	public int deleteUser(String admin_id){
		Connection conn = getConnection();
		int result = new UserDao().deleteUser(conn, admin_id);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		System.out.println("===service result==:"+result);		
		return result;
	}
	
	

}
