package com.wow.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.wow.board.Dao.BoardDao;
import com.wow.board.model.vo.BoardVo;
import com.wow.login.model.dao.MemberDao;

import static com.wow.common.JDBCTemplate.*;

public class BoardService {
	
	public int post(BoardVo b) {
		// DB Connection 가져오기
		Connection conn = getConnection();

		// 쿼리 날리기 //insert
		int result = 0;
		try {
			result = insertBoard(conn, b);
			if (result > 0)
				commit(conn);
			else
				rollback(conn);
		} finally {
			close(conn);
		}
		// 결과 반환해주기
			return result;
	}

	private int insertBoard(Connection conn, BoardVo b) {
		return new BoardDao().insertBoard(conn, b);
	}

//	========================BOARD_PAGE===========================
	public List<BoardVo> search(String selectType, String currentPage) {
		
		Connection conn = getConnection();

		int totalBoardCount = countBoardAll(conn);
		// 총 게시글 수 //select count(*)
		int pageLimit = 5; // 페이징 목록 최대 갯수
		int boardLimit = 5; // 한 페이지 당 게시글 수
		int maxPage = 0;

		maxPage = totalBoardCount / boardLimit;
		if (totalBoardCount % boardLimit != 0) {
			maxPage++;
		}
		System.out.println("maxPage : " + maxPage);

		int p = Integer.parseInt(currentPage);
		int endNo = p * boardLimit;
		int startNo = endNo - boardLimit + 1;

		List<BoardVo> BoardList;
		if (selectType == null) {
			BoardList = selectBoardAll(conn, currentPage, startNo, endNo);
		} else {
			BoardList = selectBoard(conn, selectType);
		}
		close(conn);
		return BoardList;
	}
	
	private List<BoardVo> selectBoard(Connection conn, String selectType) {
		return new BoardDao().selectBoardByType(conn, selectType);
	}

	private List<BoardVo> selectBoardAll(Connection conn, String currentPage, int startNo, int endNo) { 
		 return new BoardDao().selectBoardAll(conn, startNo, endNo); 
	}
	 
	private int countBoardAll(Connection conn) {
		return new BoardDao().countBoardAll(conn);
	}

	
//	=====================ENQUIRY BOARD===========================
	public List<BoardVo> searchEnquiry(String selectType, String currentPage ) {

		Connection conn = getConnection();

			int totalBoardCount = countE_BoardAll(conn);
			// 총 게시글 수 //select count(*)
			int pageLimit = 5; // 페이징 목록 최대 갯수
			int boardLimit = 5; // 한 페이지 당 게시글 수
			int maxPage = 0;
	
			maxPage = totalBoardCount / boardLimit;
			if (totalBoardCount % boardLimit != 0) {
				maxPage++;
			}
			System.out.println("maxPage : " + maxPage);
	
			int p = Integer.parseInt(currentPage);
			int endNo = p * boardLimit;
			int startNo = endNo - boardLimit + 1;
	
			List<BoardVo> E_BoardList = null;
			if (selectType == null) {
				E_BoardList = selectE_BoardAll(conn, currentPage, startNo, endNo);
			} else {
				E_BoardList = selectE_Board(conn, selectType);
			}
			close(conn);
			return E_BoardList;
	}

	private List<BoardVo> selectE_Board(Connection conn, String selectType) {
		return new BoardDao().selectE_BoardByType(conn, selectType);
	}

	private List<BoardVo> selectE_BoardAll(Connection conn, String currentPage, int startNo, int endNo) {
		 return new BoardDao().selectE_BoardAll(conn, startNo, endNo); 
	}

