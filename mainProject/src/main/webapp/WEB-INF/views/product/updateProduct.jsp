<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
   <style>
        .update_Product{width:690px; margin: 0 auto; border: solid 2px #2AC37D; padding: 35px;}
        .update_Product>form>h4{text-align: center; margin-bottom:15px;}
        .update_Product>form>p>input{width: 595px;}
        .update_Product>form>p>a{background-color: #dddddd; padding: 1px;}
    </style>
<!-- Custom-->
<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>">
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>

<div>
      <div class="update_Product">
         <form action="/web/product/updateProduct.do" method="post" >
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
               <input id="update_Product_title" type="text" name="product_title" placeholder="제목을 입력해주세요">
            </p>
            <p>
               <textarea name="product_info" rows="10" cols="80" placeholder="상품 설명을 입력해주세요"></textarea>
               </p>
               <p>
                <input type="file" name = "product_info">
               </p>
            <p >
               <input type="submit" value="등록하기" />
            </p>
         </form>
      </div>
   </div>

</body>
</html>