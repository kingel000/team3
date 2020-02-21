<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 상세히</title>

<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">

	<style>
  		.question_W1{width:690px; margin: 0 auto; border: solid 2px #2AC37D; padding: 35px;}
  		.question_W1>form>h4{text-align: center; margin-bottom:15px;}
  		.question_W1>form>p>input{width: 595px;}
  		.question_W1>form>p>a{background-color: #dddddd; padding: 1px;}
  		.p_line{width: 610px;height: 1px; background-color: #2AC37D;}
  		.writer{margin-left: 460px;}
    </style>
</head>
<body>
	<div>
		<div class="question_W1">
			<form action="/web/board/question.do" method="post">
				<p>
					<label>제목 : ${question.board_question_title}</label>
				</p>
					<p class="p_line"></p>
               		<label>${question.board_question_info}</label>
            	</p>
            	<p>
            		<p class="p_line"></p>
            		<label class="writer">작성자</label>
            		<label class="writer">${question.board_question_writer}</label>
            	</p>
            	
	            <c:choose>
		            <c:when test="${member.id == question.board_question_writer}">
						 <p >
							<a href="/web/board/deleteQuestion.do?num=${question.board_question_num }">글삭제</a>
						</p>
		            </c:when>
		            <c:otherwise></c:otherwise>
	       		</c:choose>

			</form>
		</div>
	</div>
</body>
</html>
