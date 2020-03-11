<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<script type="text/javascript">
function deleteCheck() {
	var product_num = ${adminproduct.product_num };
	if(confirm("게시글을 삭제하시겠습니까 ? ")){
		 location.href="adminProductDelete.mdo?num="+product_num;
	}
	else{
		alert("게시글 삭제를 취소합니다")
	}	
	
}
</script>
<head>
	<meta charset="UTF-8">
	<title>관리자 상품관리 </title>
	
	<style>
		thead>tr>th{background-color: #eee; text-align: center;}
		.title{color:#fff; text-align:center; background-color: #2ac37d;}
		td{text-align: center;}
		.ps-pagination .pagination li > div{
		    visibility: hidden;
		}
	</style>
</head>

<body>
	<div>
		<h3 class="title">상품 관리</h3>
			
			<table class="table table-striped" >
			  <thead>
			  	<tr>
			      <th>상품번호</th>
			      <th>카테고리</th>
			      <th>상품명</th>
			      <th>아이디</th>
			      <th>관리</th>
			   <tr>
			  </thead>
			  <tbody>
				  <c:forEach var="adminproduct" items="${adminproductList}">
				 	<tr>
				      <td>${adminproduct.product_num}</td>
				      <td>${adminproduct.category}</td>
				      <td><a href="adminDetailProduct.mdo?num=${adminproduct.product_num}">${adminproduct.product_title}</a></td>
				      <td>${adminproduct.expert_id}</td>
				      <td><a href="adminProductDelete.mdo?num=${adminproduct.product_num }">글 삭제</a></td>
				    <tr>
				   </c:forEach>
			  </tbody>
			</table>
			<div class="ps-pagination">
				<ul class="pagination">
					<c:choose>
						<c:when test="${prev}">
							<li>
								<a href="/web/admin/adminProduct.mdo?num=${startPageNum - 1}">
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
									<a href="/web/admin/adminProduct.mdo?num=${num}">${num}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="/web/admin/adminProduct.mdo?num=${num}">${num}</a>
									</li>
								</c:otherwise>
							</c:choose></li>
					</c:forEach>
					<c:choose>
						<c:when test="${next}">
							<li>
								<a href="/web/admin/adminProduct.mdo?num=${endPageNum + 1}">
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
			<form action="/web/admin/find.mdo" method="post">
              	 <select name="category">
              		 <option value="" selected disabled hidden>= 선택 =</option>
                 	 <option value="카테고리">카테고리</option>
                 	 <option value="아이디">아이디</option>
              	 </select>
		 		 <input type="text" name="findText" placeholder="검색어를 입력해주세요">
		 		 <input type="submit" value="검색" />
			</form>
	</div>
</body>
</html>