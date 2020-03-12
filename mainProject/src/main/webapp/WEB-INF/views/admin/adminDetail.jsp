<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/adminDetail.css"/>" rel="stylesheet">
</head>
<body>
	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="p-header">Request</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-tasks fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">12</div>
									<div>Question!</div>
								</div>
							</div>
						</div>
						<div class="panel-footer" style=" cursor: pointer;" onclick="location.href='#';">
							<span class="pull-left">answer</span> <span
								class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-yellow">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-shopping-cart fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">124</div>
									<div>Point!</div>
								</div>
							</div>
						</div>

						<div class="panel-footer" style=" cursor: pointer;" onclick="location.href='#';">
							<span class="pull-left">validation</span> <span
								class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /#wrapper -->
	</div>
</body>
</html>