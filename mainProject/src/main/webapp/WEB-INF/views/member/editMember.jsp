<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html id="wrap">
<head>
<meta charset="utf-8">

<title>Edit Page</title>
<script type="text/javascript">
//필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
function checkValue() {
	if (!document.userInfo.n_name.value) {
		alert("닉네임을 입력해주세요.");
		document.userInfo.n_name.focus();
		return false;
	}
	if (!document.userInfo.password.value) {
		alert("패스워드를 입력해주세요.");
		document.userInfo.password.focus();
		return false;
	}
	if (!document.userInfo.password2.value) {
		alert("패스워드확인을 입력해주세요.");
		document.userInfo.password2.focus();
		return false;
	}
	if (document.userInfo.password.value != document.userInfo.password2.value) {
		alert("패스워드 동일하게 입력해주세요..");
		document.userInfo.password.focus();
		return false;
	}
}
function emailCheck() {
	document.userInfo.idCheckResult.value = "idCheck";
}
function inputIdCheck() {
	document.userInfo.idCheckResult.value = "idUnCheck";
}
</script>

<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">

</head>
<body>
	<div id="myPage_form">
		<div class="myPage_title">
			<h4>
				회원정보 변경
			</h4>
		</div>
		<div class="myPage">
			<form action="/web/member/editMember.do" method="post" name="userInfo" onsubmit="return checkValue()">
				<p>
					<label for="email">이메일</label>&nbsp;&nbsp;&nbsp; <label>${member.id}</label>
				</p>
				<p>
					<label for="nick_name">닉네임</label><br> <input id="n_name"
						type="text" name="n_name" value="${member.nick_name }">
				</p>
				<p>
					<label for="password">비밀번호 변경</label><br> 
					<input id="password" type="password" name="pwd" placeholder="비밀번호를 입력해주세요" value="${member.pwd }">
				</p>
				<p>
					<label for="password">비밀번호 확인</label><br> 
					<input id="password2" type="password" name="pwd2" placeholder="비밀번호 확인">
				</p>
				<p class="join_c">
					<input type="submit" value="정보변경완료" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>
