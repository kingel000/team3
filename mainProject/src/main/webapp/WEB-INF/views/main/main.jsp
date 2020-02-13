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

</head>

<body class="ps-loading">
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
		<div class="header__logo"><a class="ps-logo" href="index.html"><img src="<c:url value="/resources/images/logo.png" />" alt=""></a></div>
	  </div>
	  <div class="navigation__column center">
			<ul class="main-menu menu">
			  <li class="menu-item menu-item-has-children dropdown"><a href="main.jsp">Home</a>
					<ul class="sub-menu">
					  <li class="menu-item"><a href="main.jsp">Homepage #1</a></li>
					  <li class="menu-item"><a href="#">Homepage #2</a></li>
					  <li class="menu-item"><a href="#">Homepage #3</a></li>
					</ul>
			  </li>
			  <li class="menu-item menu-item-has-children has-mega-menu"><a href="#">Men</a>
				<div class="mega-menu">
				  <div class="mega-wrap">
					<div class="mega-column">
					  <ul class="mega-item mega-features">
						<li><a href="product-listing.html">NEW RELEASES</a></li>
						<li><a href="product-listing.html">FEATURES SHOES</a></li>
						<li><a href="product-listing.html">BEST SELLERS</a></li>
						<li><a href="product-listing.html">NOW TRENDING</a></li>
						<li><a href="product-listing.html">SUMMER ESSENTIALS</a></li>
						<li><a href="product-listing.html">MOTHER'S DAY COLLECTION</a></li>
						<li><a href="product-listing.html">FAN GEAR</a></li>
					  </ul>
					</div>
					<div class="mega-column">
					  <h4 class="mega-heading">Shoes</h4>
					  <ul class="mega-item">
						<li><a href="product-listing.html">All Shoes</a></li>
						<li><a href="product-listing.html">Running</a></li>
						<li><a href="product-listing.html">Training & Gym</a></li>
						<li><a href="product-listing.html">Basketball</a></li>
						<li><a href="product-listing.html">Football</a></li>
						<li><a href="product-listing.html">Soccer</a></li>
						<li><a href="product-listing.html">Baseball</a></li>
					  </ul>
					</div>
					<div class="mega-column">
					  <h4 class="mega-heading">CLOTHING</h4>
					  <ul class="mega-item">
						<li><a href="product-listing.html">Compression & Nike Pro</a></li>
						<li><a href="product-listing.html">Tops & T-Shirts</a></li>
						<li><a href="product-listing.html">Polos</a></li>
						<li><a href="product-listing.html">Hoodies & Sweatshirts</a></li>
						<li><a href="product-listing.html">Jackets & Vests</a></li>
						<li><a href="product-listing.html">Pants & Tights</a></li>
						<li><a href="product-listing.html">Shorts</a></li>
					  </ul>
					</div>
					<div class="mega-column">
					  <h4 class="mega-heading">Accessories</h4>
					  <ul class="mega-item">
						<li><a href="product-listing.html">Compression & Nike Pro</a></li>
						<li><a href="product-listing.html">Tops & T-Shirts</a></li>
						<li><a href="product-listing.html">Polos</a></li>
						<li><a href="product-listing.html">Hoodies & Sweatshirts</a></li>
						<li><a href="product-listing.html">Jackets & Vests</a></li>
						<li><a href="product-listing.html">Pants & Tights</a></li>
						<li><a href="product-listing.html">Shorts</a></li>
					  </ul>
					</div>
					<div class="mega-column">
					  <h4 class="mega-heading">BRAND</h4>
					  <ul class="mega-item">
						<li><a href="product-listing.html">NIKE</a></li>
						<li><a href="product-listing.html">Adidas</a></li>
						<li><a href="product-listing.html">Dior</a></li>
						<li><a href="product-listing.html">B&G</a></li>
					  </ul>
					</div>
				  </div>
				</div>
			  </li>
			  <li class="menu-item"><a href="#">Women</a></li>
			  <li class="menu-item"><a href="#">Kids</a></li>
			  <li class="menu-item menu-item-has-children dropdown"><a href="#">News</a>
					<ul class="sub-menu">
					  <li class="menu-item menu-item-has-children dropdown"><a href="#">Blog-grid</a>
							<ul class="sub-menu">
							  <li class="menu-item"><a href="#">Blog Grid 1</a></li>
							  <li class="menu-item"><a href="#">Blog Grid 2</a></li>
							</ul>
					  </li>
					  <li class="menu-item"><a href="#">Blog List</a></li>
					</ul>
			  </li>
			  <li class="menu-item menu-item-has-children dropdown"><a href="#">Contact</a>
					<ul class="sub-menu">
					  <li class="menu-item"><a href="#">Contact Us #1</a></li>
					  <li class="menu-item"><a href="#">Contact Us #2</a></li>
					</ul>
			  </li>
			</ul>
	  </div>
	  <div class="navigation__column right">
		<form class="ps-search--header" action="do_action" method="post">
		  <input class="form-control" type="text" placeholder="Search Product…">
		  <button><i class="ps-icon-search"></i></button>
		</form>
		<div class="ps-cart"><a class="ps-cart__toggle" href="#"><span><i>20</i></span><i class="ps-icon-shopping-cart"></i></a>
		  <div class="ps-cart__listing">
			<div class="ps-cart__content">
			  <div class="ps-cart-item"><a class="ps-cart-item__close" href="#"></a>
				<div class="ps-cart-item__thumbnail"><a href="product-detail.html"></a><img src="<c:url value="/resources/images/cart-preview/1.jpg" />" alt=""></div>
				<div class="ps-cart-item__content"><a class="ps-cart-item__title" href="product-detail.html">Amazin’ Glazin’</a>
				  <p><span>Quantity:<i>12</i></span><span>Total:<i>£176</i></span></p>
				</div>
			  </div>
			  <div class="ps-cart-item"><a class="ps-cart-item__close" href="#"></a>
				<div class="ps-cart-item__thumbnail"><a href="product-detail.html"></a><img src="<c:url value="/resources/images/cart-preview/2.jpg" />" alt=""></div>
				<div class="ps-cart-item__content"><a class="ps-cart-item__title" href="product-detail.html">The Crusty Croissant</a>
				  <p><span>Quantity:<i>12</i></span><span>Total:<i>£176</i></span></p>
				</div>
			  </div>
			  <div class="ps-cart-item"><a class="ps-cart-item__close" href="#"></a>
				<div class="ps-cart-item__thumbnail"><a href="product-detail.html"></a><img src="<c:url value="/resources/images/cart-preview/3.jpg" />"  alt=""></div>
				<div class="ps-cart-item__content"><a class="ps-cart-item__title" href="product-detail.html">The Rolling Pin</a>
				  <p><span>Quantity:<i>12</i></span><span>Total:<i>£176</i></span></p>
				</div>
			  </div>
			</div>
			<div class="ps-cart__total">
			  <p>Number of items:<span>36</span></p>
			  <p>Item Total:<span>£528.00</span></p>
			</div>
			<div class="ps-cart__footer"><a class="ps-btn" href="cart.html">Check out<i class="ps-icon-arrow-left"></i></a></div>
		  </div>
		</div>
		<div class="menu-toggle"><span></span></div>
	  </div>
	</div>
  </nav>
