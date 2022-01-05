package com.wow.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.admin.model.service.AdminCreateService;
import com.wow.admin.model.vo.AdminVo;


@WebServlet("/admin_info")
public class AdminInfo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/views/admin/admin_info.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String admin_pwd1 = request.getParameter("admin_pwd1");
		String admin_pwd2 = request.getParameter("admin_pwd2");
		String admin_nik = request.getParameter("admin_nik");
		String admin_email = request.getParameter("admin_email");

//		System.out.println("아이디 : "+admin_id);
		System.out.println("비밀번호1 : "+admin_pwd1);
		System.out.println("비밀번호2 : "+admin_pwd2);
		System.out.println("닉: "+admin_nik);
		System.out.println("이메일: "+admin_email);
		AdminVo a = (AdminVo) request.getSession().getAttribute("loginAdmin");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(a == null)
			out.println("<script>location.href='admin_login';</script>");
		
		a.setAdmin_pwd(admin_pwd1);
		a.setAdmin_nik(admin_nik);
		a.setAdmin_email(admin_email);
		
		AdminCreateService acs = new AdminCreateService();
		int result = acs.updateAdmin(a);
		System.out.println("비밀번호1 : "+a.getAdmin_pwd());
		System.out.println("닉: "+a.getAdmin_nik());
		System.out.println("이메일: "+a.getAdmin_email());
		if(result > 0 && (admin_pwd1.equals(admin_pwd2))) {
			out.println("<script>alert('나의 정보가 수정되었습니다.'); location.href='admin_info';</script>");
			response.getWriter().print("나의 정보가 수정되었습니다.");
			System.out.println("수정성공");
//			request.getRequestDispatcher("/WEB-INF/views/admin/admin.jsp").forward(request, response);
		} else {
//			response.getWriter().print("올바른 값을 입력하세요.");
			System.out.println("수정실패");
		}
		
//		String admin_id = request.getParameter("admin_id");
				
	}

}
