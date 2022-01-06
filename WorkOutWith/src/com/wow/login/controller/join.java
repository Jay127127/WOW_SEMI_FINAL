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
		int question = Integer.parseInt(req.getParameter("join_question"));
		String answer = req.getParameter("join_answer");
		String name = req.getParameter("name");
		String gender = req.getParameter("question1");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String nickname = req.getParameter("nickname");
		String qna1 = req.getParameter("question1");
		String qna2 = req.getParameter("question2");
		String qna3 = req.getParameter("question3");
		String qna4 = req.getParameter("question4");
		String qna5 = req.getParameter("question5");
		
		MemberVo m = new MemberVo();
		m.setId(id);
		m.setPwd(pwd);
		m.setQuestion_num(question);
		m.setQuestion_answer(answer);
		m.setName(name);
		m.setGender(gender);
		m.setAddress(address);
		m.setEmail(email);
		m.setNick(nickname);
		m.setQna1(qna1);
		m.setQna2(qna2);
		m.setQna3(qna3);
		m.setQna4(qna4);
		m.setQna5(qna5);
		
		int result = new MemberService().join(m);
		
		if(result > 0) {
			//success
			req.setAttribute("msg", "회원가입 성공");
			req.setAttribute("ok", "3");
			req.getRequestDispatcher("WEB-INF/views/login/login.jsp").forward(req, resp);
		}else {
			//error
			req.setAttribute("msg", "회원가입 실패");
			req.setAttribute("ok", "1");
			req.getRequestDispatcher("WEB-INF/views/login/join.jsp").forward(req, resp);
		}
		
	}
}
