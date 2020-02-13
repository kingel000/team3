<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/web/member/login.do" method="post">
	 <table border="1"> 
	 	<tr> 
	 		<td>아이디</td> 
	 		<td><input type="text" name="id"  value="${memberVO.id}"/></td> 
	 	</tr> 
	 	<tr> 
	 		<td>비밀번호</td> 
	 		<td><input type="password" name="pwd" value="${memberVO.pwd}"/></td> 
	 	</tr> 
	 	<tr> 
	 		<td colspan="2">
	 			<input type="submit" value="로그인" />
	 		</td> 
	 	</tr> 
	 </table> 
	 <a href="/web/member/regiser.do" >회원가입</a>
</form> 
</body>
</html>