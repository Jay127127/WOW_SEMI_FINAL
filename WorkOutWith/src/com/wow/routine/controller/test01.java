package com.wow.routine.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet
public class test01 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html: charset=UTF-8");
		
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		
		String str = req.getParameter("str");
		String op = req.getParameter("operator");
		
		if(op.equals("출력")) {
			String x = (String)session.getAttribute("str_");
			String y = str;
			
			out.println(x+""+y);	
		}else {
			session.setAttribute("str_", str);	
		}	
	}
}
