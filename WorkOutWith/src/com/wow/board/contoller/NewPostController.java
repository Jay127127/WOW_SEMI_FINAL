package com.wow.board.contoller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.wow.board.model.vo.BoardVo;
import com.wow.board.service.NewPostService;

@MultipartConfig(
		maxFileSize = 1024*1024*5,
		maxRequestSize = 1024*1024*5*5
)

@WebServlet("/newPost")
public class NewPostController extends HttpServlet{
	//글쓰기 페이지 보여주기 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("newPost 호출완료");
		req.getRequestDispatcher("WEB-INF/views/board/newPost.jsp").forward(req, resp);
	}
	
	//글쓰기 진행 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title");
		String category_select = req.getParameter("category_select");
//		String upload_file = req.getParameter("upload_file");
		String secret = req.getParameter("secret");
		String content = req.getParameter("text_area");

		//파일 읽을 준비
		Part part = req.getPart("upload_file");
		if(part!=null) {
			String originName = part.getSubmittedFileName();
			InputStream fis = part.getInputStream();
			
			//파일 저장 준비
			String changeName = "" + UUID.randomUUID();
			String ext = originName.substring(originName.lastIndexOf("."), originName.length());
			String realPath = req.getServletContext().getRealPath("/upload_photos/");
			String filePath = realPath + File.separator + changeName + ext;
			FileOutputStream fos = new FileOutputStream(filePath);
			
			System.out.println("origin : " + originName);
			System.out.println("changeName : " + changeName);
			
			//파일 기록 (업로드 파일 read -> write)
			byte buf[] = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			
			fis.close();
			fos.close();
		}
				
		
		BoardVo b = new BoardVo();
		b.setTitle(title);
		b.setCategory_select(category_select);
		b.setBoardAvailable(secret);
		b.setText_area(content);		
		
		System.out.println(title);
		System.out.println(category_select);
		System.out.println(secret);
		System.out.println(content);
		System.out.println(part);

		int result = 0;
		try {
			result = new NewPostService().post(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}



