package com.wow.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.admin.model.service.AdminUserService;
import com.wow.admin.model.vo.AdminVo;

@WebServlet("/user_delete")
public class UserDelete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String member_id = request.getParameter("member_id");
		System.out.println(member_id);
		AdminVo av = (AdminVo) request.getSession().getAttribute("loginAdmin");
		if(av == null) {
			response.setContentType("text/html; charset=UTF-8");
			System.out.println("관리자가 아니야");
			out.println("<script>alert('접근 권한 밖입니다.'); location.href='user_list';</script>");
			request.getRequestDispatcher("/WEB-INF/views/user/user_list");
		}else {
			AdminUserService acs = new AdminUserService();
			int result = acs.deleteUser(member_id);
			System.out.println("------삭제result---"+result);
			if(result > 0) {
				out.println("<script>alert('계정을 성공적으로 삭제하였습니다.'); location.href='user_list';</script>");
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().print("계정 삭제에 실패했습니다.");
			}
			
		}
		
		
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
