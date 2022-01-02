package com.wow.board.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/routinePage")
public class RoutinePageContoller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("routinePage 요청완료");
		req.getRequestDispatcher("WEB-INF/views/board/routinePage.jsp").forward(req, resp);
	
	}
}



