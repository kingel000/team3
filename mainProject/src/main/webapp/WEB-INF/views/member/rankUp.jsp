<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html id="wrap">
<head>
<meta charset="utf-8">

<title>판매자 전환</title>
<script type="text/javascript">
   $(function() {

   });
</script>

<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">

</head>

<body class="body">
   <!--    <div class="logoBox">
      <div>
         <a href="index.html"><img src='/WEB-INF/images/logo.png' alt='logo'></a>
      </div>
   </div> -->
   <div id="rankUp_form">
      <div class="rankUp_Box1">
         <h4>
            <img src="<c:url value="/resources/images2/check_icon.png"/>"
               alt='check_icon'>정보 추가입력으로 전문가 전환을 진행하세요!
         </h4>
      </div>
      <div class="rankUp_Box2">
         <form action="/web/member/rankUp.do" method="post">
            <p>
               <label for="name">이름</label><br> <input id="name" type="text"
                  name="name" placeholder="이름을 입력해주세요">
            </p>
            <p>
               <label for="tel">전화번호</label><br> <input id="tel" type="text"
                  name="tel" placeholder="-를 제외하고 전화번호를 입력해주세요">
            </p>
            <p>
               <label>경력을 자유롭게 입력해주세요</label><br>
               <textarea name="career" rows="8" cols="51"></textarea>
            </p>
            <p class="join">
               <input type="hidden" value="0" name="point">
               <input type="submit" value="무료 전문가 전환 완료하기" />
            </p>
         </form>
      </div>
   </div>

</body>
</html>