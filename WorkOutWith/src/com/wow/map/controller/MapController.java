package com.wow.map.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.map.model.vo.MapModelVo;
import com.wow.map.service.MapService;


@WebServlet("/map")
public class MapController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/map/map.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		
		MapModelVo m =new MapModelVo();
		m.setId(id);
		m.setPwd(pwd);
		m.setName(name);
		
		int result = new MapService().join(m);
		
		if(result>0) {
			//success
			req.setAttribute("msg", "회원가입 성공");
			req.getRequestDispatcher("WEB-INF/views/common/successPage.jsp").forward(req, resp);
		}else {
			//error
			req.setAttribute("msg", "회원가입 실패");
			req.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}
	

}
