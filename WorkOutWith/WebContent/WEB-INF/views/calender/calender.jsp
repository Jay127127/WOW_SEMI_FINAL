<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyCalender</title>
    <link rel="stylesheet" href="assets/CSS/calender.css" type="text/css">
    <script type="text/javascript" defer src="assets/JS/calender.js">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
		integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>
        body{
            
        }
        .CalTb{
            width: 400px;
            height: 200px;
            table-layout: fixed;
            text-align: center;
        }
      


    </style>
</head>
<body>
    <div>
        <!-- <h1>마이 캘린더 작성하기</h1>
        <button>저장된 루틴값 가져오기(근력운동)</button>
        <textarea name="" id="" cols="30" rows="2"></textarea>
         <br>
        <button>저장된 루틴값 가져오기(유산소운동)</button>
        <textarea name="" id="" cols="30" rows="2"></textarea> -->
        <h1>마이 캘린더 작성하기</h1>
        <table border="3px solid" class="CalTb" style="opacity: ;">
            <tr>
                <td>*</td>
                <td>루틴가져오기</td>
                <td> 기간설정</td>
                <td>저장하기</td>
            </tr>
            <tr>
                <td>근력운동</td>
                <td><input type="button" class="btn btn-success" value="가져오기"></td>
                <td><input type="button" class="btn btn-success" value="기간설정"></td>
                <td><input type="button" class="btn btn-success" value="저장"></td>
            </tr>
            <tr>
                <td>유산소</td>
                <td><input type="button" class="btn btn-success" value="가져오기"></td>
                <td><input type="button" class="btn btn-success" value="기간설정"></td>
                <td><input type="button" class="btn btn-success" value="저장"></td>
            </tr>
            
               
              
        </table>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn btn-primary" type="button" onclick="">캘린더에 반영</button>
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
    <script src="calen.js"></script>
</body>
</html>