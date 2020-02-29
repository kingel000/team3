<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html id="wrap">
<head>
<meta charset="utf-8">

<title>Edit Page</title>
<script type="text/javascript">
var message = '${msg}';
if(message != ""){
	alert(message);
} 		

//필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
function checkValue() {
	if (!document.userInfo.nick_name.value) {
		alert("닉네임을 입력해주세요.");
		document.userInfo.nick_name.focus();
		return false;
	}
	if (!document.userInfo.password.value) {
		alert("현재 패스워드를 입력해주세요.");
		document.userInfo.password.focus();
		return false;
	}
	if (!document.userInfo.pwd.value) {
		alert("패스워드를 입력해주세요.");
		document.userInfo.pwd.focus();
		return false;
	}
	if (!document.userInfo.pwd2.value) {
		alert("패스워드확인을 입력해주세요.");
		document.userInfo.pwd2.focus();
		return false;
	}
	if (document.userInfo.pwd.value != document.userInfo.pwd2.value) {
		alert("패스워드 동일하게 입력해주세요..");
		document.userInfo.pwd.focus();
		return false;
	}
	if (document.userInfo.pwd.value == document.userInfo.password.value) {
		alert("현재 비밀번호와 변경할 비밀번호가 같습니다.");
		document.userInfo.password.focus();
		return false;
	}
}
</script>

<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">

</head>
<body>
	<div id="myPage_form">
		<div class="myPage_title">
			<h4>
				회원정보 수정
			</h4>
		</div>
		<div class="myPage">
			<form action="/web/admin/adminmemberEdit.mdo" method="post" name="userInfo" onsubmit="return checkValue()">
				<p>
					<label for="id">이메일</label>&nbsp;&nbsp;&nbsp; <label>${member.id}</label>
					<input type="hidden" name="id" value="${member.id }">
				</p>
				<p>
					<label for="nick_name">닉네임</label><br> <input id="nick_name"
						type="text" name="nick_name" value="${member.nick_name }">
				</p>
				<p>
					<label for="pwd">비밀번호 변경</label><br> 
					<input id="pwd" type="password" name="pwd" placeholder="비밀번호를 입력해주세요">
				</p>
				
				<p>
				 <label for="rank">등급</label><br><select name="rank">
               <option value="${member.rank}" selected disabled hidden>${member.rank}</option>
                  <option value="N">N</option>
                  <option value="E">E</option>

               </select>
				</p>
				<p>
					<label for="name">이름</label><br>
					<input type="text" name="name" value="${expert.name }">
				</p>
				
				<p>
				
					<label for="tel">전화번호</label><br>
					<input type="text" name="tel" value="${expert.tel}">
				</p>
				
				<p>
					<label for="career">경력</label><br>
					<textarea id="career" name="career" rows="8" cols="51" >${expert.career}</textarea>	 
				</p>
				<p>
				
					<label for="point">포인트</label><br>
					<input type="point" name="point" value="${expert.point}">
				</p>
	
				<p class="join_c">
					
					<input type="submit" value="정보변경완료" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>
