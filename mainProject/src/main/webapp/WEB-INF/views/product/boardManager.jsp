<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<!-- Custom-->
<meta charset="UTF-8">
<title>상품관리</title>

<style>
.Board>table {text-align: center; boarder: 1px solid #ddd;}
thead>tr>th{background-color: #eee; text-align: center;}
</style>

</head>
<body>
   <div class="Board">
      <c:choose>
			<c:when test="${productList != null }">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>상품코드</th>
							<th>상품명</th>
							<th>등록일</th>
							<th>관리</th>
						<tr>
					</thead>
					<c:set var="productList" value="${productList}" />
					<c:forEach var="product" items="${productList}">

						<tr>
							<td><c:out value="${product.product_num}" /></td>
							<td><c:out value="${product.product_title}" /></td>

							<td><c:out value="${product.product_date}" /></td>
							<td><a
								href="/web/product/updateProduct.do?num=${product.product_num}">게시물
									수정</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
								href="/web/product/deleteProduct.do?num=${product.product_num}">게시물
									삭제</a></td>
						<tr>
					</c:forEach>
				</table>
				<div>
					<c:if test="${prev}">
						<span><a href="/web/product/boardManager.do?num=${startPageNum - 1}"> < </a>
						</span>
					</c:if>

					<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
						<span> 
							<c:if test="${select != num}">
								<a href="/web/product/boardManager.do?num=${num}">${num}</a>
							</c:if> <c:if test="${select == num}">
								<b>${num}</b>
							</c:if>
						</span>
					</c:forEach>

					<c:if test="${next}">
						<span><a href="/web/product/boardManager.do?num=${endPageNum + 1}"> > </a>
						</span>
					</c:if>
				</div>
			</c:when>
			<c:otherwise>
				<h2>등록한 상품이 없습니다.</h2>
			</c:otherwise>
		</c:choose>
   </div>
</body>
</html>