<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
   function checkValue() {
      if (!document.userInfo.id.value) {
         alert("이메일 ID를 입력해주세요.");
         document.userInfo.id.focus();
         return false;
      }
      if (document.userInfo.idCheckResult.value != "idCheck") {
         alert("이메일인증을 해주세요.");
         return false;
      } 
   }
   function emailCheck(){
      document.userInfo.idCheckResult.value ="idCheck";
   }
   function inputIdCheck(){
      document.userInfo.idCheckResult.value ="idUnCheck";
   }
</script>
</head>
<body>
	<c:choose>
		<c:when test="${authKey == null }">
			<form action="/web/member/auth.do" method="post" >
      			<label for="email">이메일</label><br>
      			<input id="email" type="email" name="id" placeholder="이메일을 입력해주세요" >
      			<a onclick="emailCheck()">
      				<input type="submit" value="인증하기">
      				<input type="hidden" name="idCheckResult" value="emailUnCheck" />
      			</a>             
      		</form>
		</c:when>
		<c:otherwise>
			<form action="/web/member/authKey.do" method="post">
				<label>인증번호</label>
				<input type="text" name="key" placeholder="인증번호를 입력해주세요" >
				<input type="hidden" name="id" value="${member.id }">
				<input type="hidden" name="authKey" value="${authKey }">
				<input type="submit" value="인증하기">
			</form>
		</c:otherwise>
	</c:choose>
      
</body>
</html>