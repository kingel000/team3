<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.content {
	outline: 2px dashed #92b0b3;
	outline-offset: -10px;
	text-align: center;
	transition: all .15s ease-in-out;
	width: 500px;
	height: 500px;
	background-color: gray;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resources/plugins/jquery/dist/jquery.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/thumbnail.js" />"></script>
</head>
<body>
	<!-- 파일을 업로드할 영역 -->
	<div class="content"></div>
	<!-- 업로드된 파일 목록 -->
	<div class="uploadedList"></div>
</body>
</html>