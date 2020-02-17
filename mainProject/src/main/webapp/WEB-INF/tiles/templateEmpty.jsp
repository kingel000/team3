<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>제목</title>
<style>
#header {
	width: 100%;
	height: 50px;
	text-align: center;
}

#main {
	float: left;
	width: 100%;
	margin-top: 20px;
	min-height: 600px;
	text-align: center;
}

#footer {
	width: 100%;
	height: 50px;
	text-align: center;
	clear: both;
}


</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>
	<div id="main">
		<tiles:insertAttribute name="body" />
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>