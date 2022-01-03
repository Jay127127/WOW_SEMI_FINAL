package com.wow.login.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.common.JDBCTemplate;
import com.wow.login.model.service.MemberService;
import com.wow.login.model.vo.MemberVo;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	// 로그인 화면 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd1");
		
		MemberVo m = new MemberVo();
		m.setId(id);
		m.setPwd(pwd); 
		
		MemberVo loginUser = new MemberService().login(m);
		
		if(loginUser != null) {
			//success
			req.setAttribute("msg", "로그인 성공");
			req.getSession().setAttribute("loginUser", loginUser);
			req.getRequestDispatcher("WEB-INF/views/home.jsp").forward(req, resp);
		}else {
			//error
			req.setAttribute("msg", "로그인 실패");
			req.setAttribute("ok", "1");
			req.getRequestDispatcher("WEB-INF/views/login/login.jsp").forward(req, resp);
		}
	}
}
