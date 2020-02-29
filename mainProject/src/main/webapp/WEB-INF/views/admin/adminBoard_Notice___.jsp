<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
<style>
	.Board>table {text-align: left; boarder: 1px solid #ddd;}
	thead>tr>th{background-color: #eee; text-align: center;}
	.title{color:#fff; text-align:center; background-color: #2ac37d;}
</style>
</head>

<body>
	<div class="Board">
		<h3 class="title">공지사항 게시판</h3>
	번호/제목/작성자/작성일/조회
	
	 <c:choose>
         <c:when test="${productList != null }">
            <table class="table table-striped">
               <thead>
                  <tr>
                     <th>번호</th>
                     <th>제목</th>
                     <th>작성자</th>
                     <th>작성일</th>
                  <tr>
               </thead>
               <c:set var="productList" value="${productList}"/>
                  <c:forEach var="product" items="${productList}">

                  <tr>
                     <td><c:out value="${product.product_num}" /></td>
                     <td><c:out value="${product.product_title}" /></td>
                     
                     <td><c:out value="${product.product_date}"/></td>
                     <td><a href="/web/product/updateProduct.do?num=${product.product_num}">게시물 수정</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
                        href="/web/product/deleteProduct.do?num=${product.product_num}">게시물 삭제</a></td>
                  <tr>
                  </c:forEach>
            </table>
         </c:when>
         <c:otherwise>
            <h2>등록한 상품이 없습니다.</h2>
         </c:otherwise>
      </c:choose>
	
	
	</div>
	
</body>
</html>