<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>	

	<!DOCTYPE html>
	<html lang="ko">
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	    <title>View Post</title>
	    
	    <!-- css file link -->
	    <link rel="stylesheet" type="text/css" href="assets/CSS/board_viewPost.css">	
	</head>
<body>


	<!-- -------------- navbar -------------- -->

	<%@ include file="../common/header_nav.jsp"%>

   <main>
       <div class="sub_title">
           <ul class="sub_info">
               <li>자유게시판(상세)</li>
               <li>w.o.w와 함께하는 자유롭고 건강한 lifestyle</li>
           </ul>
       </div>
 
 
       <div class="body">
           <div class="body_space">
               <div class="view_head_subject">
               <c:forEach items="${boardList}" var="b">
                   <p class="view_head_left">${b.boardTitle}</p>
                   <p class="view_head_right">${b.boardDate}</p>
               </c:forEach>
               </div>
 
               <div class="view_head_attachment">
	               <c:forEach items="${boardList}" var="b">
	                   <p class="view_att_left">${b.userId}</p>
	                   <a href="#" class="view_attachment">
	                       <span class="attachment">&nbsp;</span>
	                       <img alt="" src="../board_img/2022.jpeg">
	                   </a>
                   </c:forEach>
               </div>
              
               <div class="view_body_content" style="padding : 40px 0 40px 0">
                   
                   <p class="in_att">
                       
                   </p>
                   <div class="in_text_space">
	                   <c:forEach items="${boardList}" var="b">
	                       <p class="in_text">${b.boardContent}</p>
                       </c:forEach>
                   </div>
               </div>
              
               <div class="reply_space">
                   <div class="reply_info">
                       <p class="re_left">
                           <b>문인수</b>
                           <span>2021.12.31 13:31</span>
                       </p>
                   </div>
                   <div class="reply_text">
                       해피뉴이어~
                   </div>
 
                   <div class="reply_info">
                       <p class="re_left">
                           <b>김나나</b>
                           <span>2021.12.31 13:31</span>
                       </p>
                   </div>
                   <div class="reply_text">
                       새해 복 마니마나ㅣ~
                   </div>
               </div>
           </div>
 
       </div>
   </main>
</body>
</html>


