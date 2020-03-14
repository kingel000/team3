<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>전문가 정보 수정</title>
<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">

</head>
<body>
	<div id="myPage_form">
		<div class="myPage_title">
			<h4>
				전문가 정보 변경
			</h4>
		</div>
		<div class="myPage">
			<form action="/web/member/editExpert.do" method="post">
				<p>
					<label for="email">전문가 아이디</label>&nbsp;&nbsp;&nbsp; <label>: ${expert.id}</label>
				</p>
				<p>
					<label for="email">이름</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>: ${expert.name}</label>
				</p>
				<p>
					<label for="tel">전화번호</label><br> <input id="tel"
						type="text" name="tel" value="${expert.tel}">
				</p>
				<p>
					<label for="career">경력을 수정해주세요</label><br>
					<textarea id="career" name="career" rows="8" cols="51" >${expert.career}</textarea>	 
				</p>
				<p class="join_c">
					<input type="hidden" name="id" value="${expert.id }">
					<input type="hidden" name="name" value="${expert.name }">
					<input type="submit" value="정보변경완료" />
				</p>
			</form>
		</div>
	</div>

</html>