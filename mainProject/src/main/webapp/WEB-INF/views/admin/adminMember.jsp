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
.title{color:#fff; text-align:center; background-color: #2ac37d;}
td{text-align: center}
</style>

</head>
<body>
   <div class="Board">
     
	<h3 class="title">회원 관리</h3>
            <table class="table table-striped">
			<thead>
                  <tr>
                     <th>이메일</th>
                     <th>닉네임</th>
                     <th>등급</th>
                     <th>관리</th>  
   					<tr>
   			</thead>
   			<tbody>
              <c:forEach var="adminmember" items="${adminmemberList}">
                  <tr>
                     <td><c:out value="${adminmember.id }" /></td>
                     <td><c:out value="${adminmember.nick_name }"/></td>
            		 <td><c:out value="${adminmember.rank }"/></td>
                     <td><a href="adminmemberEdit.mdo?id=${adminmember.id}">회원 수정</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
                        href="adminMemberDelete.mdo?id=${adminmember.id}">회원 탈퇴</a></td>
                  <tr>
      			
      			</c:forEach>
      </tbody>
            </table>
 
   
      
   

   </div>
</body>
</html>