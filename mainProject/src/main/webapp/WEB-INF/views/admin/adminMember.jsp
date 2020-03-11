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
						<td><c:out value="${adminmember.nick_name }" /></td>
						<td><c:out value="${adminmember.rank }" /></td>
						<td><a href="adminmemberEdit.mdo?id=${adminmember.id}">
							회원 수정</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="adminMemberDelete.mdo?id=${adminmember.id}">회원 탈퇴</a>
						</td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="ps-pagination">
			<ul class="pagination">
				<c:choose>
					<c:when test="${prev}">
						<li>
							<a href="/web/admin/memberManager.mdo?num=${startPageNum - 1}">
								<i class="fa fa-angle-left"></i>
							</a>
						</li>
					</c:when>
					<c:otherwise>
						<li><div></div></li>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
					<li><c:choose>
							<c:when test="${select == num}">
								<li class="active">
								<a href="/web/admin/memberManager.mdo?num=${num}">${num}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/web/admin/memberManager.mdo?num=${num}">${num}</a>
								</li>
							</c:otherwise>
						</c:choose></li>
				</c:forEach>
				<c:choose>
					<c:when test="${next}">
						<li>
							<a href="/web/admin/memberManager.mdo?num=${endPageNum + 1}">
								<i class="fa fa-angle-right"></i>
							</a>
						</li>
					</c:when>
					<c:otherwise>
						<li><div></div></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<form action="/web/admin/memberfind.mdo" method="post">
                  <select name="category">
                     <option value="" selected disabled hidden>= 선택  =</option>
                     <option value="이메일">이메일</option>
                     <option value="닉네임">닉네임</option>
                  </select>
              <input type="text" name="findText" placeholder="검색어를 입력해주세요">
               <input type="submit" value="검색" />
         </form>
   </div>
</body>
</html>