<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
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
					<li><a href="#">입금&#47;결제 0</a></li>
					<li><a href="#">제작중 0</a></li>
					<li><a href="#">거래완료 0</a></li>
					<li><a href="#">구매확정 0</a></li>
					<li><a href="#">환불 0</a></li>
					<li><a href="#">환불완료 0</a></li>
				</ul>
			</header>

			<ul class="n-info-txt">
				<li>입금 확인 상태만 주문 취소 가능합니다. 제작 중엔 취소가 어려우며 판매자 문의 후 환불 처리 됩니다.</li>
				<li>구매 확정시 환불이 불가능합니다.</li>
			</ul>
			<!-- 
			<form name="#" id="#" method="get" action="/app/mypage/order_list_opt">
				<input type="hidden" name="state_type" value="" /> <input
					type="hidden" name="ord_state" value="" /> <input type="hidden"
					name="period" value="" /> <input type="hidden" name="dt_fr"
					value="" /> <input type="hidden" name="dt_to" value="" /> <input
					type="hidden" name="page" value="1" /> <input type="hidden">
				
				<div class="n-table-filter">
					<div class="n-select">
						<select style="visibility: hidden">
							<option value="" selected="selected">전체 상태</option>
							<option value="ord|1">주문접수</option>
							<option value="ord|10">입금확인</option>
							<option value="ord|20">배송 준비 중</option>
							<option value="ord|30">발송 완료</option>
							<option value="ord|40">배송 완료</option>
							<option value="ord|50">구매 확정</option>
							<option value="clm|-10">주문취소</option>
							<option value="clm|40">교환 요청</option>
							<option value="clm|50">교환 처리 중</option>
							<option value="clm|60">교환 완료</option>
							<option value="clm|41">환불 요청</option>
							<option value="clm|51">환불 처리 중</option>
							<option value="clm|61">환불 완료</option>
						</select>
					</div>
					
					<button type="button" class="n-btn btn-sm btn-accent"
						onclick="search();">조회</button>
				</div>
			</form>
			-->
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
				<c:when test="${purchaseList == null }">
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
								<th scope="col" colspan="2">주문 상태</th>
							</tr>
						</thead>
						<%-- <c:set var="productList" value="${productList}" />
						<c:forEach var="product" items="${productList}"> --%>
							<tbody>
								<tr>
									<td>
										<div class="n-prd-row">
											<a href="#" class="img-block"> <img
												src="<c:url value="/resources/images2/123.png"/>" alt="abc">
											</a>
											<ul class="info">


												<li class="brand"><a href="#">아이템</a></li>
												<li class="name"><a href="#">반응형 자바 웹 개발</a></li>
												<li class="option">100000~</li>
											</ul>
										</div>
									</td>
									<td>날짜 들어갈곳</td>
									<td><a href="#">구매코드 들어갈곳</a></td>
									<!-- test code -->
									<td>가격 들어갈곳<br> <span class="txt-default">수량..?</span></td>
									<td><div class="btn-set">
											<button type="button" class="n-btn btn-sm btn-default"
												onclick="">구매 확정</button>
										</div></td>
									<td>
										<button type="button" class="n-btn btn-sm btn-default"
											onclick="">구매후기</button>
									</td>
								</tr>
							</tbody>
						<%-- </c:forEach> --%>
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
					<dd>입금 확인 : 해당 브랜드로 주문서가 전달되어 발송 요청한 상태</dd>
					<dd>배송 준비 중 : 출고지에서 상품을 준비 중인 상태</dd>
					<dd>발송 완료 : 출고지에서 택배업체로 인계된 상태</dd>
					<dd>배송 완료 : 상품이 배송지에 도착한 상태</dd>
					<dd>구매 확정 : 상품 수령 후 구매를 결정한 상태</dd>
					<dd>주문 취소 : 가상계좌 주문 후 입금 전 취소 상태</dd>
					<dd>결제 오류 : 카드 한도 초과, 할부 개월 수 오류 등으로 결제되지 않은 상태</dd>
				</dl>
				<dl class="state2">
					<dt class="n-hidden">클레임 상태</dt>
					<dd>교환 요청 : 반품 확인 전 교환 접수 후 대기 상태(교환 주문건 생성)</dd>
					<dd>교환 처리 중 : 반품 확인 후 교환 준비 중 상태</dd>
					<dd>교환 완료 : 교환 주문의 발송 요청 상태</dd>
					<dd>교환 철회 : 교환 요청을 취소한 상태</dd>
					<dd>환불 요청 : 반품 확인 전 환불 접수 후 대기 상태</dd>
					<dd>환불 처리 중 : 반품 확인 후 환불 진행 중 상태</dd>
					<dd>환불 완료 : 환불 요청 승인 완료 상태 (결제대행사를 통해 1~3일 내 환불)</dd>
				</dl>
			</div>
		</section>
		<!-- //contents -->
	</div>
</body>
</html>
