<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://cdn.ckeditor.com/4.13.1/standard-all/ckeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
   <style>
        .insert_BoardNotice{width:690px; margin: 0 auto; border: solid 2px #2AC37D; padding: 35px;}
        .insert_BoardNotice>form>h4{text-align: center; margin-bottom:15px;}
        .insert_BoardNotice>form>p>input{width: 595px;}
    </style>
<!-- Custom-->
<meta charset="UTF-8">
<title>공지사항 글쓰기</title>
<script type="text/javascript">

//파일추가
$(function(){
	CKEDITOR.replace('board_notice_info',{
		width:'595px',
		height:'400px',
		filebrowserUploadUrl: '${pageContext.request.contextPath }/product/fileupload.do'
	});
});

function checkValue() {

	if (!document.board_notice_value.board_notice_title.value) {
		alert("제목을 입력 해주세요.");
		document.board_notice_value.board_notice_title.focus();
		return false;
	}

}
</script>
</head>
<body>

<div>	<!-- class 맨위에 style있음 -->
      <div class="insert_BoardNotice">
         <form action="/web/admin/adminBoard_Notice_Insert.mdo" method="post" name="board_notice_value" onsubmit="return checkValue()" >
            <h4>공지 등록</h4>
            
            <p>
               <input id="insert_Board_notice_title" type="text" name="board_notice_title" placeholder="제목을 입력해주세요">
            </p>
            <p>
               <textarea name="board_notice_info"  placeholder="상품 설명을 입력해주세요"></textarea>
            </p>
            <p >
               <input type="submit" value="등록하기" />
            </p>
         </form>
      </div>
   </div>

</body>
</html>