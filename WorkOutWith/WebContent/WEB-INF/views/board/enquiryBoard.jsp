	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html lang="ko">
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Page1</title>
	    
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
	
		<body>
		
		
		<!-- -------------- navbar -------------- -->
		<%@ include file="../common/header_nav.jsp"%>
			
			
		<!-- -------------- 본문 시작 -------------- -->
		
			<%
				/* String userID = null;
				if(session.getAttibute("userID")!=null){
					userID=(String)session.getAttribute("userID");
				} */
			%>
			
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
								<td>1</td>
								<td>안녕</td>
								<td>지지</td>
								<td>2012.12.12</td>
								<td>0</td>
							</tr>
						</tbody>
					</table>
					<%-- <%
						if(userID == null){
					%>
						<button alert="로그인을 해주세요.">글쓰기</button>
					<%
						}else {
					%>
						<a href="writeEnquiry.jsp">글쓰기</a>
					<%
						}
					%> --%>
					
				</div>
			</div>
		</body>
		</html>
	
	
	a