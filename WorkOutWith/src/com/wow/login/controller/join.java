package com.wow.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.login.model.service.MemberService;
import com.wow.login.model.vo.MemberVo;

@WebServlet("/join")
public class join extends HttpServlet{
	// 회원가입 화면 보여줌
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/login/join.jsp").forward(req, resp);
	}
	
	// 회원가입 진행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd1");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String nickname = req.getParameter("nickname");
		
		MemberVo m = new MemberVo();
		m.setId(id);
		m.setPwd(pwd);
		m.setName(name);
		m.setAddress(address);
		m.setEmail(email);
		m.setNick(nickname);
		
		int result = new MemberService().join(m);
		
		if(result > 0) {
			//success
			req.setAttribute("msg", "회원가입 성공");
			req.getRequestDispatcher("WEB-INF/views/common/join_successPage.jsp").forward(req, resp);
		}else {
			//error
			req.setAttribute("msg", "회원가입 실패");
			req.getRequestDispatcher("WEB-INF/views/common/join_errorPage.jsp").forward(req, resp);
		}
		
	}
}
