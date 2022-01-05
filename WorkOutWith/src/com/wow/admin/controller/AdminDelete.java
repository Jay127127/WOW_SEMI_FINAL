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

import com.wow.admin.model.service.AdminCreateService;
import com.wow.admin.model.vo.AdminVo;

@WebServlet("/admin_delete")
public class AdminDelete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String admin_id = request.getParameter("admin_id");
		System.out.println(admin_id);
		AdminVo av = (AdminVo) request.getSession().getAttribute("loginAdmin");
		if(av == null || !"admin1".equals(av.getAdmin_id())) {
			response.setContentType("text/html; charset=UTF-8");
			System.out.println("admin1이 아니야");
			out.println("<script>alert('접근 권한 밖입니다.'); location.href='admin_list';</script>");
//			response.getWriter().print("접근 권한 밖입니다.");
			request.getRequestDispatcher("/WEB-INF/views/admin/admin_list");
		}else {
			
			AdminCreateService acs = new AdminCreateService();
			int result = acs.deleteAdmin(admin_id);
			System.out.println("------삭제result---"+result);
			if(result > 0) {
				out.println("<script>alert('계정을 성공적으로 삭제하였습니다.'); location.href='admin_list';</script>");
				System.out.println("삭제 성공");
//				response.setContentType("text/html; charset=UTF-8");
//				response.getWriter().print("계정을 성공적으로 삭제하였습니다.");
//				request.getRequestDispatcher("/WEB-INF/views/admin/admin_list");
			}else {
				System.out.println("삭제 실패");
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().print("계정 삭제에 실패했습니다.");
			}
			
		}
		
//		int result = acs.deleteAdmin(admin_id);
		
		
		
		
		
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
