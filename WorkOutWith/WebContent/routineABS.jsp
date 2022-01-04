<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="/routine/rutin.js"></script>
    <link rel="stylesheet" href="/routine/rutin.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" 
    integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" 
    crossorigin="anonymous">
    <style>
        h4{
            font-weight: bolder;
            color: whitesmoke; 
        }
        select{
            width: 250px;
        }
        b{
            color: whitesmoke;
        }
        input{
            width:250px;
        }
    </style>
    <title>ABS</title>

</head>
<body>
<script type="text/javascript">


	function sABT1(){
	     opener.document.getElementById("abh1").value = document.getElementById("ab1").value
	   }
	   function sABT2(){
	     opener.document.getElementById("abh2").value = document.getElementById("ab2").value
	   }
	   function sABT3(){
	     opener.document.getElementById("abh3").value = document.getElementById("ab3").value
	   }
	
</script>
    <div style="width: 400px; height: 220px; background-color: rgb(160, 47, 85);">
 
        <h4>복근 운동 횟수를 설정해주세요</h4>
        <br>
        <b><font>복근운동&nbsp;</font></b> 
        <select name="" id="ab1">
            <option value="DEAD BUG">DEAD BUG</option>
            <option value="TWIST CRUNCH">TWIST CRUNCH</option>
            <option value="AB ROLLOUT">AB ROLLOUT</option>
            <option value="SIDE BAND">SIDE BAND</option>
        </select>
        <br><br>
        &nbsp;&nbsp;&nbsp;<b><font >횟수</font></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="number" min="0" max="50" value="0" id="ab2"> <button type="submit" class="btn btn-primary" onclick="sABT1();sABT2();sABT3();">저장</button>
        <br><br>   
        &nbsp;&nbsp;<b><font >인터벌</font></b>&nbsp;&nbsp;
        <input type="number" min="0" max="300" step="5" value="0" id="ab3"> 
        
        <button type="submit" class="btn btn-primary" onclick="window.close();">닫기</button>
       
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>