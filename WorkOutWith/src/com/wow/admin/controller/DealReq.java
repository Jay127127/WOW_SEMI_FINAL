package com.wow.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.admin.model.service.AdminBoardService;
import com.wow.admin.model.vo.BoardVo;


@WebServlet("/deal_req")
public class DealReq extends HttpServlet {

	//화면 보여주기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("searchType");
		String value = request.getParameter("searchValue");
		String currentPage = request.getParameter("currentPage");
		if(currentPage == null || currentPage == "") currentPage = "1";
		
		System.out.println(type);
		System.out.println(value);
		System.out.println(currentPage);
		
		AdminBoardService abs =  new AdminBoardService();
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
		
//		==============
		
		String typeY = request.getParameter("searchTypeY");
		String valueY = request.getParameter("searchValueY");
		String currentPageY = request.getParameter("currentPageY");
		if(currentPageY == null || currentPageY == "") currentPageY = "1";
		
		System.out.println(typeY);
		System.out.println(valueY);
		System.out.println(currentPageY);
		
		AdminBoardService absc =  new AdminBoardService();
		//조회 결과를 담은 유저 리스트
		List<BoardVo> boardListYes = (List<BoardVo>) absc.search(typeY, valueY, currentPageY);
		request.setAttribute("boardListYes", boardListYes);
		
		//maxPage 갖고오기
		request.setAttribute("maxYPage", absc.getMaxYPage());
		//prevPage 갖고오기
		request.setAttribute("prevYPage", absc.getPrevYPage());
		//nextPage 갖고오기
		request.setAttribute("nextYPage", absc.getNextYPage());
		//type과 value 저장
		request.setAttribute("typeY", typeY);
		request.setAttribute("valueY", valueY);
		
		int	startPageY = 1;
		request.setAttribute("startPageY", startPageY);
		
//		request.getRequestDispatcher("WEB-INF/views/admin/deal_req.jsp").forward(request, response);

		
		request.getRequestDispatcher("WEB-INF/views/admin/deal_req.jsp").forward(request, response);
	}
	
	

}
