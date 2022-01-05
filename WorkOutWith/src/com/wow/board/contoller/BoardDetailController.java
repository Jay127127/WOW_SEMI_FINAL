package com.wow.board.contoller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.board.model.vo.BoardVo;
import com.wow.board.service.BoardService;
import com.wow.common.JDBCTemplate;

@WebServlet("/boardDetail")
public class BoardDetailController extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("boardDetail 호출완료");
//		request.getRequestDispatcher("WEB-INF/views/board/boardDetail.jsp").forward(request, response);
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String boardNo = request.getParameter("boardNo");
		
		BoardVo b = new BoardVo();
		String boardNo = "0";
	
		
		
		if(!"".equals(request.getParameter("boardNo"))&&request.getParameter("boardNo")!=null){
			boardNo = request.getParameter("boardNo");
		}
		
		System.out.println("pageNo: " + boardNo);
		
		int result = new BoardService().viewUpdate(b);
		
		if(result>0) {
			//success
			request.setAttribute("msg", "업데이트 성공");
			request.getRequestDispatcher("WEB-INF/views/board/boardDetail.jsp").forward(request, response);
		}else {
			//error
			request.setAttribute("msg", "업데이트 실패");
			request.getRequestDispatcher("WEB-INF/views/board/boardDetail.jsp").forward(request, response);
		}	
	}
	
}
