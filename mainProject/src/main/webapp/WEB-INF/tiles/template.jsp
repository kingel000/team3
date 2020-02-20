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

#left {
	float: left;
	margin-left: 5px;
	width: 15%;
}

#main {
	float: left;
	width: 70%;
	margin-top: 50px;
	margin-bottom: 50px;
	padding-right: 80px;
}

#footer {
	width: 100%;
	height: 50px;
	text-align: center;
	clear: both;
}

#left, #main {
	min-height: 600px;
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<div style="width: 100%; height: 100%;">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="left">
			<tiles:insertAttribute name="left" />
		</div>
		<div id="main">
			<tiles:insertAttribute name="body" />
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>
