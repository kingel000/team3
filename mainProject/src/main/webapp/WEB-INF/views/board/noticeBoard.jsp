<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			      <td>1</td>
			      <td>공지합니다. </td>
			      <td>2020-02-14</td>
			      <td>관리자</td>
			    <tr>
			  </tbody>
			</table>
		</div>
	</div>
</body>
</html>