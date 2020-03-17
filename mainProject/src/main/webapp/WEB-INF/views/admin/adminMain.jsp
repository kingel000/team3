<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN PAGE</title>
</head>

<script type="text/javascript">
	var message = '${msg}';
	if(message != ""){
		alert(message);
	} 		
</script>

<body>
	<div align="center">
		<h1>현재 페이지는 관리자 페이지 입니다</h1>
		<h4>
			# 관리자가 아닌 경우 <a href="/web/main/main.do">링크</a> 로 메인 페이지로 이동하세요 #
		</h4>
	</div>
	<div align="center">
		<form action="/web/admin/adminDetail.mdo" method="post">
			<table border="1">

				<tr>
					<td>관리자 아이디 :</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>관리자 비밀번호 :</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="관리자 로그인"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>