package com.wow.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.admin.model.service.AdminCreateService;
import com.wow.admin.model.vo.AdminVo;

@WebServlet("/admin_login")
public class AdminLogin extends HttpServlet{
	
	//LoginController 로 보면 된다.
	//로그인 화면 보여줌
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/admin/admin_login.jsp").forward(request, response);
	}
	
	//로그인 진행
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String admin_id = request.getParameter("admin_id");
		String admin_pwd = request.getParameter("admin_pwd");
		
		AdminVo a = new AdminVo();
		a.setAdmin_id(admin_id);
		a.setAdmin_pwd(admin_pwd);
		
		AdminVo loginAdmin = new AdminCreateService().adLogin(a);
		
		if(loginAdmin != null) {
			//success
			request.setAttribute("msg", "Admin로그인 성공");
			System.out.println("성공");
			
			//로그인한 정보를 서버was가 계속 알고 있게
			request.getSession().setAttribute("loginAdmin", loginAdmin);
			request.getRequestDispatcher("/WEB-INF/views/admin/admin.jsp").forward(request, response);
		} else {
			//error
			request.setAttribute("msg", "로그인 실패");
			request.getRequestDispatcher("/WEB-INF/views/common/adLoginError.jsp").forward(request, response);
		}
	}
}
