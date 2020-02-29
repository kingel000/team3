<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 상품관리 </title>
	
	<style>
		thead>tr>th{background-color: #eee; text-align: center;}
		.title{color:#fff; text-align:center; background-color: #2ac37d;}
	</style>
</head>
<body>
	<div>
		<h3 class="title">상품 관리</h3>
			
			<table class="table table-striped" >
			  <thead>
			  	<tr>
			      <th>상품번호</th>
			      <th>카테고리</th>
			      <th>상품명</th>
			      <th>아이디</th>
			      <th>관리</th>
			   <tr>
			  </thead>
			  <tbody>
				  <c:forEach var="adminproduct" items="${adminproductList}">
				 	<tr>
				      <td>${adminproduct.product_num}</td>
				      <td>${adminproduct.category}</td>
				      <td>${adminproduct.product_title}</td>
				      <td>${adminproduct.expert_id}</td>
				      <td><a href="adminProductDelete.mdo?num=${adminproduct.product_num }">글 삭제</a></td>
				    <tr>
				   </c:forEach>
			  </tbody>
			</table>
		
	</div>
</body>
</html>