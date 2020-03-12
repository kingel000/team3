<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 게시판</title>
<style>
	.Board>table {	text-align: left;	boarder: 1px solid #ddd; text-align: center;}
	th {	background-color: #eee;	text-align: center;}
	.title {	color: #fff;	text-align: center;	background-color: #2ac37d;}
	h2{text-align: center;}

</style>
<script language="javascript">  
function openWin(num){  
    window.open("/web/admin/adminBoardQuestionRejoinder.mdo?num="+num, "REJOINDER", "width=750, height=630, location=no, status=no, titlebar=no, toolbar=no, menubar=no, scrollbars=no" );  
}
</script> 
</head>

<body>
	<div class="Board">
		<h3 class="title">문의사항 게시판</h3>
		<table class="table table-striped">
			<thead>
				<tr>							
					<th>번호</th>
					<th colspan="3">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>상태</th>
				<tr>
			</thead>
			<tbody>
			<!-- ****************현재 상품 판매 목록 출력 -->
			<c:choose>
				<c:when test="${adminBoardQuestionList != null }">
					<c:set var="adminBoardQuestionList" value="${adminBoardQuestionList}" />
					<c:forEach var="board_question" items="${adminBoardQuestionList}">
						<tr>						
							<td>${board_question.rNum}</td>
							<td colspan="3"><a href="#" onclick="openWin(${board_question.board_question_num})">${board_question.board_question_title}</a></td>
							<td>${board_question.board_question_writer}</td>
							<!-- 희망 : 당일이면 시간 / 지난날이면 날짜로 출력 -->
							<td><fmt:formatDate type="date" value="${board_question.board_question_date}"/></td>						
							<td>${board_question.state}</td>															
						<tr>			
					</c:forEach>
				</c:when>
				<c:otherwise>
				<tr>
					<th colspan=7 >등록된 문의가 없습니다.</th>
				</tr>
				</c:otherwise>	
			</c:choose>
			</tbody>
		</table>
		<div class="ps-pagination">
			<ul class="pagination">
				<c:choose>
					<c:when test="${prev}">
						<li>
							<a href="/web/admin/adminBoardQuestion.mdo?num=${startPageNum - 1}">
								<i class="fa fa-angle-left"></i>
							</a>
						</li>
					</c:when>
					<c:otherwise>
						<li><div></div></li>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
					<li><c:choose>
							<c:when test="${select == num}">
								<li class="active">
								<a href="/web/admin/adminBoardQuestion.mdo?num=${num}">${num}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/web/admin/adminBoardQuestion.mdo?num=${num}">${num}</a>
								</li>
							</c:otherwise>
						</c:choose></li>
				</c:forEach>
				<c:choose>
					<c:when test="${next}">
						<li>
							<a href="/web/admin/adminBoardQuestion.mdo?num=${endPageNum + 1}">
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

</body>
</html>