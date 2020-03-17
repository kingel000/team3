<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html id="wrap">
<head>
<meta charset="utf-8">

<title>Edit Page</title>

</head>
<body>
	<div id="myPage_form">
		<div class="myPage_title">
			<h4>
				회원정보 수정
			</h4>
		</div>
		<div class="myPage">
			<form action="/web/admin/adminmemberEdit.mdo" method="post">
				<p>
					<label for="id">이메일</label>&nbsp;&nbsp;&nbsp; <label>${member.email}</label>
					<input type="hidden" name="email" value="${member.email }">
				</p>
				<p>
					<label for="nick_name">닉네임</label><br> 
					<input id="nick_name" type="text" name="nick_name" value="${member.nick_name }">
				</p>
				<p>
					<label for="pwd">비밀번호 변경</label><br> 
					<input id="pwd" type="password" name="pwd" placeholder="비밀번호를 입력해주세요">
				</p>
				
				<p>
				 <label for="rank">등급</label><br><select name="rank" id="rank">
               <option value="${member.rank}" selected disabled hidden>${member.rank}</option>
                  <option value="N">N</option>
                  <option value="E">E</option>

               </select>
				</p>
				
			<!-- 	<p>
				
					<label for="point">포인트</label><br>
					<input type="text" name="point" value="${expert.point}">
				</p>
	 -->
				<p class="join_c">
			
					<input type="submit" value="정보변경완료" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>