</header>
<main class="ps-main">
  <div class="ps-banner">
	<div class="rev_slider fullscreenbanner" id="home-banner">
	  <ul>
		<li class="ps-banner" data-index="rs-2972" data-transition="random" data-slotamount="default" data-hideafterloop="0" data-hideslideonmobile="off" data-rotate="0"><img class="rev-slidebg" src="<c:url value="/resources/images/slider/3.jpg" />"  alt="" data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="5" data-no-retina>
		  <div class="tp-caption ps-banner__header" id="layer-1" data-x="left" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['-150','-120','-150','-170']" data-width="['none','none','none','400']" data-type="text" data-responsive_offset="on" data-frames="[{&quot;delay&quot;:1000,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">
			<p>March 2002 <br> Nike SB Dunk Low Pro</p>
		  </div>
		  <div class="tp-caption ps-banner__title" id="layer21" data-x="['left','left','left','left']" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['-60','-40','-50','-70']" data-type="text" data-responsive_offset="on" data-textAlign="['center','center','center','center']" data-frames="[{&quot;delay&quot;:1200,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">
			<p class="text-uppercase">SUBA</p>
		  </div>
		  <div class="tp-caption ps-banner__description" id="layer211" data-x="['left','left','left','left']" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['30','50','50','50']" data-type="text" data-responsive_offset="on" data-textAlign="['center','center','center','center']" data-frames="[{&quot;delay&quot;:1200,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">
			<p>Supa wanted something that was going to rep his East Coast <br> roots and, more specifically, his hometown of <br/> New York City in  a big way.</p>
		  </div><a class="tp-caption ps-btn" id="layer31" href="#" data-x="['left','left','left','left']" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['120','140','200','200']" data-type="text" data-responsive_offset="on" data-textAlign="['center','center','center','center']" data-frames="[{&quot;delay&quot;:1500,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">Purchase Now<i class="ps-icon-next"></i></a>
		</li>
		<li class="ps-banner ps-banner--white" data-index="rs-100" data-transition="random" data-slotamount="default" data-hideafterloop="0" data-hideslideonmobile="off" data-rotate="0"><img class="rev-slidebg" src="<c:url value="/resources/images/slider/2.jpg" />"  alt="" data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="5" data-no-retina>
		  <div class="tp-caption ps-banner__header" id="layer20" data-x="left" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['-150','-120','-150','-170']" data-width="['none','none','none','400']" data-type="text" data-responsive_offset="on" data-frames="[{&quot;delay&quot;:1000,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">
			<p>BEST ITEM <br> THIS SUMMER</p>
		  </div>
		  <div class="tp-caption ps-banner__title" id="layer339" data-x="['left','left','left','left']" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['-60','-40','-50','-70']" data-type="text" data-responsive_offset="on" data-textAlign="['center','center','center','center']" data-frames="[{&quot;delay&quot;:1200,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">
			<p class="text-uppercase">Recovery</p>
		  </div>
		  <div class="tp-caption ps-banner__description" id="layer2-14" data-x="['left','left','left','left']" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['30','50','50','50']" data-type="text" data-responsive_offset="on" data-textAlign="['center','center','center','center']" data-frames="[{&quot;delay&quot;:1200,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">
			<p>Supa wanted something that was going to rep his East Coast <br> roots and, more specifically, his hometown of <br/> New York City in  a big way.</p>
		  </div><a class="tp-caption ps-btn" id="layer364" href="#" data-x="['left','left','left','left']" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['120','140','200','200']" data-type="text" data-responsive_offset="on" data-textAlign="['center','center','center','center']" data-frames="[{&quot;delay&quot;:1500,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">Purchase Now<i class="ps-icon-next"></i></a>
		</li>
	  </ul>
	</div>
  </div>
  <div class="ps-section--features-product ps-section masonry-root pt-100 pb-100">
	<div class="ps-container">
	  <div class="ps-section__header mb-50">
		<h3 class="ps-section__title" data-mask="features">- Features Products</h3>
		<ul class="ps-masonry__filter">
		  <li class="current"><a href="#" data-filter="*">All <sup>8</sup></a></li>
		  <li><a href="#" data-filter=".nike">Nike <sup>1</sup></a></li>
		  <li><a href="#" data-filter=".adidas">Adidas <sup>1</sup></a></li>
		  <li><a href="#" data-filter=".men">Men <sup>1</sup></a></li>
		  <li><a href="#" data-filter=".women">Women <sup>1</sup></a></li>
		  <li><a href="#" data-filter=".kids">Kids <sup>4</sup></a></li>
		</ul>
	  </div>
	  <div class="ps-section__content pb-50">
		<div class="masonry-wrapper" data-col-md="4" data-col-sm="2" data-col-xs="1" data-gap="30" data-radio="100%">
		  <div class="ps-masonry">
			<div class="grid-sizer"></div>
			<div class="grid-item kids">
			  <div class="grid-item__content-wrapper">
				<div class="ps-shoe mb-30">
				  <div class="ps-shoe__thumbnail">
					<div class="ps-badge"><span>New</span></div>
					<div class="ps-badge ps-badge--sale ps-badge--2nd"><span>-35%</span></div><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/1.jpg" />" alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
				  </div>
				  <div class="ps-shoe__content">
					<div class="ps-shoe__variants">
					  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg" />" alt=""><img src="<c:url value="/resources/images/shoe/3.jpg"  />" alt=""><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/5.jpg"  />" alt=""></div>
					  <select class="ps-rating ps-shoe__rating">
						<option value="1">1</option>
						<option value="1">2</option>
						<option value="1">3</option>
						<option value="1">4</option>
						<option value="2">5</option>
					  </select>
					</div>
					<div class="ps-shoe__detail"><a class="ps-shoe__name" href="#">Air Jordan 7 Retro</a>
					  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price">
						<del>£220</del> £ 120</span>
					</div>
				  </div>
				</div>
			  </div>
			</div>
			<div class="grid-item nike">
			  <div class="grid-item__content-wrapper">
				<div class="ps-shoe mb-30">
				  <div class="ps-shoe__thumbnail"><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/2.jpg"  />" alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
				  </div>
				  <div class="ps-shoe__content">
					<div class="ps-shoe__variants">
					  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg"  />" alt=""><img src="<c:url value="/resources/images/shoe/3.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""></div>
					  <select class="ps-rating ps-shoe__rating">
						<option value="1">1</option>
						<option value="1">2</option>
						<option value="1">3</option>
						<option value="1">4</option>
						<option value="2">5</option>
					  </select>
					</div>
					<div class="ps-shoe__detail"><a class="ps-shoe__name" href="#">Air Jordan 7 Retro</a>
					  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price"> £ 120</span>
					</div>
				  </div>
				</div>
			  </div>
			</div>
			<div class="grid-item adidas">
			  <div class="grid-item__content-wrapper">
				<div class="ps-shoe mb-30">
				  <div class="ps-shoe__thumbnail"><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/3.jpg" />"  alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
				  </div>
				  <div class="ps-shoe__content">
					<div class="ps-shoe__variants">
					  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/3.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/4.jpg"  />" alt=""><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""></div>
					  <select class="ps-rating ps-shoe__rating">
						<option value="1">1</option>
						<option value="1">2</option>
						<option value="1">3</option>
						<option value="1">4</option>
						<option value="2">5</option>
					  </select>
					</div>
					<div class="ps-shoe__detail"><a class="ps-shoe__name" href="#">Air Jordan 7 Retro</a>
					  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price"> £ 120</span>
					</div>
				  </div>
				</div>
			  </div>
			</div>
			<div class="grid-item kids">
			  <div class="grid-item__content-wrapper">
				<div class="ps-shoe mb-30">
				  <div class="ps-shoe__thumbnail">
					<div class="ps-badge ps-badge--sale"><span>-35%</span></div><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
				  </div>
				  <div class="ps-shoe__content">
					<div class="ps-shoe__variants">
					  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/3.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""></div>
					  <select class="ps-rating ps-shoe__rating">
						<option value="1">1</option>
						<option value="1">2</option>
						<option value="1">3</option>
						<option value="1">4</option>
						<option value="2">5</option>
					  </select>
					</div>
					<div class="ps-shoe__detail"><a class="ps-shoe__name" href="#">Air Jordan 7 Retro</a>
					  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price">
						<del>£220</del> £ 120</span>
					</div>
				  </div>
				</div>
			  </div>
			</div>
			<div class="grid-item men">
			  <div class="grid-item__content-wrapper">
				<div class="ps-shoe mb-30">
				  <div class="ps-shoe__thumbnail"><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
				  </div>
				  <div class="ps-shoe__content">
					<div class="ps-shoe__variants">
					  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg"  />" alt=""><img src="<c:url value="/resources/images/shoe/3.jpg"  />" alt=""><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""></div>
					  <select class="ps-rating ps-shoe__rating">
						<option value="1">1</option>
						<option value="1">2</option>
						<option value="1">3</option>
						<option value="1">4</option>
						<option value="2">5</option>
					  </select>
					</div>
					<div class="ps-shoe__detail"><a class="ps-shoe__name" href="#">Air Jordan 7 Retro</a>
					  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price"> £ 120</span>
					</div>
				  </div>
				</div>
			  </div>
			</div>
			<div class="grid-item women">
			  <div class="grid-item__content-wrapper">
				<div class="ps-shoe mb-30">
				  <div class="ps-shoe__thumbnail"><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/6.jpg" />"  alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
				  </div>
				  <div class="ps-shoe__content">
					<div class="ps-shoe__variants">
					  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/3.jpg" />" alt=""><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/5.jpg"  />" alt=""></div>
					  <select class="ps-rating ps-shoe__rating">
						<option value="1">1</option>
						<option value="1">2</option>
						<option value="1">3</option>
						<option value="1">4</option>
						<option value="2">5</option>
					  </select>
					</div>
					<div class="ps-shoe__detail"><a class="ps-shoe__name" href="#">Air Jordan 7 Retro</a>
					  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price"> £ 120</span>
					</div>
				  </div>
				</div>
			  </div>
			</div>
			<div class="grid-item kids">
			  <div class="grid-item__content-wrapper">
				<div class="ps-shoe mb-30">
				  <div class="ps-shoe__thumbnail"><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/7.jpg" />" alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
				  </div>
				  <div class="ps-shoe__content">
					<div class="ps-shoe__variants">
					  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/3.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""></div>
					  <select class="ps-rating ps-shoe__rating">
						<option value="1">1</option>
						<option value="1">2</option>
						<option value="1">3</option>
						<option value="1">4</option>
						<option value="2">5</option>
					  </select>
					</div>
					<div class="ps-shoe__detail"><a class="ps-shoe__name" href="#">Air Jordan 7 Retro</a>
					  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price"> £ 120</span>
					</div>
				  </div>
				</div>
			  </div>
			</div>
			<div class="grid-item kids">
			  <div class="grid-item__content-wrapper">
				<div class="ps-shoe mb-30">
				  <div class="ps-shoe__thumbnail"><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/8.jpg" />"  alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
				  </div>
				  <div class="ps-shoe__content">
					<div class="ps-shoe__variants">
					  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/3.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""></div>
					  <select class="ps-rating ps-shoe__rating">
						<option value="1">1</option>
						<option value="1">2</option>
						<option value="1">3</option>
						<option value="1">4</option>
						<option value="2">5</option>
					  </select>
					</div>
					<div class="ps-shoe__detail"><a class="ps-shoe__name" href="#">Air Jordan 7 Retro</a>
					  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price"> £ 120</span>
					</div>
				  </div>
				</div>
			  </div>
			</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
  <div class="ps-section--offer">
	<div class="ps-column"><a class="ps-offer" href="product-listing.html"><img src="<c:url value="/resources/images/banner/home-banner-1.png" />"  alt=""></a></div>
	<div class="ps-column"><a class="ps-offer" href="product-listing.html"><img src="<c:url value="/resources/images/banner/home-banner-2.png" />"  alt=""></a></div>
  </div>
  <div class="ps-section--sale-off ps-section pt-80 pb-40">
	<div class="ps-container">
	  <div class="ps-section__header mb-50">
		<h3 class="ps-section__title" data-mask="Sale off">- Hot Deal Today</h3>
	  </div>
	  <div class="ps-section__content">
		<div class="row">
			  <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12 ">
				<div class="ps-hot-deal">
				  <h3>Nike DUNK Max 95 OG</h3>
				  <p class="ps-hot-deal__price">Only:  <span>£155</span></p>
				  <ul class="ps-countdown" data-time="December 13, 2017 15:37:25">
					<li><span class="hours"></span><p>Hours</p></li>
					<li class="divider">:</li>
					<li><span class="minutes"></span><p>minutes</p></li>
					<li class="divider">:</li>
					<li><span class="seconds"></span><p>Seconds</p></li>
				  </ul><a class="ps-btn" href="#">Order Today<i class="ps-icon-next"></i></a>
				</div>
			  </div>
			  <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12 ">
				<div class="ps-hotspot"><a class="point first active" href="javascript:;"><i class="fa fa-plus"></i>
					<div class="ps-hotspot__content">
					  <p class="heading">JUMP TO HEADER</p>
					  <p>Dynamic Fit Collar en la zona del tobillo que une la parte inferior de la pierna y el pie sin reducir la libertad de movimiento.</p>
					</div></a><a class="point second" href="javascript:;"><i class="fa fa-plus"></i>
					<div class="ps-hotspot__content">
					  <p class="heading">JUMP TO HEADER</p>
					  <p>Dynamic Fit Collar en la zona del tobillo que une la parte inferior de la pierna y el pie sin reducir la libertad de movimiento.</p>
					</div></a><a class="point third" href="javascript:;"><i class="fa fa-plus"></i>
					<div class="ps-hotspot__content">
					  <p class="heading">JUMP TO HEADER</p>
					  <p>Dynamic Fit Collar en la zona del tobillo que une la parte inferior de la pierna y el pie sin reducir la libertad de movimiento.</p>
					</div></a><img src="<c:url value="/resources/images/hot-deal.png" />"  alt=""></div>
			  </div>
		</div>
	  </div>
	</div>
  </div>
  <div class="ps-section ps-section--top-sales ps-owl-root pt-80 pb-80">
	<div class="ps-container">
	  <div class="ps-section__header mb-50">
		<div class="row">
			  <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 ">
				<h3 class="ps-section__title" data-mask="BEST SALE">- Top Sales</h3>
			  </div>
			  <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 ">
				<div class="ps-owl-actions"><a class="ps-prev" href="#"><i class="ps-icon-arrow-right"></i>Prev</a><a class="ps-next" href="#">Next<i class="ps-icon-arrow-left"></i></a></div>
			  </div>
		</div>
	  </div>
	  <div class="ps-section__content">
		<div class="ps-owl--colection owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="5000" data-owl-gap="30" data-owl-nav="false" data-owl-dots="false" data-owl-item="4" data-owl-item-xs="1" data-owl-item-sm="2" data-owl-item-md="3" data-owl-item-lg="4" data-owl-duration="1000" data-owl-mousedrag="on">
		  <div class="ps-shoes--carousel">
			<div class="ps-shoe">
			  <div class="ps-shoe__thumbnail">
				<div class="ps-badge"><span>New</span></div><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/1.jpg" />"  alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
			  </div>
			  <div class="ps-shoe__content">
				<div class="ps-shoe__variants">
				  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/3.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""></div>
				  <select class="ps-rating ps-shoe__rating">
					<option value="1">1</option>
					<option value="1">2</option>
					<option value="1">3</option>
					<option value="1">4</option>
					<option value="2">5</option>
				  </select>
				</div>
				<div class="ps-shoe__detail"><a class="ps-shoe__name" href="product-detai.html">Air Jordan 7 Retro</a>
				  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price"> £ 120</span>
				</div>
			  </div>
			</div>
		  </div>
		  <div class="ps-shoes--carousel">
			<div class="ps-shoe">
			  <div class="ps-shoe__thumbnail">
				<div class="ps-badge"><span>New</span></div>
				<div class="ps-badge ps-badge--sale ps-badge--2nd"><span>-35%</span></div><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/2.jpg" />"  alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
			  </div>
			  <div class="ps-shoe__content">
				<div class="ps-shoe__variants">
				  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/3.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""></div>
				  <select class="ps-rating ps-shoe__rating">
					<option value="1">1</option>
					<option value="1">2</option>
					<option value="1">3</option>
					<option value="1">4</option>
					<option value="2">5</option>
				  </select>
				</div>
				<div class="ps-shoe__detail"><a class="ps-shoe__name" href="product-detai.html">Air Jordan 7 Retro</a>
				  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price">
					<del>£220</del> £ 120</span>
				</div>
			  </div>
			</div>
		  </div>
		  <div class="ps-shoes--carousel">
			<div class="ps-shoe">
			  <div class="ps-shoe__thumbnail">
				<div class="ps-badge"><span>New</span></div><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/3.jpg" />"  alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
			  </div>
			  <div class="ps-shoe__content">
				<div class="ps-shoe__variants">
				  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/3.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""></div>
				  <select class="ps-rating ps-shoe__rating">
					<option value="1">1</option>
					<option value="1">2</option>
					<option value="1">3</option>
					<option value="1">4</option>
					<option value="2">5</option>
				  </select>
				</div>
				<div class="ps-shoe__detail"><a class="ps-shoe__name" href="product-detai.html">Air Jordan 7 Retro</a>
				  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price"> £ 120</span>
				</div>
			  </div>
			</div>
		  </div>
		  <div class="ps-shoes--carousel">
			<div class="ps-shoe">
			  <div class="ps-shoe__thumbnail"><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
			  </div>
			  <div class="ps-shoe__content">
				<div class="ps-shoe__variants">
				  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/3.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""></div>
				  <select class="ps-rating ps-shoe__rating">
					<option value="1">1</option>
					<option value="1">2</option>
					<option value="1">3</option>
					<option value="1">4</option>
					<option value="2">5</option>
				  </select>
				</div>
				<div class="ps-shoe__detail"><a class="ps-shoe__name" href="product-detai.html">Air Jordan 7 Retro</a>
				  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price"> £ 120</span>
				</div>
			  </div>
			</div>
		  </div>
		  <div class="ps-shoes--carousel">
			<div class="ps-shoe">
			  <div class="ps-shoe__thumbnail">
				<div class="ps-badge"><span>New</span></div><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
			  </div>
			  <div class="ps-shoe__content">
				<div class="ps-shoe__variants">
				  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/3.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""></div>
				  <select class="ps-rating ps-shoe__rating">
					<option value="1">1</option>
					<option value="1">2</option>
					<option value="1">3</option>
					<option value="1">4</option>
					<option value="2">5</option>
				  </select>
				</div>
				<div class="ps-shoe__detail"><a class="ps-shoe__name" href="product-detai.html">Air Jordan 7 Retro</a>
				  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price"> £ 120</span>
				</div>
			  </div>
			</div>
		  </div>
		  <div class="ps-shoes--carousel">
			<div class="ps-shoe">
			  <div class="ps-shoe__thumbnail"><a class="ps-shoe__favorite" href="#"><i class="ps-icon-heart"></i></a><img src="<c:url value="/resources/images/shoe/6.jpg" />"  alt=""><a class="ps-shoe__overlay" href="product-detail.html"></a>
			  </div>
			  <div class="ps-shoe__content">
				<div class="ps-shoe__variants">
				  <div class="ps-shoe__variant normal"><img src="<c:url value="/resources/images/shoe/2.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/3.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/4.jpg" />"  alt=""><img src="<c:url value="/resources/images/shoe/5.jpg" />"  alt=""></div>
				  <select class="ps-rating ps-shoe__rating">
					<option value="1">1</option>
					<option value="1">2</option>
					<option value="1">3</option>
					<option value="1">4</option>
					<option value="2">5</option>
				  </select>
				</div>
				<div class="ps-shoe__detail"><a class="ps-shoe__name" href="product-detai.html">Air Jordan 7 Retro</a>
				  <p class="ps-shoe__categories"><a href="#">Men shoes</a>,<a href="#"> Nike</a>,<a href="#"> Jordan</a></p><span class="ps-shoe__price"> £ 120</span>
				</div>
			  </div>
			</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
  
  <div class="ps-footer bg--cover" data-background="<c:url value="/resources/images/background/parallax.jpg" />">
	<div class="ps-footer__content">
	  <div class="ps-container">
		<div class="row">
			  <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 ">
				<aside class="ps-widget--footer ps-widget--info">
				  <header><a class="ps-logo" href="main.jsp"><img src="<c:url value="/resources/images/logo-white.png" />"  alt=""></a>
					<h3 class="ps-widget__title">Address Office 1</h3>
				  </header>
				  <footer>
					<p><strong>460 West 34th Street, 15th floor, New York</strong></p>
					<p>Email: <a href='mailto:support@store.com'>support@store.com</a></p>
					<p>Phone: +323 32434 5334</p>
					<p>Fax: ++323 32434 5333</p>
				  </footer>
				</aside>
			  </div>
			  <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 ">
				<aside class="ps-widget--footer ps-widget--info second">
				  <header>
					<h3 class="ps-widget__title">Address Office 2</h3>
				  </header>
				  <footer>
					<p><strong>PO Box 16122 Collins  Victoria 3000 Australia</strong></p>
					<p>Email: <a href='mailto:support@store.com'>support@store.com</a></p>
					<p>Phone: +323 32434 5334</p>
					<p>Fax: ++323 32434 5333</p>
				  </footer>
				</aside>
			  </div>
			  <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12 ">
				<aside class="ps-widget--footer ps-widget--link">
				  <header>
					<h3 class="ps-widget__title">Find Our store</h3>
				  </header>
				  <footer>
					<ul class="ps-list--link">
					  <li><a href="#">Coupon Code</a></li>
					  <li><a href="#">SignUp For Email</a></li>
					  <li><a href="#">Site Feedback</a></li>
					  <li><a href="#">Careers</a></li>
					</ul>
				  </footer>
				</aside>
			  </div>
			  <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12 ">
				<aside class="ps-widget--footer ps-widget--link">
				  <header>
					<h3 class="ps-widget__title">Get Help</h3>
				  </header>
				  <footer>
					<ul class="ps-list--line">
					  <li><a href="#">Order Status</a></li>
					  <li><a href="#">Shipping and Delivery</a></li>
					  <li><a href="#">Returns</a></li>
					  <li><a href="#">Payment Options</a></li>
					  <li><a href="#">Contact Us</a></li>
					</ul>
				  </footer>
				</aside>
			  </div>
			  <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12 ">
				<aside class="ps-widget--footer ps-widget--link">
				  <header>
					<h3 class="ps-widget__title">Products</h3>
				  </header>
				  <footer>
					<ul class="ps-list--line">
					  <li><a href="#">Shoes</a></li>
					  <li><a href="#">Clothing</a></li>
					  <li><a href="#">Accessries</a></li>
					  <li><a href="#">Football Boots</a></li>
					</ul>
				  </footer>
				</aside>
			  </div>
		</div>
	  </div>
	</div>
  </div>
</main>
<!-- JS Library-->
<script type="text/javascript" src="<c:url value="/resources/plugins/jquery/dist/jquery.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/bootstrap/dist/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/jquery-bar-rating/dist/jquery.barrating.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/owl-carousel/owl.carousel.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/gmap3.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/imagesloaded.pkgd.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/isotope.pkgd.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/bootstrap-select/dist/js/bootstrap-select.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/jquery.matchHeight-min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/slick/slick/slick.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/elevatezoom/jquery.elevatezoom.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/Magnific-Popup/dist/jquery.magnific-popup.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/jquery-ui/jquery-ui.min.js" />"></script>
<script type="text/javascript" src="http://ditu.google.cn/maps/api/js?key=AIzaSyAx39JFH5nhxze1ZydH-Kl8xXM3OK4fvcg&amp;region=GB"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/revolution/js/jquery.themepunch.tools.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/revolution/js/jquery.themepunch.revolution.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.video.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.slideanims.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.layeranimation.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.navigation.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.parallax.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.actions.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.kenburn.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.migration.min.js" />"></script>
<!-- Custom scripts-->
<script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>