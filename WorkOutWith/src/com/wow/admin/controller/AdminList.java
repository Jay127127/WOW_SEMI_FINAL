package com.wow.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.admin.model.service.AdminCreateService;
import com.wow.admin.model.vo.AdminVo;

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
		
		AdminCreateService acs =  new AdminCreateService();
		//조회 결과를 담은 어드민 리스트
		List<AdminVo> adminList = acs.search(type, value, currentPage);
		request.setAttribute("adminList", adminList);
		
		//maxPage 갖고오기
		request.setAttribute("maxPage", acs.getMaxPage());
		//prevPage 갖고오기
		request.setAttribute("prevPage", acs.getPrevPage());
		//nextPage 갖고오기
		request.setAttribute("nextPage", acs.getNextPage());
		//type과 value 저장
		request.setAttribute("type", type);
		request.setAttribute("value", value);
		
		int	startPage = 1;
		request.setAttribute("startPage", startPage);
		
		request.getRequestDispatcher("WEB-INF/views/admin/admin_list.jsp").forward(request, response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
