<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>view_post</title>
 
    <!-- css file link -->
    <link rel="stylesheet" type="text/css" href="assets/CSS/board_viewPost.css">
 
   <style>

   </style>
   
   
   
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
                   <p class="view_head_left">[자유게시판] 2022년에는 진짜 살뺀다..ㅠㅠ</p>
                   <p class="view_head_right">다이어터  |  2021.12.31</p>
               </div>
 
               <div class="view_head_attachment">
                   <p class="view_att_left">첨부파일</p>
                   <a href="#" class="view_attachment">
                       <span class="attachment">&nbsp;</span>
                       <img alt="" src="../board_img/2022.jpeg">
                   </a>
               </div>
              
               <div class="view_body_content" style="padding : 40px 0 40px 0">
                   <p class="in_att">
                       <!-- <img src="../assets/board_img/2022.jpeg" alt="새해 복 많이 받으세요.">-->
                   </p>
                  
                   <div class="in_text_space">
                       <p class="in_text">  벌써 2022년 이라니.... 말도 안돼....</p>
                   </div>
               </div>
              
               <div class="reply_space">
                   <!-- <div>댓글</div> -->
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
