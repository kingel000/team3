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
			<div class="ps-product__preview">
			  <div class="ps-product__variants">
				<div class="item"><img src="images/shoe-detail/1.jpg" alt=""></div>
				<div class="item"><img src="images/shoe-detail/2.jpg" alt=""></div>
				<div class="item"><img src="images/shoe-detail/3.jpg" alt=""></div>
				<div class="item"><img src="images/shoe-detail/3.jpg" alt=""></div>
				<div class="item"><img src="images/shoe-detail/3.jpg" alt=""></div>
			  </div><a class="popup-youtube ps-product__video" href=""><img src="images/shoe-detail/1.jpg" alt=""><i class="fa fa-play"></i></a>
			</div>
			<div class="ps-product__image">

			  <div class="item"><img class="zoom" src="<c:url value="/resources/images/shoe-detail/1.jpg"/>"> </div>
			  <div class="item"><img class="zoom" src="images/shoe-detail/2.jpg" alt="" data-zoom-image="images/shoe-detail/2.jpg"></div>
			  <div class="item"><img class="zoom" src="images/shoe-detail/3.jpg" alt="" data-zoom-image="images/shoe-detail/3.jpg"></div>
			</div>
		  </div>
		  <div class="ps-product__thumbnail--mobile">
			<div class="ps-product__main-img"><img src="images/shoe-detail/1.jpg" alt=""></div>
			<div class="ps-product__preview owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="5000" data-owl-gap="20" data-owl-nav="true" data-owl-dots="false" data-owl-item="3" data-owl-item-xs="3" data-owl-item-sm="3" data-owl-item-md="3" data-owl-item-lg="3" data-owl-duration="1000" data-owl-mousedrag="on"><img src="images/shoe-detail/1.jpg" alt=""><img src="images/shoe-detail/2.jpg" alt=""><img src="images/shoe-detail/3.jpg" alt=""></div>
		  </div>
		  <div class="ps-product__info">
		
			<h2>${numProduct.product_title}</h2>
			<p class="ps-product__category"><a href="#">${nick_name.nick_name}</a></p>
			<h3 class="ps-product__price">Price</h3>
			
			<div class="ps-product__block ps-product__size">	
			  <div class="form-group">
			  </div>	  
			</div>
			
			<div class="ps-product__shopping">
			<form action="/web/chat/createChat.do" >
				<div class="ps-product__block ps-product__size">
			  		<div class="form-group">
			  			<input class="form-control" type="text" placeholder="가격 입력" name="price" value=""/>
			  		</div>
				</div>
				<input type="hidden" name="product_num" value="${numProduct.product_num }">
				<input type="hidden" name="product_title" value="${numProduct.product_title}">
				<input type="hidden" name="expert_id" value="${numProduct.expert_id }">
				<input type="hidden" name="expertName" value="${nick_name.nick_name }">
				
				<c:choose>
	           	 	<c:when test="${member.id == null}">
	           	 		<a href="/web/member/login.do" class="ps-btn mb-10">Cart</a>  
						<a href="/web/member/login.do" class="ps-btn mb-10">Expert Chat</a>
	           	 	</c:when>
	            	<c:otherwise>
	            		<a href="/web/purchase/addCart.do?num=${numProduct.product_num }" class="ps-btn mb-10">Cart</a>
	             	 	<input class="ps-btn mb-10" type="submit" value="Expert Chat"><i class="ps-icon-next"></i>
	           		 </c:otherwise>
	         	</c:choose>
			</form>
			
			</div>
		  </div>
		  <div class="clearfix"></div>
		  <div class="ps-product__content mt-50">
			<ul class="tab-list" role="tablist">
			  <li class="active"><a href="#tab_01" aria-controls="tab_01" role="tab" data-toggle="tab">Overview</a></li>
			  <li><a href="#tab_02" aria-controls="tab_02" role="tab" data-toggle="tab">Review</a></li>

			</ul>
		  </div>
		  <div class="tab-content mb-60">
			<div class="tab-pane active" role="tabpanel" id="tab_01">
			  <p>${numProduct.product_info}</p>
			</div>
			<div class="tab-pane" role="tabpanel" id="tab_02">
		
			  <div class="ps-review">
			
				<div class="ps-review__content">
				  <header>

					<p>By<a href=""> Buyer Name</a>- Buy Date</p>
				  </header>
				  <p>Review</p>
				</div>
			  </div>
			  
			</div>
			<div class="tab-pane" role="tabpanel" id="tab_03">
			  <p>Add your tag <span> *</span></p>
			  <form class="ps-product__tags" action="_action" method="post">
				<div class="form-group">
				  <input class="form-control" type="text" placeholder="">
				  <button class="ps-btn ps-btn--sm">Add Tags</button>
				</div>
			  </form>
			</div>
			<div class="tab-pane" role="tabpanel" id="tab_04">
			  <div class="form-group">
				<textarea class="form-control" rows="6" placeholder="Enter your addition here..."></textarea>
			  </div>
			  <div class="form-group">
				<button class="ps-btn" type="button">Submit</button>
			  </div>
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