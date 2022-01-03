package com.wow.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.login.model.service.MemberService;

@WebServlet("/memberDupCheck")
public class MemberDupCheck extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		// 입력받은 아이디, DB의 아이디와 중복 비교
		int result = new MemberService().dupCheck(id);
		
		if(result > 0 ) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("이미 사용중인 아이디 입니다.");
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("사용 가능한 아이디 입니다.");
		}
//		if("admin".equals(id)) {
//			resp.setContentType("text/html; charset=UTF-8");
//			resp.getWriter().print("관리자입니다");
//		}else {
//			resp.setContentType("text/html; charset=UTF-8");
//			resp.getWriter().print("관리자가 아닙니다");
//		}
	}
	
}
