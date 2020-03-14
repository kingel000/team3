<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html id="wrap">
<style>

/*회원가입 이메일인증*/
.logoBox{width:100%;padding: 15px 10px;}
.logoBox>div{text-align:center;}
.logoBox>div>a>img{width:150px;}
#wrap{}
.body{margin-top:0px; margin-bottom:100px;}
#email_form{width:550px;height:auto;padding:20px 10px;margin:0 auto;text-align:center; border: solid 1px #e4e5ed;}
#email_form>p{margin:0 auto}
#email_num{margin: 0 atuo}
.email_Box1{width: 90%;margin: 0 auto; }
.email_Box1>p{align-items: center; text-align: center; width: auto;}
.email_Box1>form>p>input {width:382px;height:40px;border-radius: 4px; padding: 5px; margin-bottom:10px;border: solid 1px #e4e5ed;}
.email_Box2>form>input{width:382px;height:40px;border-radius: 4px; padding: 5px; margin-bottom:10px;border: solid 1px #e4e5ed;}

.email_Bt>a>img{width: 21px; margin : 0 0 2px 2px;}

</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
   function checkValue() {
      if (!document.userInfo.email.value) {
         alert("이메일 ID를 입력해주세요.");
         document.userInfo.email.focus();
         return false;
      }

   }

   function inputIdCheck(){
      document.userInfo.idCheckResult.value ="idUnCheck";
   }
   
  	function checkKey(){
  		if(!document.userKey.key.value){
  			alert("인증번호를 입력 해주세요!")
  			document.userKey.key.focus();
  			return false;
  		}
  	}
</script>
</head>
<body class="body">
	<div class="logoBox">
		<div>
			<a href="/web/main/main.do"><img
				src="<c:url value="/resources/images/logo.jpg" />" alt="logo"></a>
		</div>
	</div>
<div id="email_form">
	<c:choose>
		<c:when test="${authKey == null }">
		<div class="email_Box1">
			<form action="/web/member/auth.do" method="post" name="userInfo" onsubmit="return checkValue()" >
				<p class="email_Bt">
	      			<label for="email">이메일</label><br><br>
	      			<input id="email" type="email" name="email" placeholder="이메일을 입력해주세요" ><br><br>	
	      				<input type="submit" value="인증번호 전송">
	      				<input type="hidden" name="idCheckResult" value="emailUnCheck" />
   
      		</form>
      		</div>
		</c:when>
		<c:otherwise>
		<div class="email_Box2">
			<form action="/web/member/authKey.do" method="post" name="userKey" onsubmit="return checkKey()">
				<label>인증번호</label><br><br>
				<input type="text" name="key" placeholder="인증번호를 입력해주세요" ><br><br>
				<input type="hidden" name="email" value="${member.email }">
				<input type="hidden" name="authKey" value="${authKey }">
				<input type="submit" value="인증하기">
			</form>
			</div>
		</c:otherwise>
	</c:choose>
	
     </div>
</body>
</html>