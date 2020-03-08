<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
<style>
	.Board>table {	text-align: left;	boarder: 1px solid #ddd; text-align: center;}
	th {	background-color: #eee;	text-align: center;}
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
					<th colspan=3>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th colspan=2>관리</th>
					
					
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
						<td></td>			
						<td><a href="adminBoard_Notice_Detail.mdo?num=${board_notice.board_notice_num}">${board_notice.board_notice_title}</a></td>
						<td></td>			
						<td>관리자</td>
						<!-- 희망 : 당일이면 시간 / 지난날이면 날짜로 출력 -->
						<td><fmt:formatDate type="date" value="${board_notice.board_notice_date}"/></td>						
						<td><a href="adminBoard_Notice_Update.mdo?num=${board_notice.board_notice_num}">수정</a></td>															
						<td><a href="adminBoard_Notice_Delete.mdo?num=${board_notice.board_notice_num}">삭제</a></td>															
					<tr>			
				</c:forEach>
			</c:when>
			
			<c:otherwise>
			<tr>
				<th colspan=7 >등록된 공지가 없습니다.</th>
			</tr>
			
			</c:otherwise>	
			
		</c:choose>
		
		</tbody>
		</table>
		
		<div align="right">
		<button type="button" onclick="location.href='/web/admin/adminBoard_Notice_Insert.mdo'" >글쓰기</button>
		</div>                  


	</div>

</body>
</html>