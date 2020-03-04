<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Basket</title>
  <script src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>"></script>
  <script src="<c:url value="/resources/js/myCart.js"/>"></script>
  <link href="<c:url value="/resources/css/myCart.css"/>" rel="stylesheet">
</head>

<body>
	<div class="container">

		<section id="cart"> 
			<article class="product">
				<header>
					<a class="remove">
						<img src="<c:url value="http://www.astudio.si/preview/blockedwp/wp-content/uploads/2012/08/1.jpg" />"  alt="">
						<h3>Remove product</h3>
					</a>
				</header>
				<div class="content">
					<h1>Lorem ipsum</h1>
				</div>

				<footer class="content">
					<span class="qt-minus">-</span>
					<span class="qt">2</span>
					<span class="qt-plus">+</span>

					<h2 class="full-price">
						1000₩
					</h2>

					<h2 class="price">
						2000₩
					</h2>
				</footer>
			</article>

			<article class="product">
				<header>
					<a class="remove">
						<img src="<c:url value="http://www.astudio.si/preview/blockedwp/wp-content/uploads/2012/08/3.jpg" />"  alt="">
						<h3>Remove product</h3>
					</a>
				</header>
				<div class="content">
					<h1>Lorem ipsum dolor</h1>
				</div>

				<footer class="content">
					
					<span class="qt-minus">-</span>
					<span class="qt">1</span>
					<span class="qt-plus">+</span>

					<h2 class="full-price">
						5000₩
					</h2>

					<h2 class="price">
						5000₩
					</h2>
				</footer>
			</article>

			<article class="product">
				<header>
					<a class="remove">
						<img src="<c:url value="http://www.astudio.si/preview/blockedwp/wp-content/uploads/2012/08/5.jpg" />"  alt="">
						<h3>Remove product</h3>
					</a>
				</header>
				<div class="content">
					<h1>Lorem ipsum dolor ipsdu</h1>
				</div>

				<footer class="content">
					
					<span class="qt-minus">-</span>
					<span class="qt">3</span>
					<span class="qt-plus">+</span>

					<h2 class="full-price">
						3000₩
					</h2>

					<h2 class="price">
						1000₩
					</h2>
				</footer>
			</article>

		</section>

	</div>

	<footer id="site-footer">
		<div class="container clearfix">

			<div class="left">
				<h2 class="subtotal">Subtotal: <span>0</span>₩</h2>
				<h3 class="tax">Taxes (5%): <span>0</span>₩</h3>
				<h3 class="shipping">Shipping: <span>0</span>₩</h3>
			</div>

			<div class="right">
				<h1 class="total">Total: <span>0</span>₩</h1>
				<a class="btn" href="/web/purchase/checkout.do">Checkout</a>
			</div>

		</div>
	</footer>
</body>
</html>