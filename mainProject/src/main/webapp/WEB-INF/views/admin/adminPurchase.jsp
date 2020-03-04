<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 거래내역 </title>
	
	<style>
		thead>tr>th{background-color: #eee; text-align: center;}
		.title{color:#fff; text-align:center; background-color: #2ac37d;}
		td{text-align: center;}
	</style>
</head>

<!-- Custom-->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<body>
	<div>
		<h3 class="title">거래 내역</h3>
			
			<table class="table table-striped" >
			  <thead>
			  	<tr>
			      <th>거래번호</th>
			      <th>상품번호</th>
			      <th>상품명</th>
			      <th>구매자</th>
			      <th>판매자</th>
			      <th>금액</th>
			      <th>상태</th>
			   <tr>
			  </thead>
			  <tbody>
				  <c:forEach var="adminPurchase" items="${purchaseList}" varStatus="status">
				 	<tr>
				      <td>${adminPurchase.purchase_num}</td>
				      <td>${adminPurchase.product_num}</td>
				      <td>${producttitleList.get(status.index)}</td>
				      <td>${adminPurchase.member_id}</td> 
				      <td>${expertidList.get(status.index)}</td>
				      <td>${adminPurchase.purchase_price}</td>
				      <td>${adminPurchase.purchase_state}</td>
				    <tr>
				   </c:forEach>
			  </tbody>
			</table>
			
			<form action="/web/admin//purchase.mdo" method="post">
              	 <select name="category">
              		 <option value="" selected disabled hidden>= 선택  =</option>
                 	 <option value="상품번호">상품번호</option>
                 	 <option value="구매자">구매자</option>
              	 </select>
		 		 <input type="text" name="findText" placeholder="검색어를 입력해주세요">
		 		 <input type="submit" value="검색" />
			</form>
	</div>
</body>
</html>