	private int countE_BoardAll(Connection conn) {
		return new BoardDao().countE_BoardAll(conn);
	}

//	=====================GALLERY BOARD===========================
	public List<BoardVo> searchGallery(String selectType, String currentPage) {
		
		Connection conn = getConnection();

			int totalBoardCount = countG_BoardAll(conn);
			// 총 게시글 수 //select count(*)
			int pageLimit = 5; // 페이징 목록 최대 갯수
			int boardLimit = 5; // 한 페이지 당 게시글 수
			int maxPage = 0;
	
			maxPage = totalBoardCount / boardLimit;
			if (totalBoardCount % boardLimit != 0) {
				maxPage++;
			}
			System.out.println("maxPage : " + maxPage);
	
			int p = Integer.parseInt(currentPage);
			int endNo = p * boardLimit;
			int startNo = endNo - boardLimit + 1;
	
			List<BoardVo> G_BoardList;
			if (selectType == null) {
				G_BoardList = selectG_BoardAll(conn, currentPage, startNo, endNo);
			} else {
				G_BoardList = selectG_Board(conn, selectType);
			}
			close(conn);
			return G_BoardList;
		}

	private int countG_BoardAll(Connection conn) {
		return new BoardDao().countG_BoardAll(conn);
	}
	
	private List<BoardVo> selectG_BoardAll(Connection conn, String currentPage, int startNo, int endNo) {
		return new BoardDao().selectG_BoardAll(conn, startNo, endNo); 
	}

	private List<BoardVo> selectG_Board(Connection conn, String selectType) {
		return new BoardDao().selectG_BoardByType(conn, selectType);
	}

	
//	=====================ROUTINE BOARD===========================
	public List<BoardVo> searchRoutine(String selectType, String currentPage) {

		Connection conn = getConnection();

			int totalBoardCount = countR_BoardAll(conn);
			// 총 게시글 수 //select count(*)
			int pageLimit = 5; // 페이징 목록 최대 갯수
			int boardLimit = 5; // 한 페이지 당 게시글 수
			int maxPage = 0;
	
			maxPage = totalBoardCount / boardLimit;
			if (totalBoardCount % boardLimit != 0) {
				maxPage++;
			}
			System.out.println("maxPage : " + maxPage);
	
			int p = Integer.parseInt(currentPage);
			int endNo = p * boardLimit;
			int startNo = endNo - boardLimit + 1;
	
			List<BoardVo> R_BoardList;
			if (selectType == null) {
				R_BoardList = selectR_BoardAll(conn, currentPage, startNo, endNo);
			} else {
				R_BoardList = selectR_Board(conn, selectType);
			}
			close(conn);
			return R_BoardList;
		}

	private int countR_BoardAll(Connection conn) {
		return new BoardDao().countR_BoardAll(conn);
	}

	private List<BoardVo> selectR_BoardAll(Connection conn, String currentPage, int startNo, int endNo) {
		return new BoardDao().selectR_BoardAll(conn, startNo, endNo); 
	}

	private List<BoardVo> selectR_Board(Connection conn, String selectType) {
		return new BoardDao().selectR_BoardAll(conn, selectType); 
	}
	
	
//	=====================viewCountupdate===========================
	public int viewUpdate(BoardVo b) {
		// DB Connection 가져오기
		Connection conn = getConnection();

		// 쿼리 날리기 //insert
		int result = 0;
		try {
			result = updateViewCount(conn, b);
			if (result > 0)
				commit(conn);
			else
				rollback(conn);
		} finally {
			close(conn);
		}
		// 결과 반환해주기
			return result;
	}

	private int updateViewCount(Connection conn, BoardVo b) {
		return new BoardDao().boardViewUpdate(conn, b);
	}

	public List<BoardVo> searchView(String selectType, String currentPage, String boardNo) {
		System.out.println("boardNo in service : "+boardNo);
		Connection conn = getConnection();
		
		List<BoardVo> V_BoardList = selectBoardByBoardNo(conn, currentPage, boardNo);
		
		close(conn);
		return V_BoardList;
	}

	private List<BoardVo> selectBoardByBoardNo(Connection conn, String currentPage, String boardNo) {
		return new BoardDao().selectBoardBoardNo(conn, boardNo);
	}	


}
