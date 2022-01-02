
//팝업창 열기

function openArmEdit(){
   window.open('/WEB-INF/views/routine/routine_Arm.jsp','Arm','width=720,height=310,resizable=no');
}
function openABSEdit(){
 window.open('rutin_ABS.html','ABS','width=720,height=310,resizable=no ');
}
function openChestEdit(){
window.open('rutin_Chest.html','Chest','width=720,height=310,resizable=no ');
}
function openLegEdit(){
window.open('rutin_Leg.html','Leg','width=720,height=310,resizable=no ');
}

//팝업에서 값 가져오기


//setArmText


//opener(부모 html창)의 요소를 자식창의 요소와 일치시킨다.

//set Arm Text


function sAT1(){
    opener.document.getElementById("aPart1").value = document.getElementById("aP1").value
}
function sAT2(){
    opener.document.getElementById("aPart2").value = document.getElementById("aP2").value
}
function sAT3(){
    opener.document.getElementById("aPart3").value = document.getElementById("aP3").value
}
function sAT4(){
    opener.document.getElementById("aNum1").value = document.getElementById("aN1").value
}
function sAT5(){
    opener.document.getElementById("aNum2").value = document.getElementById("aN2").value
}
function sAT6(){
    opener.document.getElementById("aNum3").value = document.getElementById("aN3").value
}
function sAT7(){
    opener.document.getElementById("aIn1").value = document.getElementById("aI1").value
}
function sAT8(){
    opener.document.getElementById("aIn2").value = document.getElementById("aI2").value
}
function sAT9(){
    opener.document.getElementById("aIn3").value = document.getElementById("aI3").value
}


//set Leg Text

function sLT1(){
  opener.document.getElementById("lPart1").value = document.getElementById("lP1").value
}
function sLT2(){
  opener.document.getElementById("lPart2").value = document.getElementById("lP2").value
}
function sLT3(){
  opener.document.getElementById("lPart3").value = document.getElementById("lP3").value
}
function sLT4(){
  opener.document.getElementById("lNum1").value = document.getElementById("lN1").value
}
function sLT5(){
  opener.document.getElementById("lNum2").value = document.getElementById("lN2").value
}
function sLT6(){
  opener.document.getElementById("lNum3").value = document.getElementById("lN3").value
}
function sLT7(){
  opener.document.getElementById("lIn1").value = document.getElementById("lI1").value
}
function sLT8(){
  opener.document.getElementById("lIn2").value = document.getElementById("lI2").value
}
function sLT9(){
  opener.document.getElementById("lIn3").value = document.getElementById("lI3").value
}

//set Chest Text

function sCT1(){
  opener.document.getElementById("cPart1").value = document.getElementById("cP1").value
}
function sCT2(){
  opener.document.getElementById("cPart2").value = document.getElementById("cP2").value
}
function sCT3(){
  opener.document.getElementById("cPart3").value = document.getElementById("cP3").value
}
function sCT4(){
  opener.document.getElementById("cNum1").value = document.getElementById("cN1").value
}
function sCT5(){
  opener.document.getElementById("cNum2").value = document.getElementById("cN2").value
}
function sCT6(){
  opener.document.getElementById("cNum3").value = document.getElementById("cN3").value
}
function sCT7(){
  opener.document.getElementById("cIn1").value = document.getElementById("cI1").value
}
function sCT8(){
  opener.document.getElementById("cIn2").value = document.getElementById("cI2").value
}
function sCT9(){
  opener.document.getElementById("cIn3").value = document.getElementById("cI3").value
}

//set ABS Text

function sABT1(){
  opener.document.getElementById("abPart1").value = document.getElementById("abP1").value
}
function sABT2(){
  opener.document.getElementById("abPart2").value = document.getElementById("abP2").value
}
function sABT3(){
  opener.document.getElementById("abPart3").value = document.getElementById("abP3").value
}
function sABT4(){
  opener.document.getElementById("abNum1").value = document.getElementById("abN1").value
}
function sABT5(){
  opener.document.getElementById("abNum2").value = document.getElementById("abN2").value
}
function sABT6(){
  opener.document.getElementById("abNum3").value = document.getElementById("abN3").value
}
function sABT7(){
  opener.document.getElementById("abIn1").value = document.getElementById("abI1").value
}
function sABT8(){
  opener.document.getElementById("abIn2").value = document.getElementById("abI2").value
}
function sABT9(){
  opener.document.getElementById("abIn3").value = document.getElementById("abI3").value
}

function changeSel(){
  


}