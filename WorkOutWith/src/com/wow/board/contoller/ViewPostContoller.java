package com.wow.board.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewPost")
public class ViewPostContoller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("viewPost 요청완료");
		req.getRequestDispatcher("WEB-INF/views/board/viewPost.jsp").forward(req, resp);
	
	}
}
