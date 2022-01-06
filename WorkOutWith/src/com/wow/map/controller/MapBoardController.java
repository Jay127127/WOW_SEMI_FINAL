package com.wow.map.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.map.model.vo.MapModelVo;
import com.wow.map.service.MapService;

@WebServlet("/mapwrite")
public class MapBoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/map/mapWrite.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		
		MapModelVo m =new MapModelVo();
		m.setTitle(title);
		m.setName(name);
		m.setContent(content);
		System.out.println(m.getTitle());
		
		int result = new MapService().join(m);
		
		if(result>0) {
			//success
			request.setAttribute("msg", "");
			request.getRequestDispatcher("WEB-INF/views/map/map.jsp").forward(request, response);
		}else {
			//error
			request.setAttribute("msg", "회원가입 실패");
			request.getRequestDispatcher("WEB-INF/views/map/error.jsp").forward(request, response);
		}
	
	}
}
