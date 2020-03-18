<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<script type="text/javascript">
function checkCancel() {
	
	if(confirm("결제 취소를 진행하시겠습니까 ? ")){
		alert("결제 취소 진행 되었습니다");
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
		<h3 class="title">거래 내역</h3>
			
			<table class="table table-striped" >
			  <thead>
			  	<tr>
			      <th>주문번호</th>
			      <th>상품번호</th>
			      <th>상품명</th>
			      <th>구매자</th>
			      <th>판매자</th>
			      <th>금액</th>
			      <th>상태</th>
			      <th>관리</th>
			   <tr>
			  </thead>
			  <tbody>
				  <c:forEach var="adminPurchase" items="${purchaseList}" varStatus="status">
				 	<tr>
				      <td>${adminPurchase.purchase_num}</td>
				      <td>${adminPurchase.product_num}</td>
				      <td>${ProductitleList.get(status.index)}</td>
				      <td>${adminPurchase.member_id}</td> 
				      <td>${adminPurchase.expert_id}</td>
				      <td>${adminPurchase.purchase_price}</td>
				      <td>${adminPurchase.purchase_state}</td>
				      <td>
				      	<form action="/web/admin/purchaseCancel.mdo" method="post" onsubmit='return checkCancel();'>
				      		<input type="hidden" name="purchase_num" value="${adminPurchase.purchase_num}">
				      		<c:choose>
				      			<c:when test="${adminPurchase.purchase_state ne 'Cancel'}">
				      		<input type="submit" value="결제취소">
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
								<a href="/web/admin/adminpurchase.mdo?num=${startPageNum - 1}">
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
									<a href="/web/admin/adminpurchase.mdo?num=${num}">${num}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="/web/admin/adminpurchase.mdo?num=${num}">${num}</a>
									</li>
								</c:otherwise>
							</c:choose></li>
					</c:forEach>
					<c:choose>
						<c:when test="${next}">
							<li>
								<a href="/web/admin/adminpurchase.mdo?num=${endPageNum + 1}">
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
			<form action="/web/admin/purchase.mdo" method="post">
              	 <select name="category">
              		 <option value="" selected disabled hidden>= 선택  =</option>
                 	 <option value="상품번호">상품번호</option>
                 	 <option value="구매자">구매자</option>
              	 </select>
		 		 <input type="text" name="findText" placeholder="검색어를 입력해주세요">
		 		 <input type="submit" value="검색" />
		 		
			</form>
	</div>
</body>
</html>