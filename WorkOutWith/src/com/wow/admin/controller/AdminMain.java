package com.wow.admin.controller;

import java.sql.Connection;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.admin.model.service.AdminBoardService;
import com.wow.admin.model.service.AdminUserService;
import com.wow.admin.model.vo.BoardVo;
import com.wow.admin.model.vo.UserVo;
import static com.wow.common.JDBCTemplate.*;

@WebServlet("/admin")
public class AdminMain extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = getConnection();
		
		String type = request.getParameter("searchType");
		String value = request.getParameter("searchValue");
		String currentPage = request.getParameter("currentPage");
		if(currentPage == null || currentPage == "") currentPage = "1";
		
		System.out.println(type);
		System.out.println(value);
		System.out.println(currentPage);
		
		AdminBoardService abs = new AdminBoardService();
		//조회 결과를 담은 유저 리스트
		List<BoardVo> boardList = (List<BoardVo>) abs.searchNo(type, value, currentPage);
		request.setAttribute("boardList", boardList);
		
		//maxPage 갖고오기
		request.setAttribute("maxPage", abs.getMaxPage());
		//prevPage 갖고오기
		request.setAttribute("prevPage", abs.getPrevPage());
		//nextPage 갖고오기
		request.setAttribute("nextPage", abs.getNextPage());
		//type과 value 저장
		request.setAttribute("type", type);
		request.setAttribute("value", value);
		
		int	startPage = 1;
		request.setAttribute("startPage", startPage);
		
//		=============
		
		AdminUserService aus = new AdminUserService();
		int c = aus.countUserAll(conn);
		System.out.println("cccccc: "+c);
		request.setAttribute("c", c);
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/admin/admin.jsp").forward(request, response);
	}
}
