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
        <!-- 테이블 -->
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
                    <h1 class="mt-4">문의 관리</h1>
                      	<ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"> </li>
                        </ol>
                        <div class="row">
                        </div>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                문의 처리 목록
                            </div>
                            <div class="card-body">

		                        <div class="container-fluid px-4"><br>

		                        <form method="get" action="deal_req">
		                        <div class="">
		                        <select class="form-select" name="searchType" style="width:150px">
		                            <option value="boardNo">문의번호</option>
		                            <option value="boardDate">날짜</option>
		                            <option value="userId">아이디</option>
		                            <option value="boardTitle">제목</option>
		                            <%-- <option value="admin_power_name">담당자</option> --%>
		                            <option value="dealEnq">처리여부</option>
		                        </select>

		                        <input type="text" name="searchValue" id="">
		                        <input type="submit" class="btn bg-custom btn-sm" value="검색">
		                        </div>
		                        </form><br>

		                        <table class="table table-hover table-bordered">
		                        <thead>
		                        <tr align="left">
		                            <th>#</th>
		                            <th>문의번호</th>
		                            <th>아이디</th>
		                            <th>제목</th>
		                            <th>날짜</th>
		                            <th>링크</th>
		                            <%-- <th>담당자</th> --%>
		                            <th>처리여부(Y/N)</th>
		                        </tr>
		                        </thead>
		                        <tbody>
		                        <c:forEach items="${boardList}" var="a">
		                            <tr>
		                                <td align="center">${a.rNum}</td>
		                                <td align="center" class="bn">${a.boardNo}</td>
		                                <td>${a.userId}</td>
		                                <td>${a.boardTitle}</td>
		                                <td>${a.boardDate}</td>
										<td align="center"><a class="fas fa-link"></a></td>
			                            <td align="center" class="ud">
											${a.dealEnq} &ensp;
											<a class="upEn"><i class="fas fa-pen-square"></i></a>
										</td>
		                            </tr>
		                        </c:forEach>
		                        </tbody>
		                        </table>


		                    <ul class="pagination justify-content-center">
				                <c:choose>
				                    <c:when test="${!empty type && !empty value}">
					                    <li class="page-item" id=""><a class="page-link" id="pp" href="deal_req?searchType=${type}&searchValue=${value}&currentPage=${prevPage}">prev</a></li>
					                        <c:forEach var='i' begin="${startPage}" end="${maxPage}">
					                        	<c:if test="${i le maxPage}">
					                        	<li class="page-item liPi" id=""><a class="page-link iPi" id="" href="deal_req?searchType=${type}&searchValue=${value}&currentPage=${i}">${i}</a></li>
					                        	</c:if>
					                        </c:forEach>
					                    <li class="page-item" id=""><a class="page-link" id="np" href="deal_req?searchType=${type}&searchValue=${value}&currentPage=${nextPage}">next</a></li>
				                    </c:when>
				                    <c:otherwise>
					                    <li class="page-item" id=""><a class="page-link" id="pp" href="deal_req?currentPage=${prevPage}">prev</a></li>
					                        <c:forEach var='i' begin="${startPage}" end="${maxPage}">
					                        	<c:if test="${i le maxPage}">
					                        	<li class="page-item liPi" id=""><a class="page-link iPi" id="" href="deal_req?currentPage=${i}">${i}</a></li>
					                        	</c:if>
					                        </c:forEach>
					                    <li class="page-item" id=""><a class="page-link" id="np" href="deal_req?currentPage=${nextPage}">next</a></li>
				                    </c:otherwise>
				                </c:choose>
				            </ul>

		                         </div>
                        	</div>
                    	</div>
                    	    <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                이전 처리 목록
                            </div>
                            <div class="card-body">

		                        <div class="container-fluid px-4"><br>

		                        <form method="get" action="deal_req">
		                        <div class="">
		                        <select class="form-select" name="searchType" style="width:150px">
		                            <option value="boardNo">문의번호</option>
		                            <option value="boardDate">날짜</option>
		                            <option value="userId">아이디</option>
		                            <option value="boardTitle">제목</option>
		                            <%-- <option value="admin_power_name">담당자</option> --%>
		                            <option value="dealEnq">처리여부</option>
		                        </select>

		                        <input type="text" name="searchValue" id="">
		                        <input type="submit" class="btn bg-custom btn-sm" value="검색">
		                        </div>
		                        </form><br>

		                        <table class="table table-hover table-bordered">
		                        <thead>
		                        <tr align="left">
		                            <th>#</th>
		                            <th>문의번호</th>
		                            <th>아이디</th>
		                            <th>제목</th>
		                            <th>날짜</th>
		                            <th>링크</th>
		                            <%-- <th>담당자</th> --%>
		                            <th>처리여부(Y/N)</th>
		                        </tr>
		                        </thead>
		                        <tbody>
		                        <c:forEach items="${boardListYes}" var="y">
		                            <tr>
		                               <td align="center">${y.rNum}</td>
		                                <td align="center" class="nN">${y.boardNo}</td>
		                                <td>${y.userId}</td>
		                                <td>${y.boardTitle}</td>
		                                <td>${y.boardDate}</td>
										<td align="center"><a class="fas fa-link"></a></td>
			                            <td align="center" class="ud">
											${y.dealEnq} &emsp;
											<a class="upNo"><i class="fas fa-pen-square"></i></a>
										</td>
		                            </tr>
		                        </c:forEach>
		                        </tbody>
		                        </table>


		                    <ul class="pagination justify-content-center">
				                <c:choose>
				                    <c:when test="${!empty typeY && !empty valueY}">
					                    <li class="page-item" id=""><a class="page-link" id="pp2" href="deal_req?searchTypeY=${typeY}&searchValueY=${valueY}&currentPageY=${prevYPage}">prev</a></li>
					                        <c:forEach var='j' begin="${startPageY}" end="${maxYPage}">
					                        	<c:if test="${j le maxYPage}">
					                        	<li class="page-item liPi" id=""><a class="page-link iPi" id="" href="deal_req?searchTypeY=${typeY}&searchValueY=${valueY}&currentPageY=${j}">${j}</a></li>
					                        	</c:if>
					                        </c:forEach>
					                    <li class="page-item" id=""><a class="page-link" id="np2" href="deal_req?searchTypeY=${typeY}&searchValueY=${valueY}&currentPageY=${nextYPage}">next</a></li>
				                    </c:when>
				                    <c:otherwise>
					                    <li class="page-item" id=""><a class="page-link" id="pp2" href="deal_req?currentPageY=${prevYPage}">prev</a></li>
					                        <c:forEach var='j' begin="${startPageY}" end="${maxYPage}">
					                        	<c:if test="${j le maxYPage}">
					                        	<li class="page-item liPi" id=""><a class="page-link iPi" id="" href="deal_req?currentPageY=${j}">${j}</a></li>
					                        	</c:if>
					                        </c:forEach>
					                    <li class="page-item" id=""><a class="page-link" id="np2" href="deal_req?currentPageY=${nextYPage}">next</a></li>
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
	// 새로고침 방지2
	let pp2 = document.getElementById('pp2');
	let np2 = document.getElementById('np2');
	if(pp2.href == window.location.href){
		pp2.setAttribute("href", "#");
	}
	if(np2.href ==window.location.href){
		// np.href = '#;
		np2.setAttribute("href", "#");
	}

	//클릭한 것만 수정(->처리Y)하기
	$('.upEn').click(function(){
		let index = $('.upEn').index(this);
		let st = 'update_board?boardNo='+$('.bn').eq(index).text()
		if(confirm("문의답변을 처리하셨습니까?")){
			$(location).attr('href', st);
		}
	})
	//클릭한 것만 수정(->처리N)하기
	$('.upNo').click(function(){
		let index = $('.upNo').index(this);
		let st = 'update_no_board?boardNo='+$('.nN').eq(index).text()
		if(confirm("문의답변처리를 쉬소하시겠습니까?")){
			$(location).attr('href', st);
		}
	})

    </script>
	<%@ include file="footer_admin.jsp"%>
</body>
</html>
