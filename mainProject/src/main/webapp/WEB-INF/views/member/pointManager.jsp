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
.Board>table {text-align: center; boarder: 1px solid #ddd;}
thead>tr>th{background-color: #eee; text-align: center;}
.ps-product-action .ps-pagination {
    display: block;
    width: 100%;
    text-align: right;
}
.ps-pagination .pagination li {
      display: inline-block;
      margin-right: 5px;
      text-align: center; 
}
.ps-pagination .pagination li > a:before {
    width: 40px;
    height: 40px;
    background-color: #e4e4e4;
}
.ps-pagination .pagination li > a:after {
    width: 35px;
    height: 35px;
    background-color: #2AC37D;
    z-index: -1;
    visibility: hidden;
    opacity: 0;
}
.ps-pagination .pagination li > div{
    width: 40px;
    height: 40px;
    visibility: hidden;
}

.ps-pagination .pagination li.active {
    border: none;
}
.ps-pagination .pagination li.active a:after {
    visibility: visible;
    opacity: 1;
}
.fa-angle-left:before {
    content: "\f104";
}
.ps-pagination::after {
    clear: both;
    content: "";
    display: table;
}
.ps-products-wrap::after {
    clear: both;
    content: "";
    display: table;
}
</style>
   
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="Board">
<table class="table table-striped">
   <tr>
      <th style="text-align: center;">출금 신청일</th>
      <th style="text-align: center;">금액</th>
      <th style="text-align: center;">상태</th>
   <tr>
   	<c:forEach var="point" items="${pointList}">
   <tr>
      <td>${point.p_date }</td>
      <td>${point.p_point }</td>
      <td>${point.p_state }</td>
	</tr>
   </c:forEach>
</table>
</div>
</body>
</html>