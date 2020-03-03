<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
<style>
	.Board>table {	text-align: left;	boarder: 1px solid #ddd;}
	thead>tr>th {	background-color: #eee;	text-align: center;}
	.title {	color: #fff;	text-align: center;	background-color: #2ac37d;}
	h2{text-align: center;}

</style>
</head>

<body>
	<div class="Board">
		<h3 class="title">공지사항 게시판</h3>
		번호/제목/작성자/작성일/조회

		<table class="table table-striped">
			<thead>
				<tr>
							
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				<tr>
			</thead>
		</table>

		<!-- ****************현재 상품 판매 목록 출력 -->
		<c:choose>
			<c:when test="${productList != null }">
				<c:set var="productList" value="${productList}" />
				<c:forEach var="product" items="${productList}">
					<tr>
						<td><c:out value="${product.product_num}" /></td>
						<td><c:out value="${product.product_title}" /></td>
						<td><c:out value="${product.product_date}" /></td>
						<td><c:out value="${product.product_date}" /></td>
						<td></td>
					<tr>
				</c:forEach>
			</c:when>
			
			<c:otherwise>
				<h2>등록된 공지가 없습니다.</h2>
			</c:otherwise>
		</c:choose>
		<div align="right">
		<button type="button" onclick="location.href='/web/admin/adminBoard_Notice_Update.mdo'" >글쓰기</button>
		<button type="button" onclick="location.gref='/web/admin/adminBoard_Notice_Delete.mdo'" >글삭제</button>
		<!-- 
		<button type="button" onclick="location.href='/web/admin/adminBoard_Notice_Update.do?num${board_notice.board_notice_num}'" >글쓰기</button>
		<button href="/web/admin/adminBoard_Notice_Update.do?num${board_notice.board_notice_num}">글쓰기</button>&nbsp;&nbsp;&nbsp;&nbsp;
		 -->
		</div>                  


	</div>

</body>
</html>