<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if IE 7]><html class="ie ie7"><![endif]-->
<!--[if IE 8]><html class="ie ie8"><![endif]-->
<!--[if IE 9]><html class="ie ie9"><![endif]-->
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
<title>Product Listing</title>
<!-- Fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Archivo+Narrow:300,400,700%7CMontserrat:300,400,500,600,700,800,900"
	rel="stylesheet">
<link rel="stylesheet"
	href="plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="plugins/ps-icon/style.css">
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
<script src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>"></script>

<!-- Custom-->
<link rel="stylesheet" href="css/style.css">

</head>

<body>
	<div class="header--sidebar"></div>


	<main class="ps-main">
		<div class="ps-products-wrap pt-80 pb-80">
			<div class="ps-products" data-mh="product-listing">
				<div class="ps-product-action"></div>
				<div class="ps-product__columns" id="list">
					<c:if test="${productList != null }">
						<c:forEach var="product" items="${productList}" varStatus="status">
							<div class="ps-product__column">
								<div class="ps-shoe__thumbnail">
								
								<c:choose>
									<c:when test="${product.thumbnail == null}">
										 <img src="<c:url value="/resources/images/basic2.jpg" />"  alt="" style="width: 280px; height: 180px;">
									</c:when>
									<c:otherwise>
										<img src="/web/ajax/displayFile.do?fileName=${product.thumbnail}" alt="#" style="width: 280px; height: 180px;">
									</c:otherwise>
        						 </c:choose>	
									
									<a class="ps-shoe__overlay" href="product-detail.html"></a>
								</div>
								<div class="ps-shoe__content">
									<div class="ps-shoe__variants"></div>
									<div class="ps-shoe__detail">
										<a class="ps-shoe__name" href="/web/product/detailProduct.do?num=${product.product_num}"><c:out value="${product.product_title }"/></a>
										<p class="ps-shoe__categories">
											<a href="#"><c:out value="${nick.get(status.count-1)}"/></a>
										</p>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
				<div class="ps-product-action">
					<div class="ps-pagination">
						<ul class="pagination">
						<c:if test="${prev}">
							<li>
								<a href="/web/product/mainProduct.do?category=${category}&num=${startPageNum - 1}">
									<i class="fa fa-angle-left"></i>
								</a>
							</li>
						</c:if>
						<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
							<c:choose>
								<c:when test="${select == num}">
									<li class="active">
										<a href="/web/product/mainProduct.do?category=${category}&num=${num}">${num}</a>
									</li>
								</c:when>
								<c:otherwise>
									<li>
										<a href="/web/product/mainProduct.do?category=${category}&num=${num}">${num}</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${next}">
							<li>
								<a href="/web/product/mainProduct.do?category=${category}&num=${endPageNum + 1}">
									<i class="fa fa-angle-right"></i>
								</a>
							</li>
						</c:if>
						</ul>
						
					</div>
				</div>
			</div>
			<div class="ps-sidebar" data-mh="product-listing">
				<aside class="ps-widget--sidebar ps-widget--category">
					<div class="ps-widget__header">
						<h3>정렬</h3>
					</div>
					<div class="ps-widget__content">
					 	
							<form action="/web/product/alignmentProduct.do" method="Post">
					
									<input type="hidden" name="category" value="${productList.get(0).category }">
							
 							 	<input type="radio" name="alignment" value="최신등록순" /> 최신등록순 <br>
 							 	<input type="radio" name="alignment" value="상품명순" /> 상품명순 <br><br>
 							 	<input type="submit" value="정렬하기">
							</form>
						
					</div>
				</aside>

				<div class="ps-sticky desktop"></div>

			</div>
		</div>




	</main>
	<!-- JS Library-->
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
