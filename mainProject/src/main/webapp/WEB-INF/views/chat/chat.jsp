<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>"></script>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" id="bootstrap-css">
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<link href="<c:url value="/resources/css/chat.css"/>" rel="stylesheet">
</head>
<script type="text/javascript">
	var socket = null;
	var name = '${memberName}';
	var roomId = '${room.room_id}';
	$(document).ready(function() {
		// 웹소켓을 지정한 url로 연결한다.
		console.log("===========================================")
		var ws = new WebSocket("ws://192.168.219.102:8080/web/echo.do");
		socket = ws;

		//서버로 메세지 보낼때
		ws.onopen = function() {
			//보내기 버튼 눌렀을때
			$("#sendBtn").click(function() {
				ws.send(name +"!%/"+$('#message').val()+"!%/"+roomId);
				$('#output').append("<div class='outgoing_msg'><div class='sent_msg'><p>"+
						$('#message').val() + "</p><span class='time_date'>"+ name +"</span></div></div>");
				$('#message').val('');
			});
			//엔터 눌렀을때
			$("#message").keydown(function(key) {
				if (key.keyCode == 13) {// 엔터
					ws.send(name +"!%/"+$('#message').val()+"!%/"+roomId);
					$('#output').append("<div class='outgoing_msg'><div class='sent_msg'><p>"+
							$('#message').val() + "</p><span class='time_date'>"+ name +"</span></div></div><br>");
					$('#message').val('');
				}
			});
		};

		//서버로 부터 받은 메세지 보내주기
		ws.onmessage = function(message) {
			var jsonData = JSON.parse(message.data);
			switch(jsonData.protocol){
			case "100":
			case "200":
				$("#output").append("<div class='incoming_msg'>"+ 
						"<div class='received_msg'><div class='received_withd_msg'>"+jsonData.message+"<br>");
				break;
			case "300":
				$("#output").append("<div class='incoming_msg'><div class='incoming_msg_img'>" + 
						"<img src='<c:url value='/resources/images2/user-profile.png' />' ></div>" + 
						"<div class='received_msg'><div class='received_withd_msg'>"+jsonData.message+"<br>");
				break;
			}
			
			
			
		};

		//닫힐때
		ws.onclose = function(event) {
			console.log('Info: connection closed.');
			$("#output").append("Info: connection closed.<br/>");
		};

		//에러일때
		ws.onerror = function(err) {
			console.log('Error:', err);
			$("#output").append("Error:" + err + "<br/>");
		};
	});
</script>
<body>
	<div class="container">
		<div class="messaging">
			<div class="inbox_msg">
				<div class="inbox_people">
					<div class="headind_srch">
						<div class="recent_heading">
							<h4>채팅방 목록</h4>
						</div>						
					</div>
					<!-- 채팅방 목록 -->
					<div class="inbox_chat">
						
						<div class="chat_list" id="chatRoomList">
						<!-- 
							<div class="chat_people" style=" cursor: pointer;" onclick="location.href='/web/chat/moveRoom.do';">
								<div class="chat_img">
									<img src="<c:url value="/resources/images2/user-profile.png" />"alt="sunil">
									<h4>&nbsp; ${expertName}</h4>
								</div>
								<div class="chat_ib">
									<h5>${room.room_title}<span class="chat_date">${startDate}</span></h5>
								</div>
							</div>
						 -->
						 <c:if test="${roomList != null }">
						 	<c:forEach var="memberRoom" items="${roomList }" varStatus="status">
						 		<div class="chat_people" style=" cursor: pointer;" onclick="location.href='/web/chat/moveRoom.do?roomId=${memberRoom.room_id}';">
									<div class="chat_img">
										<img src="<c:url value="/resources/images2/user-profile.png" />"alt="sunil">
									</div>
									<div class="chat_ib">
										<h5><c:out value="${ memberRoom.room_title}" /><span class="chat_date"><c:out value="${ memberRoom.room_date}" /></span></h5>
									</div>
								</div>
						 	</c:forEach>
						 </c:if>
							<!-- 채팅방 추가 -->
							
						</div>
					</div>
				</div>
				<!-- 채팅 내용 -->
				<div class="mesgs">
					<c:choose>
						<c:when test="${room == null }">
						
						</c:when>
						<c:otherwise>
							<div class="msg_history" id="output">
							<!-- 채팅 내용 입력 -->
							</div>
							<div class="type_msg">
								<div class="input_msg_write">
									<input type="text" class="write_msg" id="message" placeholder="Type a message" />
									<button class="msg_send_btn" id="sendBtn" type="button">
										☜
									</button>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</body>
</html>