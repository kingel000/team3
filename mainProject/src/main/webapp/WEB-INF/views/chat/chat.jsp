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
<link href="<c:url value="/resources/css/c.css"/>" rel="stylesheet">
</head>
<script type="text/javascript">
	var socket = null;
	$(document).ready(function() {
		// 웹소켓을 지정한 url로 연결한다.
		console.log("===========================================")
		var ws = new WebSocket("ws://localhost:8080/web/echo.do");
		socket = ws;

		//서버로 메세지 보낼때
		ws.onopen = function() {
			console.log('Info: connection opened.');
			//보내기 버튼 눌렀을때
			$("#sendBtn").click(function() {
				ws.send($('#message').val());
				$('#data').append("<div class='incoming_msg'><div class='incoming_msg_img'>"+
						"<img src='<c:url value='/resources/images2/user-profile.png' />'alt='sunil'></div>"+
						"<div class='received_msg'><div class='received_withd_msg'><p>"+
						$('#message').val() + "</p><span class='time_date'> 11:01 AM | June 9</span></div></div></div>");
				$('#message').val('');
			});
			//엔터 눌렀을때
			$("#message").keydown(function(key) {
				if (key.keyCode == 13) {// 엔터
					ws.send($('#message').val());
					$('#data').append("<div class='incoming_msg'><div class='incoming_msg_img'>"+
							"<img src='<c:url value='/resources/images2/user-profile.png' />'alt='sunil'></div>"+
							"<div class='received_msg'><div class='received_withd_msg'><p>"+
							$('#message').val() + "</p><span class='time_date'> 11:01 AM | June 9</span></div></div></div>");
					$('#message').val('');
				}
			});
		};

		//서버로 부터 받은 메세지 보내주기
		ws.onmessage = function(event) {
			console.log("ReceiveMessage:", event.data + '\n');
			var data = event.data;
			$("#data").append("<div class='outgoing_msg'><div class='sent_msg'><p>"+
					data + "</p><span class='time_date'> 11:01 AM | June 9</span></div></div>");
		};

		//닫힐때
		ws.onclose = function(event) {
			console.log('Info: connection closed.');
			$("#data").append("Info: connection closed.<br/>");
		};

		//에러일때
		ws.onerror = function(err) {
			console.log('Error:', err);
			$("#data").append("Error:" + err + "<br/>");
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
							<h4>Recent</h4>
						</div>
						<div class="srch_bar">
							<div class="stylish-input-group">
								<input type="text" class="search-bar" placeholder="Search">
								<span class="input-group-addon">
									<button type="button">
										<i class="fa fa-search" aria-hidden="true"></i>
									</button>
								</span>
							</div>
						</div>
					</div>
					<!-- 채팅방 목록 -->
					<div class="inbox_chat">
						<div class="chat_list active_chat">
							<div class="chat_people">
								
							</div>
						</div>
						<div class="chat_list">
							<div class="chat_people">
								<div class="chat_img">
									<img src="<c:url value="/resources/images2/user-profile.png" />"
										alt="sunil">
								</div>
								<div class="chat_ib">
									<h5>
										Sunil Rajput <span class="chat_date">Dec 25</span>
									</h5>
									<p>Test, which is a new approach to have all solutions
										astrology under one roof.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 채팅 내용 -->
				<div class="mesgs">
					<div class="msg_history" id="data">

					</div>
					<div class="type_msg">
						<div class="input_msg_write">
							<input type="text" class="write_msg" id="message" placeholder="Type a message" />
							<button class="msg_send_btn" id="sendBtn" type="button">
								☜
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>