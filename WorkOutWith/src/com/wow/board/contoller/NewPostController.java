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
import com.wow.board.service.BoardService;

@MultipartConfig(
		maxFileSize = 1024*1024*50,
		maxRequestSize = 1024*1024*50*5
)

@WebServlet("/newPost")
public class NewPostController extends HttpServlet{
	//글쓰기 페이지 보여주기 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("newPost 호출완료");
		req.getRequestDispatcher("WEB-INF/views/board/newPostForm.jsp").forward(req, resp);
	}

//	private static final long serialVersionUID = -4793303100936264213L;
//
//	private static final String UPLOAD_DIR = "filefolder";
//	
//	public void FileUpload() {
//	}
	
	//글쓰기 진행 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String boardCategory = req.getParameter("boardCategory");
		String boardTitle = req.getParameter("boardTitle");
		String userId = req.getSession().getId();
		String boardContent = req.getParameter("boardContent");
//		String upload_file = req.getParameter("upload_file");
		String boardOpen_YN = req.getParameter("boardOpen_YN");
		String boardDelete_YN = req.getParameter("boardDelete_YN");
//		int viewCount = req.getParameter("viewCount");
//		int likeCount = req.getParameter("likeCount");
		
		if(boardOpen_YN==null) {
			boardOpen_YN="Y";
		}
		if(boardDelete_YN==null) {
			boardDelete_YN="N";
		}
		
		//파일 읽을 준비 
		Part part = req.getPart("upload_file"); 
		if(part!=null && !"".equals(part)) {String originName = part.getSubmittedFileName(); 
		InputStream fis = part.getInputStream();
		//파일 저장 준비 // 사진 없이도 올리려면..? 
		String changeName = "" + UUID.randomUUID();
		String ext = originName.substring(originName.lastIndexOf("."), originName.length());
		String realPath = req.getServletContext().getRealPath("/upload_photos/"); 
		String filePath = realPath + File.separator + changeName + ext;
		FileOutputStream fos = new FileOutputStream(filePath);

		System.out.println("origin : " + originName);
		System.out.println("changeName : " + changeName);
		
		//파일 기록 (업로드 파일 read -> write) 
		byte buf[] = new byte[1024]; int size = 0;
		while((size = fis.read(buf)) != -1) { fos.write(buf, 0, size); }
		
		fis.close(); fos.close(); }
		
        BoardVo b = new BoardVo();
		b.setBoardCategory(boardCategory);
		b.setBoardTitle(boardTitle);
		b.setUserId(userId);
		b.setBoardContent(boardContent);	
		b.setBoardOpen_YN(boardOpen_YN);
		b.setBoardDelete_YN(boardDelete_YN);
//		b.setViewCount(viewCount);
//		b.setLikeCount(likeCount);
		
		System.out.println("boardCategory: " + boardCategory);
		System.out.println("boardTitle: " + boardTitle);
		System.out.println("userId: " + userId);
		System.out.println("boardContent: " + boardContent);
		System.out.println("boardOpen_YN: " + boardOpen_YN);
		System.out.println("boardDelete_YN: " + boardDelete_YN);

		int result = new BoardService().post(b);
		
		if(result>0) {
			//success
			req.setAttribute("msg1", "포스팅 성공");
			req.getRequestDispatcher("WEB-INF/views/board/newPostForm.jsp").forward(req, resp);
		}else {
			//error
			req.setAttribute("msg2", "포스팅 실패");
			req.getRequestDispatcher("WEB-INF/views/board/newPostForm.jsp").forward(req, resp);
		}	
	
	}
		
//
    
		
		
		
		
		
		
//================================================================================		

		
		
// 서버의 실제 경로
//	String applicationPath = req.getServletContext().getRealPath("/upload_photos/");
//	String uploadFilePath = applicationPath + UPLOAD_DIR;
//	
//	System.out.println(" LOG :: [서버 루트 경로] :: " + applicationPath);
//	System.out.println(" LOG :: [파일 저장 경로] :: " + uploadFilePath);
//	
//	// creates the save directory if it does not exists
//	File fileSaveDir = new File(uploadFilePath);
//	
//	// 파일 경로 없으면 생성
//	if (!fileSaveDir.exists()) {
//		fileSaveDir.mkdirs();
//	}
//
//    String fileName = null;
//    //Get all the parts from request and write it to the file on server
//    for (Part part : req.getParts()) {
//    	getPartConfig(part);
//        fileName = getFileName(part);
//        System.out.println(" LOG :: [ 업로드 파일 경로 ] :: " + uploadFilePath + File.separator + fileName);
//        part.write(uploadFilePath + File.separator + fileName);
//    }
//    req.setAttribute("fileName", fileName);
//    getServletContext().getRequestDispatcher("/WEB-INF/views/board/newPostForm.jsp").forward(req,resp);

	
	

//	/**
//	 * https://docs.oracle.com/javaee/6/api/javax/servlet/http/Part.html
//	 * 
//	 * multipart/form-data 사용시 HttpServletRequest의 멤버 변수 중 Part의 형태로 전달됨
//	 * 
//	 * @param part
//	 */
//	private void getPartConfig(Part part) {
//		System.out.println("------------------------------------------------------------");
//		System.out.println(" LOG :: [HTML태그의 폼태그 이름] :: " + part.getName());
//		System.out.println(" LOG :: [ 파일 사이즈 ] :: " + part.getSize());
//		for(String name : part.getHeaderNames()) {
//			System.out.println(" LOG :: HeaderName :: " + name + ", HeaderValue :: " + part.getHeader(name) + "\n");
//		}
//		System.out.println("------------------------------------------------------------");
//	}
//	
//    /**
//     * Utility method to get file name from HTTP header content-disposition
//     */
//    private String getFileName(Part part) {
//        String contentDisp = part.getHeader("content-disposition");
//        System.out.println(" LOG :: content-disposition 헤더 :: = "+contentDisp);
//        String[] tokens = contentDisp.split(";");
//        for (String token : tokens) {
//            if (token.trim().startsWith("filename")) {
//            	System.out.println(" LOG :: 파일 이름 :: " + token);
//                return token.substring(token.indexOf("=") + 2, token.length()-1);
//            }
//        }
//        return "";
//    }
//		
//    	
}



