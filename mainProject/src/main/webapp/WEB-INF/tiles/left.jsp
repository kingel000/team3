<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<link href="apple-touch-icon.png" rel="apple-touch-icon">
<link href="favicon.png" rel="icon">
<meta name="author" content="Nghia Minh Luong">
<meta name="keywords" content="Default Description">
<meta name="description" content="Default keyword">

<title>template</title>

<!-- Fonts-->
<link
   href="https://fonts.googleapis.com/css?family=Archivo+Narrow:300,400,700%7CMontserrat:300,400,500,600,700,800,900"
   rel="stylesheet">
<link rel="stylesheet"
   href="<c:url value="/resources/plugins/font-awesome/css/font-awesome.min.css"/>">
<link rel="stylesheet"
   href="<c:url value="/resources/plugins/ps-icon/style.css"/>">
<!-- CSS Library-->
<link rel="stylesheet"
   href="<c:url value="/resources/plugins/bootstrap/dist/css/bootstrap.min.css" />">

<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">
</head>
<body>
   <div class="myPage_menu">
      <ul>
         <div class="mypage_title">
            <a href="mypage.do">MY PAGE</a>
         </div>
         <li class="group">
            <div class="box">
               <a href="/web/member/editMember.do">
                  <h3>Edit Member</h3>
                  <p>회원 정보 수정</p>
               </a>
            </div>
         </li>
         
         <c:choose>
            <c:when test="${member.rank == 'N'}">
                <li class="group">
               <div class="box">
                    <a href="/web/member/rankUp.do">
                     <h3>Expert</h3>
                     <p>전문가 전환</p>
                  </a>
                </div>
            </li>
            </c:when>
            <c:otherwise>
             <li class="group">
               <div class="box">
                    <a href="/web/member/editExpert.do">
                     <h3>Expert</h3>
                     <p>전문가 정보</p>
                  </a>
                </div>
            </li>
            </c:otherwise>
         </c:choose>
    
         <li class="group">
            <div class="box">
               <a href="#">
                  <h3>Order List</h3>
                  <p>구매 내역</p>
               </a>
            </div>
         </li>
         <li class="group">
            <div class="box">
               <a href="#">
                  <h3>Board</h3>
                  <p>게시물 관리</p>
               </a>
            </div>
         </li>
         <li class="group">
            <div class="box">
               <a href="/web/member/withdrawal.do">
                  <h3>Withdrawal</h3>
                  <p>회원 탈퇴</p>
               </a>
            </div>
         </li>
      </ul>
   </div>
</body>
</html>