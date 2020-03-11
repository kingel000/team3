<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html id="wrap">
<head>
<meta charset="utf-8">

<title>로그인</title>

<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">

</head>
<script type="text/javascript">
	var message = '${msg}';
	if(message != ""){
		alert(message);
	} 	

</script>
<body class="body">
	<div class="logoBox">
		<div>
			<a href="/web/main/main.do"><img src="<c:url value="/resources/images2/itemLogo.jpg"/>"alt='logo'></a>
		</div>
	</div>
	<div id="regider_form">
		<div class="regider_Box1">
			<h4>LOGIN</h4>
		</div>
		<div class="regider_Box2">
			<form action="/web/member/login.do" method="post">
				<p class="email_Bt">
					<label for="email">이메일</label><br> <input id="password"
						type="email" name="id" placeholder="이메일을 입력해주세요">
				</p>
				<p>
					<label for="password">비밀번호</label><br> <input id="password"
						type="password" name="pwd" placeholder="비밀번호를 입력해주세요">
				</p>
				<p class="login">
					<input type="submit" value="로그인" />
				</p>
				<div class="join">
               		<div>
                  		<a href="/web/member/regiser.do">회원가입</a>
               		</div>
            	</div>
			</form>
			
		</div>

	</div>
	<footer class="footer_text"> </footer>

</body>
</html>
