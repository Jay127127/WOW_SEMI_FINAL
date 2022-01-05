package com.wow.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminMain extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//adimin 각각의 페이지 자체가 admin계정으로 로그인해야 나올 수 있는 화면
//		String loginAdmin = (String) request.getSession().getAttribute("loginAdmin");//object를 string으로 다운캐스팅
////		String name = request.getParameter("name");
//		//1-1. id없이는 진입불가, id없는 경우 로그인페이지로 이동
//		if(loginAdmin == null){
//			request.getRequestDispatcher("/WEB-INF/views/admin/admin_login.jsp").forward(request, response);
////			response.sendRedirect("/admin_login");
//		}
		request.getRequestDispatcher("/WEB-INF/views/admin/admin.jsp").forward(request, response);
	}
}
