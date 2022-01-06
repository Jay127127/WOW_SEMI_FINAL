<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gallery Board</title>
    
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

    <style>
        .board_number{
        	display: inline-block;
        }
    </style>
</head>

<body>


	<!-- -------------- navbar -------------- -->

	<%@ include file="../common/header_nav.jsp"%>



<!-- 본문 내용 시작 -->
<main>
	<div>
		<div class="sub_title">
			<ul class="sub_info">
				<li>Gallery</li>
				<li>w.o.w의 회원들과 멋진 모습을 공유해보세요.</li>
			</ul>
		</div>
	</div>

	<div>
		<div class="board_select">
			<form action="galleryBoard" method="get">
				<select id="select" name="selectType">
					<option value="boardDate" selected>최신순</option>
					<!-- <option value="boardNo">과거순</option> -->
					<option value="boardTitle">제목역순</option>
				</select>
				<input type="submit" value="찾기" style="height:26px; line-height:10px;">
			</form>
		</div>
	</div>

	<div id="table_board">
		<table class="table table-hover" style="text-align: center;">
			<thead style="color: black;">
				<tr>
					<th name="board_no" scope="col" style="width: 8%;">No.</th>
					<th name="board_title" scope="col">Title</th>
					<th name="board_writer" scope="col" style="width: 15%;">Writer</th>
					<th name="board_date" scope="col" style="width: 15%;">Date</th>
					<th name="board_view" scope="col" style="width: 8%;">View</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${G_BoardList}" var="b">
           			<tr class="table-light">
		               <td class="btable_td"><a href="<%request.getContextPath();%>viewPost?boardNo=${b.boardNo}" style="color:black;">${b.RNUM}</a></td>
		               <td class="btable_td"><a href="<%request.getContextPath();%>viewPost?boardNo=${b.boardNo}" style="color:black;">${b.boardTitle}</a></td>
		               <td class="btable_td"><a href="<%request.getContextPath();%>viewPost?boardNo=${b.boardNo}" style="color:black;">${b.userId}</a></td>
		               <td class="btable_td"><a href="<%request.getContextPath();%>viewPost.jsp?boardNo=${b.boardNo}" style="color:black;">${b.boardDate}</a></td>
		               <td class="btable_td"><a href="<%request.getContextPath();%>viewPost.jsp?boardNo=${b.boardNo}" style="color:black;">${b.viewCount}</a></td>
		           </tr>
		       	</c:forEach>
			</tbody>
		</table>
	</div>


<!-- 글쓰기 버튼 -->
	<% 
		String userID = (String)session.getAttribute("isLogin");
		if(userID!=null && !"".equals(userID)){
	%>
			<div class="new_roll_space">
				<a href="newPost" class="new_roll">글 쓰기</a>
			</div>
	<%	
		}else {
	%>
			<div class="new_roll_space">
				<button class="new_roll" onclick="alert('로그인이 필요합니다.'); location.href='login';">글 쓰기</button>
			</div>
	<%		
		}
	%>
	
<!-- 페이징 -->
	<div style="text-align:center;">
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
	        <div class="board_number">
	            <c:if test="${i le maxPage}">
	                <a href="search?currentPage=${i}">${i}</a>
	            </c:if>
	        </div>
	    </c:forEach>
    </div>

</main>
<!-- 본문 내용 끝 -->


<!-- 푸터 작업? -->
<footer>
	<div class="nothing" style="height: 150px;">

	</div>
</footer>

</body>
</html>
