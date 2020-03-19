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
	h2{	text-align: center;}

</style>
</head>
<body>	
	<div id="Notice_info">		
		<h3 class="title">공지사항 게시판</h3>
		
		<table class="table table-striped" style="text-align: center; border: 1px solid #ddd">
		<thead>
			<tr>
				<th colspan="3" style="background-color: #eee; text-align: center;">게시글 보기</th>
			</tr>
		</thead>
		<tbody>
			<tr>				
				<td style="width: 20%;">제목</td>
				<td colspan="2">${board_notice.board_notice_title}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td colspan="2">관리자</td>
			</tr>
			<tr>
				<td>작성일자</td>
				<td colspan="2"><fmt:formatDate type="date" value="${board_notice.board_notice_date}"/></td>
				
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="2" style="min-height: 200px; text-align: left;">${board_notice.board_notice_info}</td>
			</tr>
		</tbody>
		</table>			

		</div>
		
		<div >
		<button align="left"><a href="/web/board/notice.do?num=1">목록</a></button>					
		</div>

</body>
</html>