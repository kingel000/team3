<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">

<title>상품 상세페이지</title>
<script type="text/javascript">
var msg = '${msg}';
if(msg == 'Expert'){
	alert("판매자와 채팅 후 Cart 등록 가능합니다!");
}
function addCart(){

	var f = document.content;
	if($("#price").val()==0 || $("#price").val()== null){
		alert("가격을 입력하세요!")
		return;
	}
	f.action="/web/purchase/addCart.do"
	f.method="post";
	f.submit();
}



</script>

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
					<c:when test="${numProduct.thumbnail == null}">
							<img src="<c:url value="/resources/images/basic2.jpg" />"  alt="">
					</c:when>
					<c:otherwise>
							<img src="/web/ajax/displayFile.do?fileName=${numProduct.thumbnail}" alt="#">
					</c:otherwise>
        		</c:choose>
			</div>
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
			<form action="/web/chat/createChat.do" name="content" >
				<div class="ps-product__block ps-product__size">
			  		<div class="form-group">
			  			<input class="form-control" title="판매자와 협의 후 가격을 입력해주세요 !" type="text" placeholder="가격 입력" id="price" name="price" value="" onClick="javascript:pricemsg();"/>
			  			
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
	            		<input type="button" value="Cart" onClick="javascript:addCart();" class="ps-btn mb-10"/>
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
			  <li><a href="#tab_02" aria-controls="tab_02" role="tab" data-toggle="tab">Career</a></li>

			</ul>
		  </div>
		  <div class="tab-content mb-60">
			<div class="tab-pane active" role="tabpanel" id="tab_01">
			  <p>${numProduct.product_info}</p>
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
	<!-- Custom scripts-->
	<script type="text/javascript"
		src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>