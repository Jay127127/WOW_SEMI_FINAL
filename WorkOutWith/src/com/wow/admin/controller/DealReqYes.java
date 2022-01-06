package com.wow.admin.controller;

import java.io.IOException;
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


@WebServlet("/deal_req_yes")
public class DealReqYes extends HttpServlet {

	//화면 보여주기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String typeY = request.getParameter("searchTypeY");
		String valueY = request.getParameter("searchValueY");
		String currentPageY = request.getParameter("currentPageY");
		if(currentPageY == null || currentPageY == "") currentPageY = "1";
		
		System.out.println(typeY);
		System.out.println(valueY);
		System.out.println(currentPageY);
		
		AdminBoardService abs =  new AdminBoardService();
		//조회 결과를 담은 유저 리스트
		List<BoardVo> boardListYes = (List<BoardVo>) abs.search(typeY, valueY, currentPageY);
		request.setAttribute("boardListYes", boardListYes);
		
		//maxPage 갖고오기
		request.setAttribute("maxYPage", abs.getMaxYPage());
		//prevPage 갖고오기
		request.setAttribute("prevYPage", abs.getPrevYPage());
		//nextPage 갖고오기
		request.setAttribute("nextYPage", abs.getNextYPage());
		//type과 value 저장
		request.setAttribute("typeY", typeY);
		request.setAttribute("valueY", valueY);
		
		int	startPageY = 1;
		request.setAttribute("startPageY", startPageY);
		
		request.getRequestDispatcher("WEB-INF/views/admin/deal_req.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
