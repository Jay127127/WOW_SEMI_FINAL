package com.wow.board.contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.board.model.vo.BoardVo;
import com.wow.board.service.BoardService;

@WebServlet("/viewPost")
public class ViewPostContoller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("viewPost 요청완료");
		String boardNo = req.getParameter("boardNo");
		
		String selectType = "0";
		String currentPage ="0";
	
		List<BoardVo> boardList = new BoardService().searchView(selectType, currentPage,boardNo);
		for(BoardVo x : boardList) {
			System.out.println("x:"+ x);
		}
		req.setAttribute("boardList", boardList);
		req.getRequestDispatcher("/WEB-INF/views/board/viewPost.jsp").forward(req, resp);
	
	}
}
