<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매 현황</title>
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
					<li><h1 class="tit">주문내역 조회</h1></li>
					<li><a href="/web/purchase/selectMemberOrder.do?status=Waiting">대기중: ${countList[0] }</a></li>
					<li><a href="/web/purchase/selectMemberOrder.do?status=Running">제작중: ${countList[1] }</a></li>
					<li><a href="/web/purchase/selectMemberOrder.do?status=Success">거래완료:${countList[2] }</a></li>
					<li><a href="/web/purchase/selectMemberOrder.do?status=Cancel">취소:${countList[3] }</a></li>
				</ul>
			</header>

			<ul class="n-info-txt">
				<li>입금 확인 상태만 주문 취소 가능합니다. 제작 중엔 취소가 어려우며 판매자 문의 후 환불 처리 됩니다.</li>
				<li>구매 확정시 환불이 불가능합니다.</li>
			</ul>
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
								<th scope="col">상품정보</th>
								<th scope="col">주문일자</th>
								<th scope="col">주문번호</th>
								<th scope="col">주문금액</th>
								<th scope="col"> 주문상태</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<c:forEach var="purchase" items="${purchaseList}" varStatus="status">
							<tbody>
								<tr>
									<td>
										<div class="n-prd-row">
											<ul class="info">
												<li class="name"><a href="/web/product/detailProduct.do?num=${productList.get(status.index).product_num}">${productList.get(status.index).product_title}</a></li>
											</ul>
										</div>
									</td>
									<td>
										<fmt:formatDate value="${purchase.purchase_date}" pattern="yyyy-MM-dd" /><br>
										<fmt:formatDate value="${purchase.purchase_date}" pattern="aa hh:mm:ss" />
									</td>
									<td>${purchase.purchase_num}</td>
									<!-- test code -->
									<td>${purchase.purchase_price } ￦</td>
									<td>${purchase.purchase_state}</td>
									<td>
										<div class="btn-set">
											<form action="/web/chat/memberChat.do" method="post">
												<input type="hidden" name ="product_id" value="${productList.get(status.index).product_num}">
												<input type="hidden" name="member_id"  value="${purchase.member_id }">
												<input class="n-btn btn-sm btn-default" type="submit" value="채팅문의">
											</form>					
											<c:if test="${ purchase.purchase_state eq 'Running' }">
												<form action="/web/purchase/successOrder.do" method="post">
													<input type="hidden" name="purchase_num" value="${purchase.purchase_num}">
													<input class="n-btn btn-sm btn-default" type="submit" value="구매 확정">
												</form>
											</c:if>
											
										</div>
									</td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
					<!-- test code -->
					<div class="n-paging">
						<button type="button" class="page is-active"
							onclick="return false;">1</button>
						<button type="button" class="page" onclick="click_paging('2')">2</button>
						<!-- <button type="button" class="page" onclick="click_paging('3')">3</button>
						<button type="button" class="page" onclick="click_paging('4')">4</button> -->
					</div>
				</c:when>
				<c:otherwise>
					<h2>구매 내역이 없습니다.</h2>
				</c:otherwise>
			</c:choose>

			<div class="my-order-state">
				<dl class="state1">
					<dt>주문 상태</dt>
					<dd>주문 접수 : 가상계좌 주문의 입금 전 상태</dd>
					<dd>입금 확인 : 해당 전문가에게 주문서가 전달되어 발송 요청한 상태</dd>
					<dd>제작 중 : 상품을 제작 중인 상태</dd>
					<dd>발송 완료 : 상품이 구매자에게 인계된 상태</dd>
					<dd>구매 확정 : 상품 수령 후 구매를 결정한 상태</dd>
					<dd>주문 취소 : 가상계좌 주문 후 입금 전 취소 상태</dd>
					<dd>결제 오류 : 카드 한도 초과, 할부 개월 수 오류 등으로 결제되지 않은 상태</dd>
				</dl>
				<dl class="state2">
					<dt class="n-hidden">클레임 상태</dt>
					<dd>수정 요청 : 상품의 유지보수를 위한 수정 접수 후 대기 상태(교환 주문건 생성)</dd>
					<dd>수정 처리 중 : 수정 처리 중 상태</dd>
					<dd>수정 완료 : 수정 주문의 완료 요청 상태</dd>
					<dd>수정 철회 : 수정 요청을 취소한 상태</dd>
					<dd>환불 요청 : 환불 접수 후 대기 상태</dd>
					<dd>환불 처리 중 : 환불 진행 중 상태</dd>
					<dd>환불 완료 : 환불 요청 승인 완료 상태 (결제대행사를 통해 1~3일 내 환불)</dd>
				</dl>
			</div>
		</section>
		<!-- //contents -->
	</div>
</body>
</html>