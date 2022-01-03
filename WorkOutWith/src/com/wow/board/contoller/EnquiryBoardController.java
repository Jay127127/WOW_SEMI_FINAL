package com.wow.board.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.board.Dao.EnquiryBoardDao;
import com.wow.board.model.vo.BoardVo;
import com.wow.board.model.vo.EnquiryBoardVo;
import com.wow.board.service.EnquiryBoardService;
import com.wow.board.service.NewPostService;

@WebServlet("/enquiryBoard")
public class EnquiryBoardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("enquiryBoard 호출완료");
		request.getRequestDispatcher("/WEB-INF/views/board/enquiryBoard.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title  = request.getParameter("E_boardTitle");
		String content = request.getParameter("E_boardContent");
		
		EnquiryBoardVo ev = new EnquiryBoardVo();
		ev.setE_boardTitle(title);
		ev.setE_boardContent(content);
		
		int result = new EnquiryBoardService().postingEnquiry(ev);
		if(result>0) {
			request.setAttribute("msg","글쓰기 성공");
			request.getRequestDispatcher("WEB-INF/views/board/newPost.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "글쓰기 실패");
			request.getRequestDispatcher("WEB-INF/views/board/newPost.jsp").forward(request, response);
			
		}
		System.out.println(result);
	
//		String userId = null;
//		if(session.getAttribute("userId")!=null) {
//			userId = (String)session.getAttribute("userId");
//		}
//		if(userId == null) {
//			PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('로그인을 해주세요'");
//			script.println("location.href='/wow/login'");
//			script.println("</script>");
//		}else {
//			if(ev.getE_boardTitle() == null || ev.getE_boardContent() == null) {
//				PrintWriter script = response.getWriter();
//				script.println("<script>");
//				script.println("alert('입력되지 않은 사항들이 있습니다.'");
//				script.println("history.back()");
//				script.println("</script>");
//			}else {
//				EnquiryBoardDao ebdao = new EnquiryBoardDao();
//				int result = ebdao.insertEnquiryPost(conn, ev);
//				if(result == -1) {
//					PrintWriter script = response.getWriter();
//					script.println("<script>");
//					script.println("alert('글쓰기에 실패하였습니다.'");
//					script.println("history.back()");
//					script.println("</script>");
//				}else {
//					PrintWriter script = response.getWriter();
//					script.println("<script>");
//					script.println("location.href='/wow/enquiryBoard'");
//					script.println("</script>");
//				}
//			}
//		}
	}
}



