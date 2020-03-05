<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<td><a href="#">0</a></td>
					<td>제작 중</td>
					<td><a href="#">0</a></td>
					<td>거래 완료</td>
					<td><a href="#">0</a></td>
					<td>제작지연</td>
					<td><a href="#">0</a></td>
				</tr>
				<tr>
					<td>제작지연 안내주문</td>
					<td><a href="#">0</a></td>
					<td>구매자 취소요청</td>
					<td><a href="#">0</a></td>
					<td>상품 보수요청</td>
					<td><a href="#">0</a></td>
					<td>환불 완료</td>
					<td><a href="#">0</a></td>
				</tr>
			</table>
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
						<th scope="col">결제번호</th>
						<th scope="col">주문번호</th>
						<th scope="col">주문일</th>
						<th scope="col">상품명</th>
						<th scope="col">옵션</th>
						<th scope="col">금액</th>
						<th scope="col" colspan="2">주문 상태</th>
					</tr>
				</thead>
				<%-- <c:set var="productList" value="${productList}" />
						<c:forEach var="product" items="${productList}"> --%>
				<tbody>
					<tr>
						<td><a href="#">결제코드 들어갈곳</a></td>
						<td><a href="#">주문코드 들어갈곳</a></td>
						<td>날짜 들어갈곳</td>
						<td><a href="#">반응형 자바 웹 개발</a></td>
						<td>옵션</td>
						<td>가격 들어갈곳</td>
						<td><div class="btn-set">
								<button type="button" class="n-btn btn-sm btn-default"
									onclick="">채팅상담</button>
							</div></td>
						<td>
							<div class="btn-set btn-parents">
								<button type="button" class="n-btn btn-sm btn-accent"
									onclick="">주문상태확인</button>
								<!-- test code -->
								<div class="layer-util">
									<div class="flow-btn">
										<a href="">주문확인</a> 
										<a href="">금액조율 완료</a> 
										<a href="">제작 중</a> 
										<a href="">발송 완료</a>
										<a href="">구매자 응답대기</a> 
										<a href="">거래 완료</a>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</tbody>
				<%-- </c:forEach> --%>
			</table>
			<!-- test code -->
			<div class="n-paging">
				<button type="button" class="page is-active" onclick="return false;">1</button>
				<button type="button" class="page" onclick="click_paging('2')">2</button>
				<!-- <button type="button" class="page" onclick="click_paging('3')">3</button>
						<button type="button" class="page" onclick="click_paging('4')">4</button> -->
			</div>
		</section>
		<!-- //contents -->
	</div>
</body>
</html>
