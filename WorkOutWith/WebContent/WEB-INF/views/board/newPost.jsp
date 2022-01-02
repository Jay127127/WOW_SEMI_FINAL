	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html lang="ko">
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>new_roll</title>
	    
	    <!-- css file link -->
	    <link rel="stylesheet" type="text/css" href="assets/CSS/board_newPost.css">
	
	</head>
	<body>
		<!-- -------------- navbar -------------- -->
		<%@ include file="../common/header_nav.jsp"%>
		
	
	    <!-- 본문 내용 시작 -->
	<main>
	
	    <div class="sub_title">
	        <ul class="sub_info">
	            <li>글 쓰기</li>
	            <li>w.o.w의 회원들과 다양한 이야기를 나눠보세요.</li>
	        </ul>
	    </div>
	
	    <form id="text_editor_form" name="text_editor_form" action="newPost" method="post" encType = "multipart/form-data">
	        <table id="editing_form">
	            <tbody>
	                <tr>
	                    <th>제목</th>
	                    <td>
	                        <input type="text" id="title" name="title" style="font-size: 1.1em; height: 2vw; width: 50%;">
	                    </td>
	                </tr>
	                <tr>
	                    <th>카테고리</th>
	                    <td>
	                        <select name="category_select" id="category_select">
	                            <option value="free">자유게시판</option>
	                            <option value="gallery">갤러리</option>
	                            <option value="routine">루틴공유</option>
	                            <option value="question">문의게시판</option>
	                        </select>
	                    </td>
	                </tr>
	                <tr>
	                    <th>첨부파일</th>
	                    <td>
	                        <div>
	                            <input type="file" id="upload_file" name="upload_file" multiple 
	                            style="font-size: 1em;">
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <th>공개여부</th>
	                    <td style="padding-top: 20px;"> 
	                        <label>
	                            <input type="radio" name="secret" id="secret" value="1">
	                            비공개로 게시글을 올릴래요.
	                        </label>
	                        <p>
	                            * 체크박스 선택 시, 관리자만 해당 글을 조회할 수 있습니다.
	                        </p>
	                    </td>
	                </tr>
	                <tr>
	                    <th>내용</th>
	                    <td>
	                        <textarea name="text_area" id="text_area" cols="100" rows="15"></textarea>
	                    </td>
	                </tr>
	            </tbody>
	        </table>
	        
	        <div class="submit_form">
	            <input type="submit" value="게시하기">
	        </div>
	    </form>
	</main>
	<!-- 본문 내용 끝 -->
	
	
	<!-- 푸터 작업? -->
	<footer>
		<div class="nothing" style="height: 150px;">
	
		</div>
	</footer>
	
	</body>
	</html>
	
	
