<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<script type="text/javascript">
function checkCancel() {
	
	if(confirm("입금 확인? ")){
		alert("입금 성공");
	}else{	
		return false;
	}
	
}

</script>
<head>
	<meta charset="UTF-8">
	<title>관리자 거래내역 </title>
	
	<style>
		thead>tr>th{background-color: #eee; text-align: center;}
		.title{color:#fff; text-align:center; background-color: #2ac37d;}
		td{text-align: center;}
	</style>
</head>

<body>
	<div>
		<h3 class="title">금액 관리</h3>
			
			<table class="table table-striped" >
			  <thead>
			  	<tr>
			      <th>번호</th>
			      <th>판매자 아이디</th>
			      <th>출금 신청일</th>
			      <th>출금금액</th>
			      <th>상태</th>
			      <th>관리</th>
			   <tr>
			  </thead>
			  <tbody>
				  <c:forEach var="adminPoint" items="${pointList}" varStatus="status">
				 	<tr>
				      <td>${adminPoint.p_num}</td>
				      <td>${adminPoint.expert_id}</td>
				      <td><fmt:formatDate value="${adminPoint.p_date}" pattern="yyyy-MM-dd aa hh:mm:ss" /></td>
				      <td>${adminPoint.p_point}</td> 
				      <td>${adminPoint.p_state}</td>
				      <td>
				      	<form action="/web/admin/pointCheck.mdo" method="post" onsubmit='return checkCancel();'>
				      		<input type="hidden" name="p_num" value="${adminPoint.p_num}">
				      		<c:choose>
				      			<c:when test="${adminPoint.p_state eq '대기중'}">
				      		<input type="submit" value="입금">
				      			</c:when>
				      		</c:choose>
				      	</form>
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
								<a href="/web/admin/adminpoint.mdo?num=${startPageNum - 1}">
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
									<a href="/web/admin/adminpoint.mdo?num=${num}">${num}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="/web/admin/adminpoint.mdo?num=${num}">${num}</a>
									</li>
								</c:otherwise>
							</c:choose></li>
					</c:forEach>
					<c:choose>
						<c:when test="${next}">
							<li>
								<a href="/web/admin/adminpoint.mdo?num=${endPageNum + 1}">
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
			<form action="/web/admin/point.mdo" method="post">
              	 <select name="category" style="width:80px;height:25px;">
              		 <option value="" selected disabled hidden>= 선택  =</option>
                 	 <option value="date">날짜</option>
                 	 <option value="expert">판매자</option>
              	 </select>
		 		 <input type="text" name="findText" placeholder="검색어를 입력해주세요" >
		 		 <input type="submit" value="검색" />
			</form>
	</div>
</body>
</html>