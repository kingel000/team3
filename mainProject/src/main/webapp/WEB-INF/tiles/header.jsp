<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--[if IE 7]><html class="ie ie7"><![endif]-->
<!--[if IE 8]><html class="ie ie8"><![endif]-->
<!--[if IE 9]><html class="ie ie9"><![endif]-->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<link href="apple-touch-icon.png" rel="apple-touch-icon">
<link href="<c:url value="/resources/favicon.png" />" rel="icon">
<meta name="author" content="Nghia Minh Luong">
<meta name="keywords" content="Default Description">
<meta name="description" content="Default keyword">
<title>Home</title>
<!-- Fonts-->
<link
   href="https://fonts.googleapis.com/css?family=Archivo+Narrow:300,400,700%7CMontserrat:300,400,500,600,700,800,900"
   rel="stylesheet">
<link
   href="<c:url value="/resources/plugins/font-awesome/css/font-awesome.min.css" />"
   rel="stylesheet">
<link href="<c:url value="/resources/plugins/ps-icon/style.css" />"
   rel="stylesheet">

<!-- CSS Library-->
<link
   href="<c:url value="/resources/plugins/bootstrap/dist/css/bootstrap.min.css" />"
   rel="stylesheet">
<link
   href="<c:url value="/resources/plugins/owl-carousel/assets/owl.carousel.css" />"
   rel="stylesheet">
<link
   href="<c:url value="/resources/plugins/jquery-bar-rating/dist/themes/fontawesome-stars.css" />"
   rel="stylesheet">
<link href="<c:url value="/resources/plugins/slick/slick/slick.css" />"
   rel="stylesheet">
<link
   href="<c:url value="/resources/plugins/bootstrap-select/dist/css/bootstrap-select.min.css" />"
   rel="stylesheet">
<link
   href="<c:url value="/resources/plugins/Magnific-Popup/dist/magnific-popup.css" />"
   rel="stylesheet">
<link
   href="<c:url value="/resources/plugins/jquery-ui/jquery-ui.min.css" />"
   rel="stylesheet">
<link
   href="<c:url value="/resources/plugins/revolution/css/settings.css" />"
   rel="stylesheet">
<link
   href="<c:url value="/resources/plugins/revolution/css/layers.css" />"
   rel="stylesheet">
<link
   href="<c:url value="/resources/plugins/revolution/css/navigation.css" />"
   rel="stylesheet">

<!-- Custom-->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<!--HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries-->
<!--WARNING: Respond.js doesn't work if you view the page via file://-->
<!--[if lt IE 9]><script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script><script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!--[if IE 7]><body class="ie7 lt-ie8 lt-ie9 lt-ie10"><![endif]-->
<!--[if IE 8]><body class="ie8 lt-ie9 lt-ie10"><![endif]-->
<!--[if IE 9]><body class="ie9 lt-ie10"><![endif]-->
<body>
   <div class="header--sidebar"></div>
   <header class="header">
      <div class="header__top">
         <div class="container-fluid">
            <div class="row">
               <div class="col-lg-6 col-md-8 col-sm-6 col-xs-12 ">
                  <p></p>
               </div>
               <div class="col-lg-6 col-md-4 col-sm-6 col-xs-12 ">
                  <div class="header__actions">
                     <c:choose>
                        <c:when test="${member == null}">
                           <a href="/web/member/login.do">Login </a>
                           <div class="btn-group ps-dropdown">
                              <a href="/web/member/regiser.do">Regiser</a>
                           </div>
                           <!--  <div class="btn-group ps-dropdown"><a href="#">Expert</a></div>-->
                        </c:when>
                        <c:otherwise>
                           <a href="#">${member.nick_name }</a>
                           <div class="btn-group ps-dropdown">
                              <a href="/web/member/mypage.do">MyPage</a>
                           </div>
                           <div class="btn-group ps-dropdown">
                              <a href="/web/member/logout.do">LogOut</a>
                           </div>
                        </c:otherwise>
                     </c:choose>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </header>
</body>
</html>