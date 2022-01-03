package com.wow.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//AllMemberController
@WebServlet("/admin_list")
public class AdminList extends HttpServlet {

	//화면 보여주기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("searchType");
		String value = request.getParameter("searchValue");
		String currentPage = request.getParameter("currentPage");
		if(currentPage == null) currentPage = "1";
		
		System.out.println(type);
		System.out.println(value);
		System.out.println(currentPage);
		
		//나중에 고쳐야할것??
		int maxPage = 3;
		request.setAttribute("maxPage", maxPage);
		
		int startPage = Integer.parseInt(currentPage); 
		
		request.getRequestDispatcher("WEB-INF/views/admin/admin_list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
