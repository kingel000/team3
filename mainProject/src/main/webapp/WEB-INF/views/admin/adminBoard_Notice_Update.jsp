<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<script src="http://cdn.ckeditor.com/4.13.1/standard-all/ckeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
   <style>
        .update_Product{width:690px; margin: 0 auto; border: solid 2px #2AC37D; padding: 35px;}
        .update_Product>form>h4{text-align: center; margin-bottom:15px;}
        .update_Product>form>p>input{width: 595px;}
        .update_Product>form>p>a{background-color: #dddddd; padding: 1px;}
    </style>
    <!-- Custom-->
<meta charset="UTF-8">

<title>공지사항 글쓰기</title>
<script type="text/javascript">
$(function(){
	CKEDITOR.replace('board_notice_info',{
		width:'595px',
		height:'400px',
		filebrowserUploadUrl: '${pageContext.request.contextPath }/product/fileupload.do'
	});
});
function checkValue() {

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
         <form action="/web/admin/adminBoard_Notice_Update.mdo" method="post" >
            <h4>공지 등록</h4>

            <p>
               <input id="insert_board_notice_title" type="text" name="board_notice_title" >
            </p>
            <p>
               <textarea name="board_notice_info" rows="10" cols="80" ></textarea>
            </p>          
            <p >
               <input type="hidden" name="board_notice_num">
               <input type="hidden" name="expert_id" >
               <input type="submit" value="등록하기" />
            </p>
         </form>
      </div>
   </div>


</body>
</html>
</html>