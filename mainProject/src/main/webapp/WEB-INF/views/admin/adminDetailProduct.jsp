<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="apple-touch-icon.png" rel="apple-touch-icon">
<link href="<c:url value="/resources/favicon.png"/>" rel="icon">
<!-- Fonts-->
<link href="https://fonts.googleapis.com/css?family=Archivo+Narrow:300,400,700%7CMontserrat:300,400,500,600,700,800,900" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/plugins/font-awesome/css/font-awesome.min.css" />">
<link rel="stylesheet" href="<c:url value="/resources/plugins/ps-icon/style.css" />">
<!-- CSS Library-->
<link rel="stylesheet" href="<c:url value="/resources/plugins/bootstrap/dist/css/bootstrap.min.css" />">
<link rel="stylesheet" href="<c:url value="/resources/plugins/owl-carousel/assets/owl.carousel.css" />">
<link rel="stylesheet" href="<c:url value="/resources/plugins/jquery-bar-rating/dist/themes/fontawesome-stars.css" />">
<link rel="stylesheet" href="<c:url value="/resources/plugins/slick/slick/slick.css" />">
<link rel="stylesheet" href="<c:url value="/resources/plugins/bootstrap-select/dist/css/bootstrap-select.min.css" />">
<link rel="stylesheet" href="<c:url value="/resources/plugins/Magnific-Popup/dist/magnific-popup.css" />">
<link rel="stylesheet" href="<c:url value="/resources/plugins/jquery-ui/jquery-ui.min.css" />">
<link rel="stylesheet" href="<c:url value="/resources/plugins/revolution/css/settings.css" />">
<link rel="stylesheet" href="<c:url value="/resources/plugins/revolution/css/layers.css" />">
<link rel="stylesheet" href="<c:url value="/resources/plugins/revolution/css/navigation.css" />">
<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">

<title>상품 상세페이지</title>
</head>
<body>
<main class="ps-main">
  <div class="test">
	<div class="container">
	  <div class="row">
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 ">
			</div>
	  </div>
	</div>
  </div>
  <div class="ps-product--detail pt-60">
	<div class="ps-container">
	  <div class="row">
		<div class="col-lg-10 col-md-12 col-lg-offset-1">
		  <div class="ps-product__thumbnail">
			
			<div class="ps-product__image">
				<c:choose>
						<c:when test="${product.thumbnail == null}">
								<img src="<c:url value="/resources/images/basic2.jpg" />"  alt="">
						</c:when>
						<c:otherwise>
								<img src="/web/ajax/displayFile.do?fileName=${product.thumbnail}" alt="#" >
						</c:otherwise>
        		</c:choose>
			  
			</div>
		  </div>
		  
		  <div class="ps-product__info">
			
			<h2>${product.product_title}</h2>
			<p class="ps-product__category"><label>NICK_NAME : </label> ${nick_name.nick_name}</p>
			<p class="ps-product__category"><label>ID : </label> ${nick_name.id}</p>
			
			<p><p><p><p>

				<a href="adminProductDelete.mdo?num=${product.product_num}">* 현재 글 삭제하기 *</a>

			<div class="ps-product__block ps-product__size">	
			  <div class="form-group">
			  </div>	  
			</div>
			
			
		  </div>
		  <div class="clearfix"></div>
		  <div class="ps-product__content mt-50">
			<ul class="tab-list" role="tablist">
			  <li class="active"><a href="#tab_01" aria-controls="tab_01" role="tab" data-toggle="tab">Overview</a></li>
			  <li><a href="#tab_02" aria-controls="tab_02" role="tab" data-toggle="tab">Career</a></li>

			</ul>
		  </div>
		  <div class="tab-content mb-60">
			<div class="tab-pane active" role="tabpanel" id="tab_01">
			  <p>${product.product_info}</p>
			</div>
			<div class="tab-pane" role="tabpanel" id="tab_02">
		<p>${expert.career}</p>
		
			</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</main>
<!-- JS Library-->
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/jquery/dist/jquery.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/bootstrap/dist/js/bootstrap.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/jquery-bar-rating/dist/jquery.barrating.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/owl-carousel/owl.carousel.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/gmap3.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/imagesloaded.pkgd.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/isotope.pkgd.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/bootstrap-select/dist/js/bootstrap-select.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/jquery.matchHeight-min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/slick/slick/slick.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/elevatezoom/jquery.elevatezoom.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/Magnific-Popup/dist/jquery.magnific-popup.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/jquery-ui/jquery-ui.min.js" />"></script>
	<script type="text/javascript"
		src="http://ditu.google.cn/maps/api/js?key=AIzaSyAx39JFH5nhxze1ZydH-Kl8xXM3OK4fvcg&amp;region=GB"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/revolution/js/jquery.themepunch.tools.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/revolution/js/jquery.themepunch.revolution.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.video.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.slideanims.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.layeranimation.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.navigation.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.parallax.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.actions.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.kenburn.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/plugins/revolution/js/extensions/revolution.extension.migration.min.js" />"></script>
	<!-- Custom scripts-->
	<script type="text/javascript"
		src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>