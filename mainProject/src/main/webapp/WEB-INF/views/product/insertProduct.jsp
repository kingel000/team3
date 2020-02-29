<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://cdn.ckeditor.com/4.13.1/standard-all/ckeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
   <style>
        .insert_Product{width:690px; margin: 0 auto; border: solid 2px #2AC37D; padding: 35px;}
        .insert_Product>form>h4{text-align: center; margin-bottom:15px;}
        .insert_Product>form>p>input{width: 595px;}
        .insert_Product>form>p>a{background-color: #dddddd; padding: 1px;}
    </style>
<!-- Custom-->
<meta charset="UTF-8">
<title>상품 등록</title>
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
}
</script>
</head>
<body>

<div>
      <div class="insert_Product">
         <form action="/web/product/insertProduct.do" method="post" name="product_value" onsubmit="return checkValue()" >
            <h4>상품 등록</h4>
            <p>
               <select name="category">
               <option value="" selected disabled hidden>=카테고리 선택=</option>
                  <option value="웹 개발">웹 개발</option>
                  <option value="모바일앱·웹">모바일앱·웹</option>
                  <option value="게임">게임</option>
                  <option value="응용프로그래밍">응용프로그래밍</option>
                  <option value="기타">기타</option>
               </select>
            </p>
            <p>
               <input id="insert_Product_title" type="text" name="product_title" placeholder="제목을 입력해주세요">
            </p>
            <p>
               <textarea name="product_info" rows="10" cols="80" placeholder="상품 설명을 입력해주세요"></textarea>
               </p>
            <p >
               <input type="submit" value="등록하기" />
            </p>
         </form>
      </div>
   </div>

</body>
</html>