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
		System.out.println("아이디 : "+admin_id);
		System.out.println("비밀번호 : "+admin_pwd);
		
		AdminVo a = new AdminVo();
		a.setAdmin_id(admin_id);
		a.setAdmin_pwd(admin_pwd);
		
		AdminVo loginAdmin = new AdminCreateService().adLogin(a);
		System.out.println("과연?"+loginAdmin);
		
		int result = new AdminCreateService().dupCheck(a.getAdmin_id());
		
		//아이디가 DB에 없다면
		if(result <= 0) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print("없는 계정입니다. 다시 입력해주세요.");
		} else {
			if(loginAdmin != null) {
			//success
				System.out.println("성공");
			
			//로그인한 정보를 서버was가 계속 알고 있게
				request.getSession().setAttribute("loginAdmin", loginAdmin);
				request.getRequestDispatcher("/WEB-INF/views/admin/admin.jsp").forward(request, response);
			} else {
			//error, 즉 비밀번호가 일치하지 않으면
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print("비밀번호가 일치하지 않습니다.");	
			}
		}
	}
}
