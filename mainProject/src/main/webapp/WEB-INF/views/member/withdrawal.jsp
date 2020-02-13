<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html id="wrap">
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>

<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">

</head>
<body class="body">
	<div class="withdrawal_Box1">
      <div class="withdrawal_Box2">
         <form action="/web/member/withdrawal.do" method="post">
         	<p>
				<label>회원 탈퇴를 위해 비밀번호를 입력해 주세요<br></label>
			</p>
			<p>
				<input id="pass" type="password" name="password" placeholder="비밀번호를 입력해주세요">
			</p>
            <p>
               <input type="submit" value="회원 탈퇴 하기" />
            </p>
         </form>
      </div>
   </div>
</body>
</html>