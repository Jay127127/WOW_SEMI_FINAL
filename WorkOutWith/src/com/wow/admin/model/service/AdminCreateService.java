package com.wow.admin.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.wow.admin.model.dao.AdminDao;
import com.wow.admin.model.vo.AdminVo;
import static com.wow.common.JDBCTemplate.*;

public class AdminCreateService {
	
	private int maxPage = 0;
	private int prevPage = 0;
	private int nextPage = 0;
	
	//2. admin 계정 생성
	public int create(AdminVo a) {
			
		//DB Connection 가져오기
		Connection conn = getConnection();
			
		//쿼리 날리기, insert!!!
		int result = 0;
		
		try {
			result = insertAdmin(conn, a);
			
			//계정이 생성됐으면
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
		} catch (Exception e) {
			System.out.println("계정생성에 오류생김!!");
		} finally {
			close(conn);
		}
			
		return result;
	}


	//2-1. 유지보수를 위해.. AdminDao().insertAdmin() 을 오버로딩
	private int insertAdmin(Connection conn, AdminVo a) throws SQLException {
		//dao 불러서 쿼리 실행
		//dao한테 쿼리 실행 결과 받기
		//throws로 캐치블럭 없음
		int result = new AdminDao().insertAdmin(conn, a);
		//계정생성되면 result==1
		return result;
	}
	
	//1. admin 로그인
	public AdminVo adLogin(AdminVo a) {
		//커넥션 가져오기(디비 가져오기?)
		Connection conn = getConnection();
		
		//1-1. admin_id로 그 아이디의 비번 조회
		AdminVo selectedAdmin = selectAdmin(conn, a);
		
		close(conn);
		
		//4. 로그인, 아이디나 비밀번호가 일치하는 값이 없으면 selectedAdmin == null 이므로, 이걸 처리해야 한다.
		if(selectedAdmin == null) {
			System.out.println("로그인 실패");
			return null;
		}
		
		//가져온 pwd와 사용자가 입력한 pwd가 같은지 비교, 같으면
		if(selectedAdmin.getAdmin_pwd().equals(a.getAdmin_pwd()))
			//결과 리턴
			return selectedAdmin;
		else
			return null;
	}

	
	//1-1. selectAdmin() 갖고오기?? 유지보수를 위해??
	private AdminVo selectAdmin(Connection conn, AdminVo a) {
		return new AdminDao().selectAdmin(conn, a);
	}

	
	//3. admin아이디 중복 체크, 로그인할 때 아이디 일치여부 체크
	public int dupCheck(String id) {
		Connection conn = getConnection();
		int result = selectAdminById(conn, id);
		
		close(conn);
		return result;
	}


	//3-1. selectAdminById() 갖고오기
	private int selectAdminById(Connection conn, String id) {
		return new AdminDao().selectAdminById(conn, id);
	}
	

	//5-0. 페이징 결합, 탐색 결과?를 list로 담아서 보여줌 
	public List<AdminVo> search(String type, String value, String currentPage){
		Connection conn = getConnection();
		
		//한 페이지 당 게시글 수
		int boardLimit = 5;
		//총 게시글 수 : select count (*)~~ (5-1)
		int totalBoardCount = 0;
		
		List<AdminVo> adminList;
		if(type == null || value == null) {
			//총 게시글 수 : select count (*)~~ (5-1)
			totalBoardCount = countAdminAll(conn);
		} else {
			//총 게시글 수 : select count (*)~~ (5-4)
			totalBoardCount = countSearchAll(conn, type, value);
			System.out.println("type:"+type);
			System.out.println("value:"+value);
			System.out.println("total:"+totalBoardCount);
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
			adminList = seletAdminAll(conn, currentPage, startNo, endNo);
		} else {
			//type과 value 둘다 값이 있을 경우, 즉 타입적용 (5-2)
			adminList = selectAdminBySearch(conn, type, value, currentPage, startNo, endNo);
		}
		
		close(conn);
		
		return adminList;
	}

	private int countSearchAll(Connection conn, String type, String value) {
		return new AdminDao().countSearchAll(conn, type, value);
	}


	//5-2. selectAdminBySearch() 가져오기, 어드민 타입별 검색 결과
	private List<AdminVo> selectAdminBySearch(Connection conn, String type, String value, String currentPage, int startNo, int endNo) {
		return new AdminDao().selectAdminBySearch(conn, type, value, startNo, endNo);
	}


	//5-1. countAdminAll() 가져오기, 어드민 개수
	private int countAdminAll(Connection conn) {
		return new AdminDao().countAdminAll(conn);
	}
	
	//5-3. seletAdminAll() 가져오기, 어드민 모든 멤버 조회
	public List<AdminVo> seletAdminAll(Connection conn, String currentPage, int startNo, int endNo) {
		return new AdminDao().selectAdminAll(conn, startNo, endNo);
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
	
	
	//6-1. 어드민 계정 삭제
	public int deleteAdmin(String admin_id){
		Connection conn = getConnection();
		int result = new AdminDao().deleteAdmin(conn, admin_id);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		System.out.println("===service result==:"+result);		
		return result;
	}
	
	
	//7-1. 유지보수를 위해.. AdminDao().updateAdmin() 을 오버로딩
	public int updateAdmin(AdminVo a) {
		//dao 불러서 쿼리 실행
		//dao한테 쿼리 실행 결과 받기
		//throws로 캐치블럭 없음
		Connection conn = getConnection();
		int result = new AdminDao().updateAdmin(conn, a);
		//데이터 처리 : result == 1 수정완료, 0 비번불일치, -1 아이디없음
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}
