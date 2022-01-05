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
			                            <option value="admin_id">아이디</option>
			                            <option value="admin_nik">닉네임</option>
			                            <option value="admin_name">이름</option>
			                            <option value="admin_power_name">가입일</option>
			                            <option value="admin_email">이메일</option>
			                        </select>
			
			                        <input type="text" name="searchValue" id="">
			                        <input type="submit" class="btn bg-custom btn-sm" value="검색">
			                        </div>
			                        </form><br>
			
			                        <table class="table table-hover table-bordered">
			                        <thead>
			                        <tr align="left">
			                            <th>#</th>
			                            <th>아이디</th>
			                            <th>닉네임</th>
			                            <th>이름</th>
			                            <th>이메일</th>
			                            <th>가입일</th>
			                            <th>링크</th>
			                        </tr>
			                        </thead>
			                        <tbody>
			                        <%-- <c:forEach items="${adminList}" var="a">
			                            <tr>
			                                <td>${a.rNum}</td>
			                                <td>${a.admin_num}</td>
			                                <td>${a.admin_id}</td>
			                                <td>${a.admin_name}</td>
			                                <td>${a.admin_power_name}</td>
			                                <td>${a.admin_nik}</td>
			                                <td>${a.admin_email}</td>
			                            </tr>
			                        </c:forEach> --%>
			                        </tbody>
			                        </table>
			
			
				                    <%-- <ul class="pagination justify-content-center">
				                        <c:forEach var='i' begin="${startPage}" end="${maxPage}">
				                        	<li class="page-item liPi" id=""><a class="page-link iPi" id="" href="admin_list?currentPage=${i}">${i}</a></li>
				                        </c:forEach>
				                   	</ul> --%>
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

    </script>

	<%@ include file="footer_admin.jsp"%>

</body>
</html>
