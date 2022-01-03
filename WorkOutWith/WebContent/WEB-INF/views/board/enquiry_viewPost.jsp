<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
				<form method="post" action="enquiryBoard">
					<table class="table table-striped" style="text-align: canter; border: 1px solid grey;">
						<thead>
							<tr>
								<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글쓰기</th>
								
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="text" class="form-contorl" placeholder="글제목" name="E_boardTitle" maxlength="50"></td>
							</tr>
							<tr>
								<td><textarea class="form-contorl" placeholder="글내용" name="E_boardContent" maxlength="3000" style="heigt: 500px;"></textarea></td>
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
						<input type="submit" class=" btn btn-primary pull-right" value="보내기">
					<%
						}
					%> --%>
				</form>
			</div>
		</div>
	</body>
</html>