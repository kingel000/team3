<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>홈페이지 관리</title>
	<script src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>"></script>
	<!-- Custom-->
	<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">
	<script type="text/javascript"
		src="<c:url value="/resources/js/homeManager.js" />"></script>
	<style type="text/css">
		.title{color:#fff; text-align:center; background-color: #2ac37d;}
	</style>
</head>
<body class="body">
	<h3 class="title">홈페이지 관리</h3><br>
   <div id="rankUp_form">
      <div class="rankUp_Box1">
         <h4>
            	첫번째 main Slide 변경하기
         </h4>
      </div>
      <div class="rankUp_Box2">
         <form action="/web/admin/homePageManagement1.mdo" method="post" enctype="multipart/form-data">
            <p>
               <label for="name">*이미지1* </label> <br>
               	설정된 파일 : ${bannerVO.banner1_img}
               <input type="file" name="file" id="file"  style="display:none;">
    		   <input type="button" id="upload" value="PC에서 이미지 찾기"/>
    		   <input type="hidden" name="fileName" value="">
            </p>
            <p>
               <label>*배너 내용1*</label><br>
                <textarea name="b1_text1" rows="1" cols="51" >${bannerVO.banner1_text1}</textarea>
            	<textarea name="b1_text2" rows="1" cols="51" >${bannerVO.banner1_text2}</textarea>
            	<textarea name="b1_text3" rows="1" cols="51" >${bannerVO.banner1_text3}</textarea>
            	<textarea name="b1_text4" rows="2" cols="51" >${bannerVO.banner1_text4}</textarea>
            </p>
            <p class="join">
               <input type="submit" value="변경 완료하기" />
            </p>
         </form>
      </div>
   </div><br>
   
   
   <div id="rankUp_form">
      <div class="rankUp_Box1">
         <h4>
            	두번째 main Slide 변경하기
         </h4>
      </div>
      <div class="rankUp_Box2">
         <form action="/web/admin/homePageManagement2.mdo" method="post">
            <p>
               <label for="name">*이미지2* </label> <br>
               	설정된 파일 : ${bannerVO.banner2_img}
               <input type="file" name="file">
            </p>
            <p>
               <label>*배너 내용2*</label><br>
               <textarea name="b2_text1" rows="1" cols="51" >${bannerVO.banner2_text1}</textarea>
            	<textarea name="b2_text2" rows="1" cols="51" >${bannerVO.banner2_text2}</textarea>
            	<textarea name="b2_text3" rows="1" cols="51" >${bannerVO.banner2_text3}</textarea>
            	<textarea name="b2_text4" rows="1" cols="51" >${bannerVO.banner2_text4}</textarea>
            </p>
            <p class="join">
               <input type="submit" value="변경 완료하기" />
            </p>
         </form>
      </div>
   </div>

</body>
</html>