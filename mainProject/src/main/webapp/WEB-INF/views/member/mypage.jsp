<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>


<html id="wrap">
<head>

<meta charset="utf-8">

<title>My Page</title>
<style>
   .editBoard{
   width : 1000px;
   
   margin:50px 0 0 250px;
   
   }   
   table{
   width: 70%;
    border-top: 1px solid #444444;
    border-collapse: collapse;}
        th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;   
  }
  
#email_form{width:550px;height:auto;padding:20px 10px;margin:0 0 20px 50px;text-align:center; border: solid 1px #e4e5ed;}
#email_form>p{margin:0 auto}
#email_num{margin: 0 atuo}
.email_Box1{width: 90%;margin: 0 auto; }
.email_Box1>p{align-items: center; text-align: center; width: auto;}
.email_Box1>form>p>input {width:382px;height:40px;border-radius: 4px; padding: 5px; margin-bottom:10px;border: solid 1px #e4e5ed;}
.email_Box2>form>input{width:382px;height:40px;border-radius: 4px; padding: 5px; margin-bottom:10px;border: solid 1px #e4e5ed;}
  
</style>

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
	
	alert("정상 출금 신청되었습니다 !")
	
}

</script>
   

<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">

</head>
<body>
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
