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


<main class="ps-main">
  <div class="ps-banner">
	<div class="rev_slider fullscreenbanner" id="home-banner">
	  <ul>
		<li class="ps-banner" data-index="rs-2972" data-transition="random" data-slotamount="default" data-hideafterloop="0" data-hideslideonmobile="off" data-rotate="0"><img class="rev-slidebg" src="/web/ajax/display.do?fileName=${bannerVO.banner1_img}" alt="" data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="5" data-no-retina>
		  <div class="tp-caption ps-banner__header" id="layer-1" data-x="left" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['-150','-120','-150','-170']" data-width="['none','none','none','400']" data-type="text" data-responsive_offset="on" data-frames="[{&quot;delay&quot;:1000,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">
			<p id="slide1_text1">${bannerVO.banner1_text1} <br> ${bannerVO.banner1_text2}</p>
		  </div>
		  <div class="tp-caption ps-banner__title" id="layer21" data-x="['left','left','left','left']" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['-60','-40','-50','-70']" data-type="text" data-responsive_offset="on" data-textAlign="['center','center','center','center']" data-frames="[{&quot;delay&quot;:1200,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">
			<p id="slide1_text2" class="text-uppercase">${bannerVO.banner1_text3}</p>
		  </div>
		  <div class="tp-caption ps-banner__description" id="layer211" data-x="['left','left','left','left']" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['30','50','50','50']" data-type="text" data-responsive_offset="on" data-textAlign="['center','center','center','center']" data-frames="[{&quot;delay&quot;:1200,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">
			<p id="slide1_text3">${bannerVO.banner1_text4}</p>
		</div>
		</li>
		<li class="ps-banner ps-banner--white" data-index="rs-100" data-transition="random" data-slotamount="default" data-hideafterloop="0" data-hideslideonmobile="off" data-rotate="0"><img class="rev-slidebg" src="/web/ajax/display.do?fileName=${bannerVO.banner2_img}" alt="" data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="5" data-no-retina>
		  <div class="tp-caption ps-banner__header" id="layer20" data-x="left" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['-150','-120','-150','-170']" data-width="['none','none','none','400']" data-type="text" data-responsive_offset="on" data-frames="[{&quot;delay&quot;:1000,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">
			<p id="slide2_text1">${bannerVO.banner2_text1}</p>
		  </div>
		  <div class="tp-caption ps-banner__title" id="layer339" data-x="['left','left','left','left']" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['-60','-40','-50','-70']" data-type="text" data-responsive_offset="on" data-textAlign="['center','center','center','center']" data-frames="[{&quot;delay&quot;:1200,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">
			<p id="slide2_text2" class="text-uppercase">${bannerVO.banner2_text2}</p>
		  </div>
		  <div id="slide2_text2" class="tp-caption ps-banner__description" id="layer2-14" data-x="['left','left','left','left']" data-hoffset="['-60','15','15','15']" data-y="['middle','middle','middle','middle']" data-voffset="['30','50','50','50']" data-type="text" data-responsive_offset="on" data-textAlign="['center','center','center','center']" data-frames="[{&quot;delay&quot;:1200,&quot;speed&quot;:1500,&quot;frame&quot;:&quot;0&quot;,&quot;from&quot;:&quot;x:50px;opacity:0;&quot;,&quot;to&quot;:&quot;o:1;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;},{&quot;delay&quot;:&quot;wait&quot;,&quot;speed&quot;:300,&quot;frame&quot;:&quot;999&quot;,&quot;to&quot;:&quot;x:50px;opacity:0;&quot;,&quot;ease&quot;:&quot;Power3.easeInOut&quot;}]">
			<p>${bannerVO.banner2_text3} <br> ${bannerVO.banner2_text4} </p>
			</div>
		</li>
	  </ul>
	</div>
  </div>


  
  <div class="ps-section ps-section--top-sales ps-owl-root pt-80 pb-80">
	<div class="ps-container">
	  <div class="ps-section__header mb-50">
		<div class="row">
			  <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 ">
				<h3 class="ps-section__title" data-mask="New product">- NEW ITEMS</h3>
			  </div>
			  <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 ">
				<div class="ps-owl-actions"><a class="ps-prev" href="#"><i class="ps-icon-arrow-right"></i>이전 상품</a><a class="ps-next" href="#">다음 상품<i class="ps-icon-arrow-left"></i></a></div>
			  </div>
		</div>
	  </div>
	  <div class="ps-section__content">
		<div class="ps-owl--colection owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="5000" data-owl-gap="30" data-owl-nav="false" data-owl-dots="false" data-owl-item="4" data-owl-item-xs="1" data-owl-item-sm="2" data-owl-item-md="3" data-owl-item-lg="4" data-owl-duration="1000" data-owl-mousedrag="on">
		  
		  
		  
		  
		  <c:forEach var="newProduct" items="${newProductList}" varStatus="status">
			  <div class="ps-shoes--carousel">
				<div class="ps-shoe">
				  <div class="ps-shoe__thumbnail">
					<div class="ps-badge"><span>New</span></div>
						<a class="ps-shoe__favorite" href="#">
							<i class="ps-icon-heart"></i>
						</a>
						
							<c:choose>
									<c:when test="${newProduct.thumbnail == null}">
										 <img src="<c:url value="/resources/images/basic2.jpg" />"  alt="">
									</c:when>
									<c:otherwise>
										<img src="/web/ajax/display.do?fileName=${newProduct.thumbnail}" alt="#" style="width: 300px; height: 205px;">
									</c:otherwise>
        					</c:choose>
							
						<a class="ps-shoe__overlay" href="/web/product/detailProduct.do?num=${newProduct.product_num}"></a>
				  </div>			  
				  <div class="ps-shoe__content">
					<div class="ps-shoe__variants">
						<p><p>
					 	<p>IT분야의 검증된 전문가와 상담 후 <p>
					 	만족스럽고 멋진 결과를 받아보세요! <p>
					</div>
					<div class="ps-shoe__detail"><a class="ps-shoe__name" href="/web/product/detailProduct.do?num=${newProduct.product_num}">${newProduct.product_title}</a>
					  <c:if test="${newProduct.category == '웹 개발'}">
					  		<p class="ps-shoe__categories"><a href="/web/product/mainProduct.do?category='C1'&num=1">카테고리 : ${newProduct.category}</a></p><span class="ps-shoe__price"></span>
					  </c:if>
					  <c:if test="${newProduct.category == '모바일앱·웹'}">
					  		<p class="ps-shoe__categories"><a href="/web/product/mainProduct.do?category='C2'&num=1">카테고리 : ${newProduct.category}</a></p><span class="ps-shoe__price"></span>
					  </c:if>
					  <c:if test="${newProduct.category == '게임'}">
					  		<p class="ps-shoe__categories"><a href="/web/product/mainProduct.do?category='C3'&num=1">카테고리 : ${newProduct.category}</a></p><span class="ps-shoe__price"></span>
					  </c:if>
					  <c:if test="${newProduct.category == '응용프로그래밍'}">
					  		<p class="ps-shoe__categories"><a href="/web/product/mainProduct.do?category='C4'&num=1">카테고리 : ${newProduct.category}</a></p><span class="ps-shoe__price"></span>
					  </c:if>
					  <c:if test="${newProduct.category == '기타'}">
					  		<p class="ps-shoe__categories"><a href="/web/product/mainProduct.do?category='C5'&num=1">카테고리 : ${newProduct.category}</a></p><span class="ps-shoe__price"></span>
					  </c:if>
					  	
					</div>
				  </div>
				</div>
			  </div>
		  </c:forEach>

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