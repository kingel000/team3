<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<script src="http://cdn.ckeditor.com/4.13.1/standard-all/ckeditor.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/thumbnail.js" />"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
   <style>
        .update_Product{width:690px; margin: 0 auto; border: solid 2px #2AC37D; padding: 35px;}
        .update_Product>form>h4{text-align: center; margin-bottom:15px;}
        .update_Product>form>p>input{width: 595px;}
        .update_Product>form>p>a{background-color: #dddddd; padding: 1px;}
    </style>
    <!-- Custom-->
<meta charset="UTF-8">

<title>상품수정</title>
<script type="text/javascript">
$(function(){
	CKEDITOR.replace('product_info',{
		width:'595px',
		height:'400px',
		filebrowserUploadUrl: '${pageContext.request.contextPath }/product/fileupload.do'
	});
});
function checkValue() {
	if (!document.product_value.category.value || document.product_value.category.value == "") {
		alert("카테고리를 선택해주세요.");
		document.product_value.category.focus();
		return false;
	}
	if (!document.product_value.product_title.value) {
		alert("제목을 입력 해주세요.");
		document.product_value.product_title.focus();
		return false;
	}
	if (!document.product_value.product_info.value) {
		alert("상세내용을 입력 해주세요.");
		document.product_value.product_info.focus();
		return false;
	}
}
</script>
</head>
<body>


<div>
      <div class="update_Product">
         <form action="/web/product/updateProduct.do" method="post" >
            <h4>상품 등록</h4>
            <p>
               <select name="category">
               <option value="${product.category}" selected hidden>${product.category}</option>
                  <option value="웹 개발">웹 개발</option>
                  <option value="모바일앱·웹">모바일앱·웹</option>
                  <option value="게임">게임</option>
                  <option value="응용프로그래밍">응용프로그래밍</option>
                  <option value="기타">기타</option>
               </select>
            </p>
            <p>
               <input id="insert_Product_title" type="text" name="product_title" value="${product.product_title}">
            </p>
            <p>
               <textarea name="product_info" rows="10" cols="80" >${product.product_info}</textarea>
               </p>
               
                <!-- 파일을 업로드할 영역 -->
				<div class="content">
				</div>
				<br>
	         	<input type="file" name="ajaxFile" id="ajaxFile"  style="display:none;"/>
	    		<input type="button" id="upload" value="PC에서 이미지 찾기"/><br>
				<!-- 업로드된 파일 목록 -->
				<div class="uploadedList"></div>
	          	<br><br>
	            <p >
               <input type="hidden" name="fileName" value="">
            
               <input type="hidden" name="product_num" value="${product.product_num }">
               <input type="hidden" name="expert_id" value="${product.expert_id}">
               <input type="submit" value="수정하기" />
            </p>
         </form>
      </div>
   </div>


</body>
</html>