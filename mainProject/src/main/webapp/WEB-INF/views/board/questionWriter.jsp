<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 글쓰기</title>

<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">

	<style>
  		.question_W1{width:690px; margin: 0 auto; border: solid 2px #2AC37D; padding: 35px;}
  		.question_W1>form>h4{text-align: center; margin-bottom:15px;}
  		.question_W1>form>p>input{width: 595px;}
  		.question_W1>form>p>a{background-color: #dddddd; padding: 1px;}
    </style>
    
    <script type="text/javascript">
	   function checkValue() {
	      if (!document.questionInfo.board_question_title.value) {
	         alert("제목을 입력해주세요");
	         document.questionInfo.board_question_title.focus();
	         return false;
	      }
	
	      if (!document.questionInfo.board_question_info.value) {
	         alert("내용을 입력해주세요");
	         document.questionInfo.board_question_info.focus();
	         return false;
	      }
	   }
	</script>
	
</head>
<body>
	<div>
		<div class="question_W1">
			<form action="/web/board/question.do" method="post" name="questionInfo" onsubmit="return checkValue()">
				<h4>문의 등록</h4>
				<p>
					<input id="board_question_title" type="text" name="board_question_title" placeholder="제목을 입력해주세요">
				</p>
				<p>
               <textarea name="board_question_info" rows="10" cols="80" placeholder="문의사항을 입력해주세요"></textarea>
            	</p>
				<p >
					<input type="submit" value="등록하기" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>
