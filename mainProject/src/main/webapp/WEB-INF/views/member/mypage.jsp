<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html id="wrap">
<head>
<meta charset="utf-8">
<link href="<c:url value="/resources/css/myPage.css"/>" rel="stylesheet">
<title>My Page</title>
<script type="text/javascript">

function checkPoint() {
	var check_num = /[0-9]/; 
	
	if(!document.pointInfo.point.value){
		alert("금액을 입력해주세요!");
		return false;
	}
	
	if(document.pointInfo.point.value > ${expert.point}){
		alert("현재 보유한 포인트를 초과하였습니다!");
		return false;
	}
	
	if(!check_num.test(document.pointInfo.point.value)){
		alert("숫자만 입력하세요!");
		return false;
	}
	
	alert("정상 출금 신청되었습니다 !");
	return true;	
}

</script>
<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">
</head>
<body>
<div id="page-wrapper">
<!-- /.row -->
    <div class="row">
      <div class="col-lg-3 col-md-6">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <div class="row">
              <div class="col-xs-3">
                <i class="fa fa-comments fa-5x"></i>
              </div>
              <div class="col-xs-9 text-right">
                <div class="huge">${mrCount}</div>
                <div>New Member Message!</div>
              </div>
            </div>
          </div>
            <div class="panel-footer" style=" cursor: pointer;" onclick="location.href='/web/chat/memberRoomList.do';">
              <span class="pull-left">MemberRoomList</span>
              <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
              <div class="clearfix"></div>
            </div>
        </div>
      </div>
      <c:if test="${member.rank eq 'E' }">
	      <div class="col-lg-3 col-md-6">
	        <div class="panel panel-green">
	          <div class="panel-heading">
	            <div class="row">
	              <div class="col-xs-3">
	                <i class="fa fa-tasks fa-5x"></i>
	              </div>
	              <div class="col-xs-9 text-right">
	                <div class="huge">${erCount }</div>
	                <div>New Expert Message!</div>
	              </div>
	            </div>
	          </div>
	            <div class="panel-footer" style=" cursor: pointer;" onclick="location.href='/web/chat/expertRoomList.do';">
	              <span class="pull-left">Expert Chat</span>
	              <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
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
	                <div class="huge">${wCount}</div>
	                <div>New Orders Check !</div>
	              </div>
	            </div>
	          </div>
	            <div class="panel-footer" style=" cursor: pointer;" onclick="location.href='/web/purchase/salesList.do';">
	              <span class="pull-left">Order Status</span>
	              <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	              <div class="clearfix"></div>
	            </div>
	        </div>
	      </div>
      </c:if>
      
    </div>
    <!-- /.row -->
</div>
<div class="editBoard">
<div id="email_form">
<div class="email_Box1">
			<form action="/web/member/point.do" method="post" name="pointInfo" onsubmit="return checkPoint()">
				<p class="email_Bt">
					<label>이메일 : ${member.id }</label><br><br>
					<label>닉네임 : ${member.nick_name }</label><br><br>
					<label>등급    :
					<c:choose>
					
						<c:when test="${member.rank eq 'E' }">판매자 </c:when>
						<c:when test="${member.rank eq 'N' }">일반회원</c:when>
					
					</c:choose>
					</label>
					<br><br>
					<c:if test="${member.rank eq 'E' }">
						<label>POINT : ${expert.point}</label><br><br>
						
						<input id="point" type="text" name="point" placeholder="출금 금액을 입력해주세요 [KRW]" ><br><br>	
	      				<input type="submit" value="출금 신청" >
					</c:if>

			
				</p>
			<br><br>
	      				
	   
   
      		</form>
</div>

</div>
</div>
</body>
</html>
