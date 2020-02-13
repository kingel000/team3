<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html id="wrap">
<head>
<meta charset="utf-8">

<title>Edit Page</title>
<script type="text/javascript">
	$(function() {

	});
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
			<form action="#" method="post">
				<p>
					<label for="email">이메일</label>&nbsp;&nbsp;&nbsp; <label>asdfasdf@asdfasdf</label>
				</p>
				<p>
					<label for="name">이름</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label>아무개</label>
				</p>
				<p>
					<label for="nick_name">닉네임</label><br> <input id="n_name"
						type="text" name="n_name" placeholder="아무개">
				</p>
				<p>
					<label for="password">비밀번호 변경</label><br> <input id="password"
						type="password" name="pwd" placeholder="비밀번호를 입력해주세요">
				</p>
				<p>
					<label for="password">비밀번호 확인</label><br> <input
						id="password2" type="password" name="pwd2" placeholder="비밀번호 확인">
				</p>
				<p class="join_c">
					<input type="submit" value="정보변경완료" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>
