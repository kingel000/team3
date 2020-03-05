<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	  <link href="<c:url value="/resources/css/myCart.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="page">
	<div id="store_cart">
		<ul class="cart_head">
			<li class="cart_head_title">
				My Cart
			</li>
			<li class="cart_head_product">
				Product
			</li>
			<li class="cart_head_price">
				Price
			</li>
			<li>
				CheckOut
			</li>
		</ul>
		<c:if test="${cartList != null }">
			<c:forEach var="cart" items="${cartList}" varStatus="status">
				<ul class="cart_item">
					<li class="cart_img_col">
						<img src="https://i.imgur.com/3P8WF5D.jpg">
					</li>
					<li class="cart_product_col">
						<p><c:out value="${cart.product_title } " /></p>
						<span><strong>판매자: </strong><c:out value="${cart.expert_nick }" /></span>
					</li>
					<li class="cart_price_col">
						<h2><c:out value="${cart.price }" /> ￦</h2>
					</li>
					<li class="cart_del_col">
       			 		<a href="/web/purchase/deleteCart.do?num=${cart.num}"><img src="<c:url value="/resources/images2/delete.png"/>"></a>
					</li>
					<li>
						<form action="/web/purchase/checkout.do" method="post">
							<input type="hidden" name="num" value="${cart.num}">
							<input type="hidden" name="member_id" value="${cart.member_id }">
							<input type="hidden" name="product_num" value="${cart.product_num }">
							<input type="hidden" name="product_title" value="${cart.product_title }">
							<input type="hidden" name="price" value="${cart.price }">
							<input type="hidden" name="expert_nick" value="${cart.expert_nick }">
							<input class="checkout"  type="submit" value=CheckOut> 
						</form>
					</li>
				</ul>
				
			</c:forEach>
		</c:if>
	</div>
</div>
</body>
</html>