

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>


</style>


</head>
<body>


	

	<header>
	
	
	
	<%@ include file="../common/header_nav.jsp"%>
	
		
	
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
		</tr>
		
		<tr>
			<td>0</td>
			<td>안녕하세요 제목</td>
			<td>이건내용에요요 내용</td>
			<td>이상민 작성자</td>
		</tr>
		
		
		
		<%--
		
	     JSTL , EL 
		
			<% 
			
			for(BoardVo b: dataList){
				String no=b.getBoardNo();
				String title=b.getTitle();
				String content = b.getContent();
				String writer = b.getWriter();
			%>	
			<tr>
				<td><%=no %></td>
				<td><%=title %></td>
				<td><%=content %></td>
				<td><%=writer %></td>
			</tr>
				
		   <%} %>	
		   	   
		    --%>
		   
		   
		   
		   <c:forEach items="${data}" var="b">
		   	<tr>
				<td>${b.boardNo}</td>
				<td>${b.title}</td>
				<td>${b.content}</td>
				<td>${b.writer}</td>
			</tr>
		   </c:forEach>
	</table>	
		   
		   <input type="submit" value="글쓰기">
            <a href="wirte">글쓰기</a>
            
             <div id="div-main">
        <form action="join" method="post" enctype="multipart/form-data">
            <label>아이디   : </label> <input type="text" name="id" id="idBox">
            <br>
            <label>비밀번호 : </label> <input type="text" name="pwd">
            <br>
            <label>이름   : </label> <input type="text" name="name">
            <br>
            <label>프로필 사진 ; </label> <input type="file" name="profile">
            <input type="submit" value="가입하기">
        </form>
    </div>
            
            
            
		   
		   </header>
			
			
		
		
	

	
	
	

	
	
	
	
	


	

</body>
</html>