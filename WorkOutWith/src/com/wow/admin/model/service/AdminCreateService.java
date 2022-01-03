package com.wow.admin.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.wow.admin.model.dao.AdminDao;
import com.wow.admin.model.vo.AdminVo;
import static com.wow.common.JDBCTemplate.*;

public class AdminCreateService {
	
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
	
	//5. admin 모든 멤버 조회
	public List<AdminVo> seletAdminAll(Connection conn, String currentPage, int startNo, int endNo) {
		return new AdminDao().selectAdminAll(conn, startNo, endNo);
	}
	
	public List<AdminVo> search(String type, String value, String currentPage){
		Connection conn = getConnection();
		
		//총 게시글 수 : select count (*)~~
		int totalBoardCount = countAdminAll(conn);
		//총 회원 수
		//countAdminAll();
		
		//페이징 목록 최대 개수
		int pageLimit = 5;
		//한 페이지 당 게시글 수
		int boardLimit = 3;
		//마지막 페이지
		int maxPage = 0;
		
		maxPage = totalBoardCount / boardLimit;
		if(totalBoardCount % boardLimit != 0) {
			maxPage++;
		}
		System.out.println("maxPage: "+maxPage);
		
		int cp = Integer.parseInt(currentPage);
		
		//현재 페이지의 마지막 글번호
		int endNo = cp * boardLimit;
		//현재 페이지의 첫번째 글번호
		int startNo = endNo - boardLimit + 1;
		
		List<AdminVo> adminList;
		if(type == null || value == null) {
			//탐색만 눌렀을 때 null, null이 나오는데, 이땐 전체 멤버 조회로
			adminList = seletAdminAll(conn, currentPage, startNo, endNo);
		} else {
			//type과 value 둘다 값이 있을 경우
			adminList = selectAd
		}
		
	}


	//5-1. countAdminAll() 가져오기
	private int countAdminAll(Connection conn) {
		return new AdminDao().countAdminAll(conn);
	}
	
	//5-2. selectAdmin() 가져오기
	

	
}
