<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<!-- Custom-->
<meta charset="UTF-8">
<title>멤버 관리</title>

<style>
.Board>table {text-align: left; boarder: 1px solid #ddd;}


thead>tr>th{background-color: #eee; text-align: center;}
</style>

</head>
<body>
   <div class="Board">
     

            <table class="table table-striped">

                  <tr>
                     <th>이메일</th>
                       <th>닉네임</th>
                     <th>등급</th>
                     <th>관리</th>
                  <tr>
     
             
                  <tr>
                     <td><c:out value="gkdlch0812@naver.com" /></td>
                     
                     <td><c:out value="정민"/></td>
            		<td><c:out value="E"/></td>
                     <td><a href="/web/product/updateProduct.do?num=${product.product_num}">회원 수정</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
                        href="/web/product/deleteProduct.do?num=${product.product_num}">회원 탈퇴</a></td>
                  <tr>
     
            </table>
 
   
      
   

   </div>
</body>
</html>