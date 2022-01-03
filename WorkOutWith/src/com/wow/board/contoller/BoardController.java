package com.wow.board.contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.board.model.vo.BoardVo;
import com.wow.board.service.NewPostService;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("board 호출완료");
//		
//	}	
//	//화면 보여주기
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String type = req.getParameter("searchType");
			String value = req.getParameter("searchValue");
			String currentPage = req.getParameter("currentPage");
			if(currentPage == null) currentPage = "1";
			
			System.out.println(type);
			System.out.println(value);
			System.out.println("currentPage : " + currentPage);
			
			int maxPage = 5;
			req.setAttribute("maxPage", maxPage);
			
			int startPage = Integer.parseInt(currentPage) - 2 ;
			if(startPage <=0) startPage = 1;
			int endPage = startPage + 5;//pageLimit
			req.setAttribute("startPage", startPage);
			req.setAttribute("endPage", endPage);
	
			
			List<BoardVo> boardList = new NewPostService().search(type, value, currentPage);
			
			req.setAttribute("boardList", boardList);
			
			req.getRequestDispatcher("/WEB-INF/views/board/board.jsp").forward(req, resp);
		}
	}

}


