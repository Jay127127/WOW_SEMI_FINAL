package com.wow.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.login.model.service.MemberService;
import com.wow.login.model.vo.MemberVo;

@WebServlet("/search_pwd")
public class search_pwd extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/login/search_pwd.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("member_email");
		int question = Integer.parseInt(req.getParameter("join_question"));
		String answer = req.getParameter("join_answer");
		
		MemberVo m = new MemberVo();
		m.setEmail(email);
		m.setQuestion_num(question);
		m.setQuestion_answer(answer);
		
		MemberVo searchPwd = new MemberService().search(m);
		
		if(searchPwd != null) {
			//success
			String userPwd = searchPwd.getPwd();
			req.setAttribute("pwd", userPwd);
			req.setAttribute("ok", "1");
			req.getRequestDispatcher("WEB-INF/views/login/search_pwd.jsp").forward(req, resp);
		}else {
			//error
			req.setAttribute("pwd", "비밀번호찾기 실패");
			req.setAttribute("ok", "2");
			req.getRequestDispatcher("WEB-INF/views/login/search_pwd.jsp").forward(req, resp);
		}
		
		
	}
}
