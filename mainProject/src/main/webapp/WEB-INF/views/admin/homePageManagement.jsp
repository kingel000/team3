<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>홈페이지 관리</title>
	
	<!-- Custom-->
	<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">
	<style type="text/css">
		.title{color:#fff; text-align:center; background-color: #2ac37d;}
	</style>
</head>
<body class="body">
	<h3 class="title">홈페이지 관리</h3><br>
   <div id="rankUp_form">
      <div class="rankUp_Box1">
         <h4>
            	첫번째 main Slide 변경하기
         </h4>
      </div>
      <div class="rankUp_Box2">
         <form action="#" method="post">
            <p>
               <label for="name">*이미지1* </label> <br>
               <button>이미지 변경</button> 선택되어있는 이미지 경로 출력
            </p>
            <p>
               <label>*배너 내용1*</label><br>
               <textarea name="career" rows="8" cols="51"></textarea>
            </p>
            <p class="join">
               <input type="submit" value="변경 완료하기" />
            </p>
         </form>
      </div>
   </div><br>
   
   
   <div id="rankUp_form">
      <div class="rankUp_Box1">
         <h4>
            	두번째 main Slide 변경하기
         </h4>
      </div>
      <div class="rankUp_Box2">
         <form action="#" method="post">
            <p>
               <label for="name">*이미지2* </label> <br>
               <button>이미지 변경</button> 선택되어있는 이미지 경로 출력
            </p>
            <p>
               <label>*배너 내용2*</label><br>
               <textarea name="career" rows="8" cols="51" ></textarea>
            </p>
            <p class="join">
               <input type="submit" value="변경 완료하기" />
            </p>
         </form>
      </div>
   </div>

</body>
</html>