package com.wow.board.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newPost")
public class NewPostController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("newPost 호출완료");
		req.getRequestDispatcher("WEB-INF/views/board/newPost.jsp").forward(req, resp);
	
	
	}
}
