package com.wow.map.controller;

import java.io.IOException;
import java.util.List;

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
		
		String type =req.getParameter("searchType");
		String value = req.getParameter("searchValue");
		String currentPage =req.getParameter("currentPage");
		
		
		
	System.out.println(type);
	System.out.println(value);
	System.out.println("currentPage :" + currentPage);
	
	if(currentPage ==null) currentPage="1";
	
	int maxPage=5;
	req.setAttribute("maxPage", maxPage);
	
	int startPage= Integer.parseInt(currentPage)-2;
	if(startPage<=0) startPage=1;
	int endPage = startPage+5;//pageLimit
	req.setAttribute("startPage", startPage);
	req.setAttribute("endPage", endPage);
		
		List<MapModelVo> memberList=  new MapService().search(type,value,currentPage);
		
		req.setAttribute("memberList", memberList);
		
		req.getRequestDispatcher("/WEB-INF/views/member/map.jsp").forward(req, resp);
	}
	
	
	
	
}
	


