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
.ps-product-action .ps-pagination {
    display: block;
    width: 100%;
    text-align: right;
}
.ps-pagination .pagination li {
      display: inline-block;
      margin-right: 5px;
      text-align: center; 
}
.ps-pagination .pagination li > a:before {
    width: 40px;
    height: 40px;
    background-color: #e4e4e4;
}
.ps-pagination .pagination li > a:after {
    width: 35px;
    height: 35px;
    background-color: #2AC37D;
    z-index: -1;
    visibility: hidden;
    opacity: 0;
}
.ps-pagination .pagination li > div{
    width: 40px;
    height: 40px;
    visibility: hidden;
}

.ps-pagination .pagination li.active {
    border: none;
}
.ps-pagination .pagination li.active a:after {
    visibility: visible;
    opacity: 1;
}
.fa-angle-left:before {
    content: "\f104";
}
.ps-pagination::after {
    clear: both;
    content: "";
    display: table;
}
.ps-products-wrap::after {
    clear: both;
    content: "";
    display: table;
}
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
				<div class="ps-pagination">
					<ul class="pagination">
						<c:choose>
						<c:when test="${prev}">
							<li>
								<a href="/web/product/boardManager.do?num=${startPageNum - 1}"><i class="fa fa-angle-left"></i></a>
							</li>
						</c:when>
						<c:otherwise>
							<li><div></div></li>
						</c:otherwise>
						</c:choose>
						<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
							<li> 
								<c:choose>
								<c:when test="${select == num}">
									<li class="active">
										<a href="/web/product/boardManager.do?num=${num}">${num}</a>
									</li>
								</c:when>
								<c:otherwise>
									<li>
										<a href="/web/product/boardManager.do?num=${num}">${num}</a>
									</li>
								</c:otherwise>
							</c:choose>
							</li>
						</c:forEach>
	
						<c:choose>
							<c:when test="${next}">
								<li><a href="/web/product/boardManager.do?num=${endPageNum + 1}"><i class="fa fa-angle-right"></i></a>
								</li>
							</c:when>
						<c:otherwise>
							<li><div></div></li>
						</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</c:when>
			<c:otherwise>
				<h2>등록한 상품이 없습니다.</h2>
			</c:otherwise>
		</c:choose>
   </div>
</body>
</html>