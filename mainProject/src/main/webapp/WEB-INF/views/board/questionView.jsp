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
    </style>
</head>
<body>
	<div>
		<div class="question_W1">
			<form action="/web/board/question.do" method="post">
				<p>
					<input id="board_question_title" type="text" name="board_question_title">
				</p>
				<p>
               <textarea name="board_question_info" rows="10" cols="80" ></textarea>
            	</p>
            	<p>
            		<a href="#">파일 선택</a> : file 없음
            	</p>
				<p >
					<a href="/web/board/deleteQuestion.do">글삭제</a>
					<a href="/web/board/updateQuestion.do">글수정</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>
