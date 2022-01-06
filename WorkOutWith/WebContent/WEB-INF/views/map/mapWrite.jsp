

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#text_editor_form {
		color: white;
	}
</style>


</head>
<body>
	
	<header>

	<%@ include file="../common/header_nav.jsp"%>


  <br><br><br>
  
<form id="text_editor_form"  action="mapwrite" method="post" >
		<div>
				
	        <table id="editing_form" style="left-margin:100px;">
	            <tbody>
	                <tr>
	                    <th style="min-width: 100px; min-height: 60px">제목</th>
	                    <td style="min-width: 1000px;">
	                        <input type="text" id="title" name="title" style="font-size: 1.1em; height: 2vw; width: 50%; min-height: 30px" >
	                    </td>
	                </tr>
	                <tr>
	                    <th style="min-width: 100px; min-height: 60px">작성자</th>
	                    <td style="min-width: 1000px;">
	                        <input type="text" id="name" name="name" style="font-size: 1.1em; height: 2vw; width: 50%; min-height: 30px" >
	                    </td>
	                </tr>
	                <tr>
	                    <th style="min-width: 100px; min-height: 60px">내용</th>
	                    <td style="min-width: 1000px;">
	                        <textarea name="content" id="content" cols="100" rows="15" required></textarea>
	                    </td>
	                </tr>
	            </tbody>
	        </table>
	        	
	
	
	     
			<br> <br>
	        <div class="submit_form">
	            <input type="submit" id="postingConfirm" value="게시하기">
	            
	        	<input type="button" id="resetConfirm" value="취소하기">
	        </div>

        	<script>
		        $(function(){
		            $("#resetConfirm").on(
		                {
		                   "click":function(){confirm("취소하시겠습니까?");
			                   if (window.confirm("작성하신 모든 내용은 삭제됩니다.")) {
						    	  	history.back();
						    	}
		                   }
		                   
		                }
		            )
		        })
		    </script>
	    </form>
	    </div>
	    
			</div>
		</div>
	</div>
	
	    
	    
	    </header>
	   

</body>
</html>