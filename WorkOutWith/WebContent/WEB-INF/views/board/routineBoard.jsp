<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Routine Board</title>
		<!-- css file link -->
	    <link rel="stylesheet" type="text/css" href="assets/CSS/board_basic.css">
</head>
<body>
	<!-- -------------- navbar -------------- -->
	<%@ include file="../common/header_nav.jsp"%>

	<!-- 본문 내용 시작 -->
	<main>
		<div>
			<div class="sub_title">
				<ul class="sub_info">
					<li>루틴공유 페이지</li>
					<li>w.o.w의 회원들과 당신의 멋진 루틴을 공유하고 자랑해보세요.</li>
				</ul>
			</div>
		</div>
	
		<div>
			<div class="board_select">
				<select id="select" name="select">
					<option value="bs_recent" selected >최신순</option>
					<option value="bs_view">조회수순</option>
					<option value="bs_like">좋아요순</option>
					<option value="bs_writer">작성자순?..?</option>
				</select>
			</div>
		</div>
		
		<div id="table_board">
			<table class="table table-hover" style="text-align: center;">
				<thead style="color: black;">
					<tr>
						<th name="board_no"scope="col" style="width: 8%;">No.</th>
						<th name="board_title" scope="col">Title</th>
						<th name="board_writer" scope="col" style="width: 15%;">Writer</th>
						<th name="board_date" scope="col" style="width: 15%;">Date</th>
						<th name="board_view" scope="col" style="width: 8%;">View</th>
					</tr>
				</thead>
			</table>
		</div>
		
		<div class="new_roll_space">
			<a href="routine_newPost" class="new_roll">글 쓰기</a>
		</div>
	
		<div class="board_number">
			<a class="board_number_prev">&laquo;</a>
			<a href="#">1</a>
			<a href="#">2</a>
			<a href="#">3</a>
			<a href="#">4</a>
			<a href="#">5</a>
			<a href="#">&raquo;</a>
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