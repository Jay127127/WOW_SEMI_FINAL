<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Board</title>
    
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
        
        a{
        	text-decoration:none;
        	color:black;
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
				<li>자유게시판</li>
				<li>w.o.w의 회원들과 자유로운 이야기를 나눠보세요.</li>
			</ul>
		</div>
	</div>

	<div>
		<div class="board_select">
			<form action="board" method="get">
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
				<c:forEach items="${boardList}" var="b">
           			<tr class="table-light">
		               <td class="btable_td"><a href="<%request.getContextPath();%>viewPost?boardNo=${b.boardNo}" style="color:black;">${b.RNUM}</a></td>
		               <td class="btable_td"><a href="<%request.getContextPath();%>viewPost?boardNo=${b.boardNo}" style="color:black;">${b.boardTitle}</a></td>
		               <td class="btable_td"><a href="<%request.getContextPath();%>viewPost?boardNo=${b.boardNo}" style="color:black;">${b.userId}</a></td>
		               <td class="btable_td"><a href="<%request.getContextPath();%>viewPost.jsp?boardNo=${b.boardNo}" style="color:black;">${b.boardDate}</a></td>
		               <td class="btable_td"><a href="<%request.getContextPath();%>viewPost.jsp?boardNo=${b.boardNo}" style="color:black;">${b.viewCount}</a></td>
		           </tr>
		       	</c:forEach>
			</tbody>
			<!-- <tbody>
				<tr class="table-light" class="attention">
					<th name="board_no" scope="row"></th>
					<td name="board_title"  onclick="location.href=''">[전체] 공지사항 입니다.</td>
					<td name="board_writer" onclick="location.href=''">문인수</td>
					<td name="board_date"   onclick="location.href=''">2021.12.01</td>
					<td name="board_view"   onclick="location.href=''">2352</td>
				</tr>
				<tr class="table-light">
					<th name="board_no" scope="row">10</th>
					<td name="board_title"  onclick="location.href='/wow/viewPost'">2022년에는 진짜 살뺀다..ㅠㅠ</td>
					<td name="board_writer" onclick="location.href=''">다이어터</td>
					<td name="board_date"   onclick="location.href=''">2021.12.31</td>
					<td name="board_view"   onclick="location.href=''">52</td>
				</tr>
				<tr class="table-light">
					<th name="board_no" scope="row">9</th>
					<td name="board_title"  onclick="location.href=''">안녕하십니까, 반갑습니다.</td>
					<td name="board_writer" onclick="location.href=''">김사랑</td>
					<td name="board_date"   onclick="location.href=''">2021.12.22</td>
					<td name="board_view"   onclick="location.href=''">63</td>
				</tr>
				<tr class="table-light">
					<th name="board_no" scope="row">8</th>
					<td name="board_title"  onclick="location.href=''">상체 조지기 루틴 공유</td>
					<td name="board_writer" onclick="location.href=''">지은이</td>
					<td name="board_date"   onclick="location.href=''">2021.12.22</td>
					<td name="board_view"   onclick="location.href=''">345</td>
				</tr>
				<tr class="table-light">
					<th name="board_no" scope="row">7</th>
					<td name="board_title"  onclick="location.href=''">허벅지 키우는 빠른 방법(꿀팁)</td>
					<td name="board_writer" onclick="location.href=''">후니후니</td>
					<td name="board_date"   onclick="location.href=''">2012.12.21</td>
					<td name="board_view"   onclick="location.href=''">127</td>
				</tr>
				<tr class="table-light">
					<th name="board_no" scope="row">6</th>
					<td name="board_title"  onclick="location.href=''">모닝 스트레칭 기록 (D+10)</td>
					<td name="board_writer" onclick="location.href=''">승여니</td>
					<td name="board_date"   onclick="location.href=''">2021.12.20</td>
					<td name="board_view"   onclick="location.href=''">123</td>
				</tr>
				<tr class="table-light">
					<th name="board_no" scope="row">5</th>
					<td name="board_title"  onclick="location.href=''">부산에서 서울까지 국토대장정</td>
					<td name="board_writer" onclick="location.href=''">노노지훈</td>
					<td name="board_date"   onclick="location.href=''">2021.12.20</td>
					<td name="board_view"   onclick="location.href=''">32</td>
				</tr>
				<tr class="table-light">
					<th name="board_no" scope="row">4</th>
					<td name="board_title"  onclick="location.href=''">줄넘기 하고 스트레칭을 꼭 합시다.</td>
					<td name="board_writer" onclick="location.href=''">상민이</td>
					<td name="board_date"   onclick="location.href=''">2021.12.19</td>
					<td name="board_view"   onclick="location.href=''">23</td>
				</tr>
				<tr class="table-light">
					<th name="board_no" scope="row">3</th>
					<td name="board_title"  onclick="location.href=''">박박이가 왔다</td>
					<td name="board_writer" onclick="location.href=''">박박이</td>
					<td name="board_date"   onclick="location.href=''">2021.12.18</td>
					<td name="board_view"   onclick="location.href=''">534</td>
				</tr>
				<tr class="table-light">
					<th name="board_no" scope="row">2</th>
					<td name="board_title"  onclick="location.href=''">바디프로필 후기 (+스튜디오 추천)</td>
					<td name="board_writer" onclick="location.href=''">은경</td>
					<td name="board_date"   onclick="location.href=''">2021.12.17</td>
					<td name="board_view"   onclick="location.href=''">232</td>
				</tr>
				<tr class="table-light">
					<th name="board_no" scope="row">1</th>
					<td name="board_title"  onclick="location.href=''">운동 유튜버 추천해주세요 ㅠㅠ</td>
					<td name="board_writer" onclick="location.href=''">mireees</td>
					<td name="board_view"   onclick="location.href=''">100</td>
					<td name="board_date"   onclick="location.href=''">2021.12.14</td>
				</tr>
			</tbody> -->
		</table>
	</div>

<!-- 글쓰기 버튼 -->
	<div class="new_roll_space">
		<a href="newPost" class="new_roll">글 쓰기</a>
	</div>
 

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
    
	<!-- <div class="board_number">
		<a class="board_number_prev">&laquo;</a>
		<a href="#">1</a>
		<a href="#">2</a>
		<a href="#">3</a>
		<a href="#">4</a>
		<a href="#">5</a>
		<a href="#">&raquo;</a>
	</div> -->
	
</main>
<!-- 본문 내용 끝 -->


<!-- 푸터 작업? -->
<footer>
	<div class="nothing" style="height: 150px;">

	</div>
</footer>

</body>
</html>
