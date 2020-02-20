<%@page import="main.project.web.question.vo.QuestionVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">
<meta charset="UTF-8">
<title>문의 사항</title>

   <style>
  		.question_Board>table {text-align: center; boarder: 1px solid #ddd}
    	thead>tr>th{background-color: #eee; text-align: center;}
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
			      <th>날짜</th>
			      <th>작성자</th>
			   <tr>
			  </thead>
			  <tbody>
			  
			  
			 	<tr>
			      <td>${question.board_question_num}</td>
			      <td>${question.board_question_title} </td>
			      <td>${question.board_question_date}</td>
			      <td>${question.board_question_writer}</td>
			    <tr>
			   
			  </tbody>
			</table>
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