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

import com.wow.admin.model.service.AdminBoardService;
import com.wow.admin.model.service.AdminUserService;
import com.wow.admin.model.vo.AdminVo;

@WebServlet("/update_board")
public class UpdateBoard extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int boardNo = Integer.valueOf(request.getParameter("boardNo"));
		System.out.println("처리보드넘"+boardNo);
		AdminVo av = (AdminVo) request.getSession().getAttribute("loginAdmin");
		if(av == null) {
			response.setContentType("text/html; charset=UTF-8");
			System.out.println("관리자가 아니야");
			out.println("<script>alert('접근 권한 밖입니다.'); location.href='deal_req';</script>");
			request.getRequestDispatcher("/WEB-INF/views/user/deal_req.jsp");
		}else {
			AdminBoardService abs = new AdminBoardService();
			int result = abs.updateBoard(boardNo);
			System.out.println("------문의처리result---"+result);
			if(result > 0) {
				out.println("<script>alert('문의글을 성공적으로 처리하였습니다.'); location.href='deal_req';</script>");
				System.out.println("문의처리 성공");
			}else {
				System.out.println("문의처리 실패");
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().print("문의처리에 실패했습니다.");
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
