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
	 <div class="myPage_menu" align="left">
      <ul>
         <div class="mypage_title">
            <a href="/web/admin/adminDetail.mdo">MASTER PAGE</a>
         </div><br>
         <li class="group">
            <div class="box">
               <a href="/web/admin/memberManager.mdo?num=1">
                  <h3>Member Manager</h3>
                  <p>회원 정보 관리</p>
               </a>
            </div>
         </li>
         <li class="group">
   		      <div class="box">
                  <a href="/web/admin/adminProduct.mdo?num=1">
                     <h3>Product Manager</h3>
                     <p>상품 관리</p>
                  </a>
              </div>
          </li>
         <li class="group">
            <div class="box">
               <a href="/web/admin/adminpurchase.mdo?num=1">
                  <h3>Transaction history</h3>
                  <p>거래 내역</p>
               </a>
            </div>
         </li>
         <li class="group">
            <div class="box">
               <a href="/web/admin/adminPoint.mdo?num=1">
                  <h3>Point</h3>
                  <p>금액 관리</p>
               </a>
            </div>
         </li>
         
        <!-- *******20200229 -->
         <li class="group">
            <div class="box">
          	  <a href="/web/admin/adminBoardNotice.mdo?num=1">
                  <h3>Borad_Notice</h3>
                  <p>공지사항 관리</p>
               </a>
            </div>
         </li>
                 <!-- *******20200229 -->
         <li class="group">
            <div class="box">
          	  <a href="/web/admin/adminBoardQuestion.mdo?num=1">
                  <h3>Borad_Question</h3>
                  <p>문의사항 관리</p>
               </a>
            </div>
         </li>
         
         <li class="group">
            <div class="box">
               <a href="/web/admin/homePageManagement.mdo">
                  <h3>HomePage</h3>
                  <p>홈페이지 관리</p>
               </a>
            </div>
         </li>
         <li class="group">
            <div class="box">
          	  <button onclick="window.open('chartMain.mdo')"> * 통계관리 이동하기 * </button>
            </div>
         </li>
         
         
      </ul>
   </div>
</body>
</html>