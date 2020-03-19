<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">
<meta charset="UTF-8">
<title>공지 사항</title>

   <style>
  		.question_Board>table {text-align: center; boarder: 1px solid #ddd}
    	thead>tr>th{background-color: #eee; text-align: center;}
    	tr{text-align: center;}
    	
    </style>
   
</head>
<body>
	<div>
		<div class="notice_Board">
			<c:choose>
				<c:when test="${NoticeList != null }">
					<table class="table table-striped" >
					  <thead>
					  	<tr>
					      <th>번호</th>
					      <th>제목</th>
					      <th>작성자</th>
					      <th>날짜</th>
					   <tr>
					  </thead>
					  <c:forEach var="board_notice" items="${NoticeList}" varStatus="status">
					  <tbody>					  
							<tr>
								<td>${fn:split(board_notice.board_notice_num,'_')[1]}</td>
								<%-- <td>${board_notice.board_notice_num}</td> --%>
								<td><a href="/web/board/notice_Detail.do?num=${board_notice.board_notice_num}">${board_notice.board_notice_title}</a></td>
								<td>관리자</td>
								<!-- 희망 : 당일이면 시간 / 지난날이면 날짜로 출력 -->
								<td><fmt:formatDate type="date"	value="${board_notice.board_notice_date}" /></td>					
							<tr>
						</tbody>
					</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<h2>공지사항 없음_메인버전</h2>
				</c:otherwise>
			</c:choose>
			<div class="ps-pagination">
				<ul class="pagination">
					<c:choose>
						<c:when test="${prev}">
							<li>
								<a href="/web/board/notice.do?num=${startPageNum - 1}">
									<i class="fa fa-angle-left"></i>
								</a>
							</li>
						</c:when>
					</c:choose>
					<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
						<li><c:choose>
								<c:when test="${select == num}">
									<li class="active">
									<a href="/web/board/notice.do?num=${num}">${num}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="/web/board/notice.do?num=${num}">${num}</a>
									</li>
								</c:otherwise>
							</c:choose></li>
					</c:forEach>
					<c:choose>
						<c:when test="${next}">
							<li>
								<a href="/web/board/notice.do?num=${endPageNum + 1}">
									<i class="fa fa-angle-right"></i>
								</a>
							</li>
						</c:when>
						<c:otherwise>
							<li><div></div></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>