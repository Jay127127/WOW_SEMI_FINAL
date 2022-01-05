<%@page import="java.util.List"%>
<%@page import="com.wow.calender.controller.CalVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%
    List<CalVo> dataList = (List<CalVo>)request.getAttribute("data");
    %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyCalender</title>
    <link rel="stylesheet" href="assets/CSS/calender.css" type="text/css">
    <link rel="stylesheet" 
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
	crossorigin="anonymous">
   
    <style>
      
        .CalTb{
            width: 700px;
            height: 200px;
            table-layout: fixed;
            text-align: center;
        }
      	#wow{
      		background:url(assets/img/logoWith.png);
      		background-color: rgb(121, 3, 29);
      		background-repeat: no-repeat;
            width: 400px;
            height: 100px;
            border: 0;
            position: absolute;
            top: 0;
            left: 0;
            border-radius:10%;
      	
      	}


    </style>
</head>
<body style="background-color: ">
    <input type="button" id="wow" onclick="location='/wow/home'">
    <div>
         <h1 style="color: rgb(58, 58, 184); font-style: italic; font-weight: bolder;">마이 캘린더 작성하기</h1>
        
        <form>
        <table border="3px solid" class="CalTb" style="opacity: ;">
        <%
        for(CalVo c : dataList){
        	
        	String name = c.getRouName();
        	int exerNo = c.getExerNo();
        	int intv = c.getInterv();    
        	%>
        	
            <tr>
              
                <td style="font-weight: bolder;"><%=name%></td>
                <td>횟수 : <%=exerNo%></td>
                <td>인터벌 : <%=intv%>(초)</td>

            </tr>
        
        <%
        }
        %>
     
        </table>
        <button class="btn btn-primary" type="button" onclick="history.back()">이전 페이지로 이동</button>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;
     
        
        <button class="btn btn-success" type="button" onclick="">일정 설정하기</button>
        </form>
    </div>
    
    

    <div class="calendar">
        <div class="header">
            <div class="year-month"></div>
            <div class="nav">
                <button class="nav-btn go-prev" onclick="prevMonth()">&lt;</button>
                <button class="nav-btn go-today" onclick="goToday()">Today</button>
                <button class="nav-btn go-next" onclick="nextMonth()">&gt;</button>
            </div>
        </div>
        <div class="main">
            <div class="days">
                <div class="day">일</div>
                <div class="day">월</div>
                <div class="day">화</div>
                <div class="day">수</div>
                <div class="day">목</div>
                <div class="day">금</div>
                <div class="day">토</div>
            </div>
            <div class="dates"></div>
        </div>
    </div>
    
    <script src="assets/JS/calender.js"></script>
  	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
	crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
	crossorigin="anonymous"></script>
</body>
</html>