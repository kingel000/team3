<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">
<meta charset="UTF-8">
<title>상품관리</title>

   <style>
   .editBoard{
   width : 1000px;
   align-content : center;
   margin:0 auto
   }   
   table{
   width: 70%;
    border-top: 1px solid #444444;
    border-collapse: collapse;}
        th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;   
  }
    </style>
   
</head>
<body>
<div class="editBoard">
<table>
   <tr>
      <th>상품코드</th><th>상품명</th><th>등록일</th><th>관리</th>
   <tr>
   <tr>
      <td>A001</td><td>사이트 개발해드립니다 </td><td>2020-02-14</td><td><a href="#">게시물 수정</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">게시물 삭제</a></td>
   <tr>
</table>
</div>
</body>
</html>