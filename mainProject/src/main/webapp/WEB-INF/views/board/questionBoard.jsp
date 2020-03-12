<%@page import="main.project.web.question.vo.QuestionVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">
<meta charset="UTF-8">
<title>문의 사항 목록</title>

<style>
.question_Board>table {text-align: center;boarder: 1px solid #ddd}
thead>tr>th {background-color: #eee;text-align: center;}
</style>


</head>
<body>
	<div>
		<div class="question_Board">
			
			<table class="table table-striped" >
			  <thead>
			  	<tr>
			      <th>번호</th>
			      <th>제목</th>
			      <th>진행상태</th>
			      <th>날짜</th>
			      <th>작성자</th>
			   <tr>
			  </thead>
			  <tbody>
				  <c:forEach var="question" items="${questionList}">
				 	<tr>
				      <td>${question.rNum}</td>
				      <td><a href="questionView.do?num=${question.board_question_num }">${question.board_question_title}</a></td>
				      <td>${question.state}</td>
				      <td><fmt:formatDate type="date" value="${question.board_question_date}"/></td>
				      <td>${question.board_question_writer}</td>
				    <tr>
				   </c:forEach>
			  </tbody>
			</table>
			<div class="ps-pagination">
				<ul class="pagination">
					<c:choose>
						<c:when test="${prev}">
							<li>
								<a href="/web/board/question.do?num=${startPageNum - 1}">
									<i class="fa fa-angle-left"></i>
								</a>
							</li>
						</c:when>
					</c:choose>
					<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
						<li><c:choose>
								<c:when test="${select == num}">
									<li class="active">
									<a href="/web/board/question.do?num=${num}">${num}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="/web/board/question.do?num=${num}">${num}</a>
									</li>
								</c:otherwise>
							</c:choose></li>
					</c:forEach>
					<c:choose>
						<c:when test="${next}">
							<li>
								<a href="/web/board/question.do?num=${endPageNum + 1}">
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
			<c:choose>
	            <c:when test="${member.id == null}">
					  <a href="/web/member/login.do" class="btn btn-primary pull-right">글쓰기</a>
	            </c:when>
	            <c:otherwise>
	             	  <a href="/web/board/question_W.do" class="btn btn-primary pull-right">글쓰기</a>
	            </c:otherwise>
	         </c:choose>
		</div>
	</div>
</body>
</html>