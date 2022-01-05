package com.wow.board.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.board.model.vo.BoardVo;
import com.wow.board.model.vo.EnquiryBoardVo;
import com.wow.board.service.BoardService;

@WebServlet("/enquiryBoard")
public class EnquiryBoardController extends HttpServlet{
	
	//화면 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("enquiryBoard 호출완료");

		String selectType = req.getParameter("selectType");
		String currentPage = req.getParameter("currentPage");
		if(currentPage == null) currentPage = "1";
		
		System.out.println("currentPage : " + currentPage);
		
		int maxPage = 5;
		req.setAttribute("maxPage", maxPage);
		
		int startPage = Integer.parseInt(currentPage) - 2 ;
		if(startPage <=0) startPage = 1;
		int endPage = startPage + 5;//pageLimit
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);

		//DB에서 가져온 게시판 정보 리스트
		List<BoardVo> E_BoardList = new BoardService().searchEnquiry(selectType, currentPage);
		req.setAttribute("E_BoardList", E_BoardList);
		for(BoardVo x : E_BoardList) {
			System.out.println("x:"+ x);
		}
		req.getRequestDispatcher("/WEB-INF/views/board/enquiryBoard.jsp").forward(req, resp);	
	}
}
	
	