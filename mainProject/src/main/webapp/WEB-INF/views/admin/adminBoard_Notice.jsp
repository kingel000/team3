<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
<style>
	.Board>table {	text-align: left;	boarder: 1px solid #ddd; text-align: center;}
	thead>tr>th {	background-color: #eee;	text-align: center;}
	.title {	color: #fff;	text-align: center;	background-color: #2ac37d;}
	h2{text-align: center;}

</style>
</head>

<body>
	<div class="Board">
		<h3 class="title">공지사항 게시판</h3>
		<table class="table table-striped">
			<thead>
				<tr>							
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				<tr>
			</thead>
			
		<tbody>
		<!-- ****************현재 상품 판매 목록 출력 -->
		<c:choose>
			<c:when test="${adminBoardNoticeList != null }">
			
				<c:set var="adminBoardNoticeList" value="${adminBoardNoticeList}" />
				<c:forEach var="board_notice" items="${adminBoardNoticeList}">
					<tr>
						
						<td>${board_notice.board_notice_num}</td>						
						<td>${board_notice.board_notice_title}</td>
						<td>${board_notice.board_notice_info}</td>
						<td>${board_notice.board_notice_date}</td>
						
						<!-- 
						<td><c:out value="${board_notice.board_notice_num}" /></td>						
						<td><c:out value="${board_notice.board_notice_title}" /></td>
						<td><c:out value="${board_notice.board_notice_info}" /></td>
						<td><c:out value="${board_notice.board_notice_file}" /></td>
						<td><c:out value="${board_notice.board_notice_date}" /></td>
						 -->					
						
					<tr>			
				</c:forEach>
			</c:when>
			
			<c:otherwise>
				<h2>등록된 공지가 없습니다._adminBoard_Notice</h2>
			</c:otherwise>
			
		</c:choose>
		
		</tbody>
		</table>
		
		<div align="right">
		<button type="button" onclick="location.gref='/web/admin/adminBoard_Notice_Delete.mdo'" >삭제</button>
		<button type="button" onclick="location.href='/web/admin/adminBoard_Notice_Insert.mdo'" >글쓰기</button>
		<!-- 
		<button type="button" onclick="location.href='/web/admin/adminBoard_Notice_Update.do?num${board_notice.board_notice_num}'" >글쓰기</button>
		<button href="/web/admin/adminBoard_Notice_Update.do?num${board_notice.board_notice_num}">글쓰기</button>&nbsp;&nbsp;&nbsp;&nbsp;
		 -->
		</div>                  


	</div>

</body>
</html>