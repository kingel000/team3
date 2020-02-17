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

<script type="text/javascript">
   // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
   function checkValue() {
      /* if (!document.userInfo.id.value) {
         alert("이메일 ID를 입력해주세요.");
         document.userInfo.id.focus();
         return false;
      }
      if (document.userInfo.idCheckResult.value != "idCheck") {
         alert("이메일인증을 해주세요.");
         return false;
      } */
      if (!document.userInfo.nick_name.value) {
         alert("닉네임을 입력해주세요.");
         document.userInfo.nick_name.focus();
         return false;
      }

      if (!document.userInfo.pwd.value) {
         alert("패스워드를 입력해주세요.");
         document.userInfo.pwd.focus();
         return false;
      }
      if (!document.userInfo.pwd2.value) {
         alert("패스워드확인을 입력해주세요.");
         document.userInfo.pwd2.focus();
         return false;
      }
      if (document.userInfo.pwd.value != document.userInfo.pwd2.value) {
         alert("패스워드 동일하게 입력해주세요..");
         document.userInfo.pwd.focus();
         return false;
      }
   }
   /* function emailCheck(){
      document.userInfo.idCheckResult.value ="idCheck";
   }
   function inputIdCheck(){
      document.userInfo.idCheckResult.value ="idUnCheck";
   } */
</script>

</head>

<body class="body">
   <div class="logoBox">
      <div>
         <a href="/web/main/main.do"><img
            src="<c:url value="/resources/images/logo.png" />" alt="logo"></a>
      </div>
   </div>
   <div id="regider_form">
      
      <div class="regider_Box2">
         <form action="/web/member/regiser.do" method="post" name="userInfo" onsubmit="return checkValue()">
            <p>
               <label for="name">닉네임</label><br> <input id="nick_name" type="text"
                  name="nick_name" placeholder="닉네임을 입력해주세요">
            </p>
            <p>
               <label for="password">비밀번호</label><br> <input id="pwd"
                  type="password" name="pwd" placeholder="비밀번호를 입력해주세요">
            </p>
            <p>
               <label for="password">비밀번호 확인</label><br> <input id="pwd2"
                  type="password" name="pwd2" placeholder="비밀번호 확인">
            </p>
            <p class="join">
               <input type="hidden" name="id" value="${member.id }">
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