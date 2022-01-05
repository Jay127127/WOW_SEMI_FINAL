<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<header>
	
	<%@ include file="../common/header_nav.jsp"%>
	
	
 	</header>
    
    <div id="div-main">
        <form action="write" method="post" enctype="multipart/form-data">
            <label>제목   : </label> <input type="text" name="title" id="idBox">
            <br>
            <label>내용 : </label> <input type="text" name="content">
            <br>
            <label>작성자   : </label> <input type="text" name="writer">
            <br>
            <input type="submit" value="글쓰기">
        </form>
    </div>



</body>
</html>