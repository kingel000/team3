<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html id="wrap">
<style>

/*회원가입 이메일인증*/
#wrap{}
.body{margin-top:0px; margin-bottom:100px;}
#email_form{width:550px;height:auto;padding:20px 10px;margin:0 auto;text-align:center; border: solid 1px #e4e5ed;}
#email_form>p{margin:0 auto}
#email_num{margin: 0 atuo}
.email_Box1{width: 90%;margin: 0 75px;}
.email_Box1>p{align-items: center; text-align: center; width: auto;}

.email_Box1>form>p>input {
    width: 382px;
    height: 40px;
    border-radius: 4px;
    padding: 5px;
    margin-bottom: 10px;
    border: solid 1px #e4e5ed;
}
.email_Bt>a>img{width: 21px; margin : 0 0 2px 2px;}

</style>
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
<body class="body">
	
<div id="email_form">
	<c:choose>
		<c:when test="${authKey == null }">
		<div class="email_Box1">
			<form action="/web/member/auth.do" method="post" >
			<p class="email_Bt">
      			<label for="email">이메일</label><br>
      			<input id="email" type="email" name="id" placeholder="이메일을 입력해주세요" ><br><br>	
      			<p class=join>
      			<a onclick="emailCheck()">
      				<input type="submit" value="인증번호 전송">
      				<input type="hidden" name="idCheckResult" value="emailUnCheck" />
      			</a> 
      			</p>
      			 
      		           
      		</form>
      		</div>
		</c:when>
		<c:otherwise>
			<form action="/web/member/authKey.do" method="post">
				<label>인증번호</label><br><br>
				<input type="text" name="key" placeholder="인증번호를 입력해주세요" ><br><br>
				<input type="hidden" name="id" value="${member.id }">
				<input type="hidden" name="authKey" value="${authKey }">
				<input type="submit" value="인증하기">
			</form>
		</c:otherwise>
	</c:choose>
	
     </div>
</body>
</html>