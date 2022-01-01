/**
	관리자 계정 생성 관련 유효성 검사
 */
const id = document.getElementById("inputId");
const pwd1 = document.getElementById("inputPwd1");
const pwd2 = document.getElementById("inputPwd2");
const iname = document.getElementById("inputName");
const nick = document.getElementById("inputNick");
const email = document.getElementById("inputEmail");
const createBtn = document.getElementById("createBtn");

let idHelp = document.getElementById("idHelp");
let dupHelp = document.getElementById("dupHelp");
id.oninput = function () {
    dupHelp.innerHTML = "";
    if (!/^Wowadmin[0-9]{4}$/.test(id.value)) {
        idHelp.innerHTML = "Wowadmin + 숫자4자리로 입력하시오.";
        idHelp.style.color = "#dc143c";
    } else {
        idHelp.innerHTML = "유효한 아이디입니다.";
        idHelp.style.color = "#008d62";
    }
};

// 영문자, 숫자, 특수문자 모두 포함하여 총 8~12자
let pwdHelp1 = document.getElementById("pwdHelp1");
let pwdHelp2 = document.getElementById("pwdHelp2");
pwd1.oninput = function () {
    pwdHelp2.innerHTML = "";
    if (!/^(?=.*[a-zA-Z])(?=.*\d)(?=.*\W).{8,12}$/.test(pwd1.value)) {
        pwdHelp1.innerHTML =
            "영문자, 숫자, 특수문자 모두 포함하여 총 8~12자로 입력하시오.";
        pwdHelp1.style.color = "#dc143c";
    } else {
        pwdHelp1.innerHTML = "유효한 비밀번호입니다.";
        pwdHelp1.style.color = "#008d62";
    }
};

// 위의 비밀번호와 일치하게
pwd2.oninput = function () {
    if (pwd1.value !== pwd2.value) {
        pwdHelp2.innerHTML = "위의 비밀번호와 일치하게 입력하시오.";
        pwdHelp2.style.color = "#dc143c";
    } else {
        pwdHelp2.innerHTML = "위의 비밀번호와 일치합니다.";
        pwdHelp2.style.color = "#008d62";
    }
};

// 이름 : 한글로만 이루어져야 되며 2~10자
let namelHelp = document.getElementById("namelHelp");
iname.oninput = function () {
    if (!/^[가-힣]{2,6}$/.test(iname.value)) {
        namelHelp.innerHTML = "한글로만 이루어져야 되며 2~6자를 입력하시오.";
        namelHelp.style.color = "#dc143c";
    } else {
        namelHelp.innerHTML = "유효한 이름입니다.";
        namelHelp.style.color = "#008d62";
    }
};

// 닉네임 : 영문자, 숫자, 특수문자 상관없이 총 1~8자
let nickHelp = document.getElementById("nickHelp");
nick.oninput = function () {
    if (!/^\S{1,8}$/.test(nick.value)) {
        nickHelp.innerHTML = "공백을 제외한 모든 문자 최대 8자를 입력하시오.";
        nickHelp.style.color = "#dc143c";
    } else {
        nickHelp.innerHTML = "유효한 이름입니다.";
        nickHelp.style.color = "#008d62";
    }
};

// 이메일 형식에 맞춰서
let emailHelp = document.getElementById("emailHelp");
email.oninput = function () {
    if (!/^[\w]+@[\w]+\.[A-Za-z\.]{2,7}$/.test(email.value)) {
        emailHelp.innerHTML = "이메일 형식에 맞춰서 입력하시오.";
        emailHelp.style.color = "#dc143c";
    } else {
        emailHelp.innerHTML = "유효한 이메일입니다.";
        emailHelp.style.color = "#008d62";
    }
};

// 담당 선택해야함
// ** 모든 곳을 만족해야 넘어가게
function validate() {
    let powHelp = document.getElementById("powHelp");
    let check = $(".rqFill").siblings("small").text();
    if ($("#selectPow option:selected").val() == "") {
        alert("담당을 선택하세요.");
        return false;
    } else {
        if (
            check !=
            "사용가능한 계정입니다.유효한 비밀번호입니다.위의 비밀번호와 일치합니다.유효한 이름입니다.유효한 이름입니다.유효한 이메일입니다."
        ) {
            alert("사용가능한 값을 입력하시오.");
            return false;
        }
    }
}
