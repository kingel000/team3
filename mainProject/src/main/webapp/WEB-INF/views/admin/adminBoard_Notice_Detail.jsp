<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 내용보기</title>
<style>
	.Board>table {	boarder: 1px solid #ddd; text-align: center;}
	th {	background-color: #eee;	text-align: center;}
	.title {	color: #fff;	text-align: center;	background-color: #2ac37d;}
	h2{text-align: center;}

</style>
</head>
<body>	
	<div id="Notice_info">		
		<h3 class="title">공지사항 보기</h3>
		<table class="Notice_table_info" >
			<tr>				
				<th>제목</th>
				<td>${board_notice.board_notice_title}</td>
			</tr>
			<tr>
				<th>작성자</th><th></th>
				<td>관리자</td>
			</tr>
			<tr>
				<th>작성일자</th><th></th>
				<th>${board_notice.board_notice_date}</th>
			</tr>
			<tr>
				<th>내용</th><th></th>
				<td>${board_notice.board_notice_info}</td>
			</tr>
		</table>
						
					<input type="submit" value="정보변경완료" />

		</div>

</body>
</html>