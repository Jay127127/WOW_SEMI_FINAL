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
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("board 호출완료");
		
//		
//		List<BoardVo> boardList = new NewPostService().selectBoard();
//		
//		req.setAttribute("boardList", boardList);
		req.getRequestDispatcher("/WEB-INF/views/board/board.jsp").forward(req, resp);
		
	
	}
}


