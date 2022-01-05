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
    <title>newPost</title>
    
    <!-- css file link -->
    <link rel="stylesheet" type="text/css" href="assets/CSS/board_newPost.css">	
</head>
<body>
<!-- ==================NAVBAR==================== -->
		<%@ include file="../common/header_nav.jsp"%>
		
	
<!-- ===================본문===================== -->
	<main>
	    <div class="sub_title">
	        <ul class="sub_info">
	            <li>글 쓰기</li>
	            <li>w.o.w의 회원들과 다양한 이야기를 나눠보세요.</li>
	        </ul>
	    </div>
	
	    <form id="text_editor_form" name="text_editor_form" action="newPost" method="post" enctype = "multipart/form-data">
	        <table id="editing_form">
	            <tbody>
	                <tr>
	                    <th style="min-width: 100px; min-height: 60px">제목</th>
	                    <td style="min-width: 1000px;">
	                        <input type="text" id="title" name="boardTitle" style="font-size: 1.1em; height: 2vw; width: 50%; min-height: 30px" required>
	                    </td>
	                </tr>
	                <tr>
	                    <th style="min-width: 100px; min-height: 60px">카테고리</th>
	                    <td style="min-width: 1000px;">
	                        <select name="boardCategory" id="category_select" style="min-height: 30px">
	                            <option value="board" selected >자유게시판</option>
	                            <option value="gallery" >갤러리</option>
	                            <option value="routine">루틴공유</option>
	                            <option value="enquiry">문의게시판</option>
	                        </select>
	                    </td>
	                </tr>
	                <tr>
	                    <th style="min-width: 100px; min-height: 60px">첨부파일</th>
	                    <td style="min-width: 1000px;">
	                        <div>
	                            <input type="file" id="upload_file" name="fileName" multiple 
	                            style="font-size: 1em;">
	                            <%-- Using JSP EL to get message attribute value from request scope --%>
							    <h2>${requestScope.fileName}</h2>
							    파일명 : <a href = "FileDown?fileName=${requestScope.fileName }">${requestScope.fileName }</a>
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <th style="min-width: 100px; min-height: 60px">공개여부</th>
	                    <td style="min-width: 1000px; padding-top:10px;"> 
	                        <label>
	                            <input type="checkbox" name="boardOpen_YN" id="secret" value="N">
	                            비공개로 게시글을 올릴래요.
	                        </label>
	                        <p>
	                            * 체크박스 선택 시, 관리자만 해당 글을 조회할 수 있습니다.
	                        </p>
	                    </td>
	                </tr>
	                <tr>
	                    <th style="min-width: 100px; min-height: 60px">내용</th>
	                    <td style="min-width: 1000px;">
	                        <textarea name="boardContent" id="content" cols="100" rows="15" required></textarea>
	                    </td>
	                </tr>
	            </tbody>
	        </table>
	        
<!-- ===================버튼===================== -->

	        <div class="submit_form">
	            <input type="submit" id="postingConfirm" value="게시하기">
	            
	        	<input type="button" id="resetConfirm" value="취소하기">
	        </div>

        	<script>
		        $(function(){
		            $("#resetConfirm").on(
		                {
		                   "click":function(){confirm("sure?");
			                   if (window.confirm("Really want to leave?")) {
						    	  	history.back();
						    	}
		                   }
		                   
		                }
		            )
		        })
		    </script>
	    </form>
	    
	    <h1>${msg1}</h1>
	    <h1>${msg2}</h1>
	</main>
	<!-- 본문 내용 끝 -->
	
	
	<!-- 푸터 작업? -->
	<footer>
		<div class="nothing" style="height: 150px;">
	
		</div>
	</footer>
	
	</body>
	</html>
	
	
