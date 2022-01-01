package com.wow.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.admin.model.service.AdminCreateService;

@WebServlet("/adminDupCheck")
public class AdminDupCheck extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("어드민id ajax 요청 들어옴!!");
//		*** ajax의 data의 **key** 를 받는 것!!***
		String id = request.getParameter("id");
		System.out.println("아이디 : "+id);
		
		//입력받은 아이디를 DB의 데이터랑 비교해서, 중복이 있는지 확인, 결과 반환
		//result : 중복 개수
		int result = new AdminCreateService().dupCheck(id);
		
		if(result>0) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print("중복된 계정입니다.");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print("사용가능한 계정입니다.");			
		}
	}
}
