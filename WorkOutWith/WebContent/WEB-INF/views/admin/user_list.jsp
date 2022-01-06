<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>AdminWOW</title>
<style type="text/css">
.form-select{
	display: inline !important;
}

.pagination *{
	color: #333 !important;
}

.pagination *:hover{
	color: #fff !important;
	background-color: rgba(121, 3, 29, 0.8) !important;
}

.pagination> .active *{
    background-color: rgba(121, 3, 29, 0.8) !important;
    border-color: rgba(121, 3, 29, 0.8) !important;
    color: #fff !important;
}

.bg-custom {
    background-color: rgba(121, 3, 29, 0.8) !important;
    border-color: rgba(121, 3, 29, 0.8);
    color: #fff;
}

.bg-custom:hover,
.navbar .bg-custom:focus,
.pagination> .active *:hover
{
    background-color: rgb(121, 3, 29) !important;
    color: #fff;
}


</style>

</head>
<body class="sb-nav-fixed">
	<%@ include file="nav_admin.jsp"%>

            <div id="layoutSidenav_content">
                <main>

                    <div class="container-fluid px-4">
                        <h1 class="mt-4">회원 목록</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"> </li>
                        </ol>
                        <div class="row">

                        </div>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                회원 목록
                            </div>
                            <div class="card-body">

		                        <div class="container-fluid px-4"><br>

			                        <form method="get" action="user_list">
			                        <div class="">
			                        <select class="form-select" name="searchType" style="width:150px">
			                            <option value="member_id">아이디</option>
			                            <option value="member_nik">닉네임</option>
			                            <option value="member_name">이름</option>
			                            <option value="member_gender">성별</option>
			                            <option value="member_address">주소</option>
			                            <option value="member_email">이메일</option>
			                        </select>

			                        <input type="text" name="searchValue" id="">
			                        <input type="submit" class="btn bg-custom btn-sm" value="검색">
			                        </div>
			                        </form><br>

			                        <table class="table table-hover table-bordered">
			                        <thead>
			                        <tr align="left">
			                            <th>#</th>
			                            <th>번호</th>
			                            <th>아이디</th>
			                            <th>닉네임</th>
			                            <th>이름</th>
			                            <th>성별</th>
			                            <th>주소</th>
			                            <th>이메일</th>
			                            <th>링크</th>
			                            <th>삭제</th>
			                        </tr>
			                        </thead>
			                        <tbody>
			                        <c:forEach items="${userList}" var="a">
			                            <tr>
			                                <td align="center">${a.rNum}</td>
			                                <td align="center">${a.member_num}</td>
			                                <td class="ad">${a.member_id}</td>
			                                <td>${a.member_nik}</td>
			                                <td>${a.member_name}</td>
			                                <td align="center">${a.member_gender}</td>
			                                <td>${a.member_address}</td>
			                                <td>${a.member_email}</td>
			                                <td align="center"><a class="fas fa-link"></a></td>
			                                <td align="center" class="ud">
			                                <a class="delAd"><i class="fas fa-user-slash"></i></a>
			                                </td>
			                            </tr>
			                        </c:forEach>
			                        </tbody>
			                        </table>


				                    <ul class="pagination justify-content-center">
				                    <c:choose>
				                    	<c:when test="${!empty type && !empty value}">
					                        <li class="page-item" id=""><a class="page-link" id="pp" href="user_list?searchType=${type}&searchValue=${value}&currentPage=${prevPage}">prev</a></li>
					                        <c:forEach var='i' begin="${startPage}" end="${maxPage}">
					                        	<c:if test="${i le maxPage}">
					                        	<li class="page-item liPi" id=""><a class="page-link iPi" id="" href="user_list?searchType=${type}&searchValue=${value}&currentPage=${i}">${i}</a></li>
					                        	</c:if>
					                        </c:forEach>
					                        <li class="page-item" id=""><a class="page-link" id="np" href="user_list?searchType=${type}&searchValue=${value}&currentPage=${nextPage}">next</a></li>
				                        </c:when>
				                        <c:otherwise>
					                        <li class="page-item" id=""><a class="page-link" id="pp" href="user_list?currentPage=${prevPage}">prev</a></li>
					                        <c:forEach var='i' begin="${startPage}" end="${maxPage}">
					                        	<c:if test="${i le maxPage}">
					                        	<li class="page-item liPi" id=""><a class="page-link iPi" id="" href="user_list?currentPage=${i}">${i}</a></li>
					                        	</c:if>
					                        </c:forEach>
					                        <li class="page-item" id=""><a class="page-link" id="np" href="user_list?currentPage=${nextPage}">next</a></li>
				                        </c:otherwise>
				                    </c:choose>
				                   	</ul>
								</div>
                             </div>
                        </div>
                    </div>
                </main>

    <script type="text/javascript">
    let liPi = document.getElementsByClassName('liPi');
    let iPi = document.getElementsByClassName('iPi');

    for (let i = 0; i < iPi.length; i++) {
        if(window.location.href == iPi[i].href){
            liPi[i].classList.add('active');
        }
    }

	// 새로고침 방지
	let pp = document.getElementById('pp');
	let np = document.getElementById('np');
	if(pp.href == window.location.href){
		pp.setAttribute("href", "#");
	}
	if(np.href ==window.location.href){
		// np.href = '#;
		np.setAttribute("href", "#");
	}

	//클릭한 것만 삭제하기

	$('.delAd').click(function(){
		let index = $('.delAd').index(this);
		let st = 'user_delete?member_id='+$('.ad').eq(index).text()
		if(confirm("정말로 삭제하시겠습니까?")){
			$(location).attr('href', st);
		}
	})

    </script>

	<%@ include file="footer_admin.jsp"%>

</body>
</html>
