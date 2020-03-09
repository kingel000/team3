<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 현황</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/orderList.css"/>">
</head>
<body>
	<!-- mypage area -->
	<div class="mypage-area">
		<!-- contents -->
		<section class="mypage-cont">
			<header class="n-section-title">
				<ul class="state">
					<li><h1 class="tit">판매내역 조회</h1></li>
				</ul>
			</header>

			<table class="sales_table">
				<tr>
					<td>주문 요청</td>
					<td><a href="/web/purchase/selectExpertOrder.do?status=Waiting">${countList[0] }</a></td>
					<td>제작 중</td>
					<td><a href="/web/purchase/selectExpertOrder.do?status=Running">${countList[1] }</a></td>
					<td>거래 완료</td>
					<td><a href="/web/purchase/selectExpertOrder.do?status=Success">${countList[2] }</a></td>
					<td>취소</td>
					<td><a href="/web/purchase/selectExpertOrder.do?status=Cancel">${countList[3] }</a></td>
				</tr>
			</table>
			<form name="f1" id="f1" method="get"
				action="/app/mypage/order_list_opt">
				<input type="hidden" name="state_type" value="" /> <input
					type="hidden" name="ord_state" value="" /> <input type="hidden"
					name="period" value="" /> <input type="hidden" name="dt_fr"
					value="" /> <input type="hidden" name="dt_to" value="" /> <input
					type="hidden" name="page" value="1" /> <input type="hidden"
					name="version" value="v2" />
				<!-- test code -->
				<!-- //filter -->
			</form>
			<c:choose>
				<c:when test="${purchaseList != null }">
				<table class="n-table table-col">
					<colgroup>
						<col style="width: *">
						<col style="width: 14.2%">
						<col style="width: 14.2%">
						<col style="width: 14.2%">
						<col style="width: 10.2%">
						<col style="width: 11%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">주문번호</th>
							<th scope="col">주문일</th>
							<th scope="col">주문상품번호</th>
							<th scope="col">주문상품명</th>
							<th scope="col">주문상태</th>
							<th scope="col">주문금액</th>
							<th scope="col" colspan="2"></th>
						</tr>
					</thead>
					
					<c:forEach var="purchase" items="${purchaseList}" varStatus="status">
						<tbody>
							<tr>
								<td>${purchase.purchase_num}</td>
								<td>
									<fmt:formatDate value="${purchase.purchase_date}" pattern="yyyy-MM-dd" /><br>
									<fmt:formatDate value="${purchase.purchase_date}" pattern="aa hh:mm:ss" />
								</td>
								<td>${productList.get(status.index).product_num}</td>
								<td><a href="/web/product/detailProduct.do?num=${productList.get(status.index).product_num}">${productList.get(status.index).product_title}</a></td>
								<td>${purchase.purchase_state}</td>
								<td>${purchase.purchase_price } ￦</td>
								<c:choose>
									<c:when test="${ purchase.purchase_state eq 'Waiting' }">
										<td>
											<div class="btn-set">
												<form action="/web/purchase/workStart.do" method="post">
													<input type="hidden" name="purchase_num" value="${purchase.purchase_num}" >
													<input class="n-btn btn-sm btn-default" type="submit" value="수락">
												</form>
											</div>
										</td>
										<td>
											<div class="btn-set">
												<form action="/web/purchase/paymentCancel.do" method="post">
													<input type="hidden" name="purchase_num" value="${purchase.purchase_num}" >
													<input class="n-btn btn-sm btn-default" type="submit" value="거부">
												</form>
											</div>
										</td>
									</c:when>
									<c:otherwise>
										<c:if test="${ purchase.purchase_state eq 'Running' }">
											<td>
												<div class="btn-set">
													<form action="/web/chat/expertChat.do" method="post">
														<input type="hidden" name ="product_id" value="${productList.get(status.index).product_num}">
														<input type="hidden" name="member_id"  value="${purchase.member_id }">
														<input class="n-btn btn-sm btn-default" type="submit" value="채팅상담">
													</form>	
												</div>							
											</td>
										</c:if>															
									</c:otherwise>
								</c:choose>
								
								
							</tr>
						</tbody>
					</c:forEach>
				</table>
			<!-- test code -->
				<div class="n-paging">
					<button type="button" class="page is-active" onclick="return false;">1</button>
					<button type="button" class="page" onclick="click_paging('2')">2</button>
				<!-- <button type="button" class="page" onclick="click_paging('3')">3</button>
						<button type="button" class="page" onclick="click_paging('4')">4</button> -->
				</div>
			</c:when>
			<c:otherwise>
					<h2>구매 내역이 없습니다.</h2>
			</c:otherwise>
		</c:choose>
		</section>
		<!-- //contents -->
	</div>
</body>
</html>
