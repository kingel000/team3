<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html id="wrap">
<head>
<meta charset="utf-8">

<title>회원가입</title>

<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">

</head>

<body class="body">
	<div class="logoBox">
		<div>
			<a href="/web/main/main.do"><img
				src="<c:url value="/resources/images/logo.png" />" alt="logo"></a>
		</div>
	</div>
	<div id="regider_form">
		<div class="regider_Box1">
			<h4>
				<img src="<c:url value="/resources/images2/check_icon.png" />"
					alt="check_icon">간단한 이메일 인증으로 쉽게 가입하세요!
			</h4>
		</div>
		<div class="regider_Box2">
			<form action="/web/member/regiser.do" method="post">
				<p class="email_Bt">
					<label for="email">이메일</label><br> <input id="email"
						type="email" name="id" placeholder="이메일을 입력해주세요"> <a
						href="#"> <label>인증하기</label> <img
						src="<c:url value="/resources/images2/email_icon.png" />" alt="">
					</a>
				</p>
				<p>
					<label for="name">닉네임</label><br> <input id="name" type="text"
						name="nick_name" placeholder="닉네임을 입력해주세요">
				</p>
				<p>
					<label for="password">비밀번호</label><br> <input id="password"
						type="password" name="pwd" placeholder="비밀번호를 입력해주세요">
				</p>
				<p class="join">
					<input type="hidden" name="rank" value="N">
					<input type="submit" value="가입완료" />
				</p>
			</form>
		</div>
	</div>
	<footer class="footer_text">
		<div>
			<p>
				우리 사이트는 회원님의 원활한 서비스 이용에 필요한 정보를 <br>적절한 전자적 수단을 통해 제공하고 있습니다.
			</p>
		</div>
	</footer>

</body>
</html>