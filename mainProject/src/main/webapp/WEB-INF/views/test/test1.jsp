<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/web/member/regiser.do" method="post">
            <p class="email_Bt">
               <label for="email">이메일</label><br> <input id="email"
                  type="email" name="id" placeholder="이메일을 입력해주세요"> <a
                  href="#"> <label>인증하기</label> <img
                  src="<c:url value="/resources/images2/email_icon.png" />" alt="">
               </a>
            </p>
            <p>
               <label for="name">닉네임</label><br> <input id="name" type="text"
                  name="nick_name" placeholder="닉네임을 입력해주세요">
            </p>
            <p>
               <label for="password">비밀번호</label><br> <input id="password"
                  type="password" name="pwd" placeholder="비밀번호를 입력해주세요">
            </p>
            <p class="join">
            	<input type="hidden" name="rank" value="N">
               <input type="submit" value="가입완료" />
            </p>
         </form>

</body>
