<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link href="<c:url value="apple-touch-icon.png" />" rel="apple-touch-icon">
<link href="<c:url value="/resources/favicon.png" />"  rel="icon">
<meta name="author" content="Nghia Minh Luong">
<meta name="keywords" content="Default Description">
<meta name="description" content="Default keyword">
<title>Home</title>
<!-- Fonts-->
<link href="<c:url value="https://fonts.googleapis.com/css?family=Archivo+Narrow:300,400,700%7CMontserrat:300,400,500,600,700,800,900" />" rel="stylesheet">
<link href="<c:url value="/resources/plugins/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/plugins/ps-icon/style.css" />" rel="stylesheet">

<!-- CSS Library-->
<link href="<c:url value="/resources/plugins/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/plugins/owl-carousel/assets/owl.carousel.css" />" rel="stylesheet">
<link href="<c:url value="/resources/plugins/jquery-bar-rating/dist/themes/fontawesome-stars.css" />" rel="stylesheet">
<link href="<c:url value="/resources/plugins/slick/slick/slick.css" />" rel="stylesheet">
<link href="<c:url value="/resources/plugins/bootstrap-select/dist/css/bootstrap-select.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/plugins/Magnific-Popup/dist/magnific-popup.css" />" rel="stylesheet">
<link href="<c:url value="/resources/plugins/jquery-ui/jquery-ui.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/plugins/revolution/css/settings.css" />" rel="stylesheet">
<link href="<c:url value="/resources/plugins/revolution/css/layers.css" />" rel="stylesheet">
<link href="<c:url value="/resources/plugins/revolution/css/navigation.css" />" rel="stylesheet">

<!-- Custom-->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/js/home.js" />"></script>
</head>

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
							<c:when test="${member.id == null}">
								<a href="/web/member/login.do">Login </a>
								<div class="btn-group ps-dropdown"><a href="/web/member/regiser.do">Regiser</a></div>
								<!--  <div class="btn-group ps-dropdown"><a href="#">Expert</a></div>-->
							</c:when>
							<c:otherwise>
								<a href="#">${member.nick_name }</a>
								<div class="btn-group ps-dropdown" id ="ps-dropdown"></div>
								<div class="btn-group ps-dropdown"><a href="/web/member/mypage.do">MyPage</a></div>
								<div class="btn-group ps-dropdown"><a href="/web/member/logout.do">LogOut</a></div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
  <nav class="navigation">
	<div class="container-fluid">
	  <div class="navigation__column left">
		<div class="header__logo"><a class="ps-logo" href="/web/main/main.do"><img src="<c:url value="/resources/images2/itemLogo.jpg" />" alt=""></a></div>
	  </div>
	  <div class="navigation__column center">
			<ul class="main-menu menu">
			  <li class="menu-item"><a href="/web/product/mainProduct.do?category='C1'&num=1">웹 개발</a></li>
			  <li class="menu-item"><a href="/web/product/mainProduct.do?category='C2'&num=1">모바일앱·웹</a></li>
			  <li class="menu-item"><a href="/web/product/mainProduct.do?category='C3'&num=1">게임</a></li>
			  <li class="menu-item"><a href="/web/product/mainProduct.do?category='C4'&num=1">응용프로그래밍</a></li>
			  <li class="menu-item"><a href="/web/product/mainProduct.do?category='C5'&num=1">기타</a></li>
			  <li class="menu-item menu-item-has-children dropdown"><a href="#">고객센터</a>
					<ul class="sub-menu">
					  <li class="menu-item"><a href="/web/board/notice.do?num=1">공지사항</a></li>
					  <li class="menu-item"><a href="/web/board/question.do?num=1">문의사항</a></li>
					</ul>
			  </li>
			</ul>
	  </div>
	  <div class="navigation__column right">
		<form class="ps-search--header" action="/web/main/mainFind.do" method="post">
		  <input class="form-control" type="text" name="mainFindText" placeholder="상품명을 입력하세요">
		  <button><i class="ps-icon-search"></i></button>
		</form>
		<div class="ps-cart" id="ps-cart">
		  <div class="ps-cart__listing">
			<div class="ps-cart__content" id="ps-cart__content">
			<!-- 장바구니 목록 -->
				
			</div>
			<c:choose>
	           	 <c:when test="${member.id == null}">
					 <div class="ps-cart__footer"><a class="ps-btn" href="/web/member/login.do">Check out<i class="ps-icon-arrow-left"></i></a></div>
	           	 </c:when>
	            <c:otherwise>
	             	 <div class="ps-cart__footer"><a class="ps-btn" href="/web/purchase/myCart.do">Check out<i class="ps-icon-arrow-left"></i></a></div>
	           	 </c:otherwise>
	        </c:choose>
			
		  </div>
		</div>
		<div class="menu-toggle"><span></span></div>
	  </div>
	</div>
  </nav>
</header>
</body>
</html>