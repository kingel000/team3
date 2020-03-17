<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/roomList.css"/>"
	rel="stylesheet" type="text/css">
</head>
<body>
<table>
  <thead>
    <tr>
      <th>방번호</th>
      <th>방생성 날짜</th>
      <th>상품명</th>
      <th>판매자</th>
      <th>안 읽은 메세지 숫</th>
      <th>방이동</th>
    </tr>
  </thead>
  <tbody>
  	<c:if test="${roomList != null }">
		<c:forEach var="room" items="${roomList}" varStatus="status">
		   <tr>
		     <td data-column="First Name">${room.room_id }</td>
		     <td data-column="Last Name"><fmt:formatDate value="${ room.room_date}" pattern="yyyy-MM-dd aa hh:mm:ss" /></td>
		     <td data-column="Job Title">${room.room_title }</td>
		     <td data-column="Twitter">${room.expert_id}</td>
		     <td data-column="Twitter">${receiveCountList.get(status.index)} 개</td>
		     <td data-column="Twitter">
		     	<form action="/web/chat/memberChat.do" method="post">
					<input type="hidden" name ="product_id" value="${room.product_id}">
					<input type="hidden" name="member_id"  value="${room.member_id}">
					<input type="submit" value=MoveRoom> 
				</form>
		     </td>
		   </tr>
		 </c:forEach>
	</c:if>
  </tbody>
</table>
</body>
</html>