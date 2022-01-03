<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.wow.board.Dao.EnquiryBoardDao" %>
<%@ page import="com.wow.board.model.vo.EnquiryBoardVo" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enquiry Board</title>
    
	<!-- Bootstap Fluid Container -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
    integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

    <!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- css file link -->
    <link rel="stylesheet" type="text/css" href="assets/CSS/board_basic.css">
    
</head>
<body>

	<%
		//String userID = null;
		//if(session.getAttibute("userID")!=null){
		//	userID=(String)session.getAttribute("userID");
		//}
		//int pageNumber =1;
		//if(request.getParameter("pageNumber")!=null){
		//	pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		//}
	%>
	
	<!-- -------------- navbar -------------- -->
	<%@ include file="../common/header_nav.jsp"%>
	
	<!-- -------------- 본문 시작 -------------- -->
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: canter; border: 1px solid grey;">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">No.</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">날짜</th>
						<th style="background-color: #eeeeee; text-align: center;">조회수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
					
					<%
/* 						int pageNumber = 0; */
						EnquiryBoardDao ebdao = new EnquiryBoardDao();
						ArrayList<EnquiryBoardVo> list = ebdao.getList(pageNumber);
						for(int i = 0; i < list.size(); i++){
					%>
						<td><%= list.get(i).getE_boardNO() %></td>
						<td><a href = "view.jsp?E_boardId=<%=list.get(i).getE_userId() %>"><%=list.get(i).getE_boardTitle() %></a></td>
						<td><%= list.get(i).getE_userId() %></td>
						<td><%= list.get(i).getE_boardDate().substring(0, 11) + list.get(i).getE_boardDate().substring(11,13)+":"+ list.get(i).getE_boardDate().substring(14, 16) %></td>
						<td>0</td>
					</tr>
					<% 
						}
					%>
				</tbody>
			</table>
			
			<%-- <%
				if(pageNumber != 1){
			%>
				<a href="enquiryBoaard.jsp?pageNumber=<%=pageNumber-1 %>" class="btn btn-arrow-left">이전</a>
			<%
				}if(ebdao.nextPage(pageNumber+1)){
			%>
				<a href="enquiryBoaard.jsp?pageNumber=<%=pageNumber+1 %>" class="btn btn-arrow-left">다음</a>
			<%		
				}
			%>
			
			<%
				if(userID == null){
			%>
				<button alert="로그인을 해주세요.">글쓰기</button>
			<%
				}else {
			%>
				<a href="/wow/enquiry_newPost.jsp">글쓰기</a>
			<%
				}
			%> --%>
			
		</div>
	</div>
</body>
</html>


a

