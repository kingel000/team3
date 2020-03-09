<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<script src="http://cdn.ckeditor.com/4.13.1/standard-all/ckeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
   <style>
        .board_Notice_Update{width:690px; margin: 0 auto; border: solid 2px #2AC37D; padding: 35px;}
        .board_Notice_Update>form>h4{text-align: center; margin-bottom:15px;}
        .board_Notice_Update>form>p>input{width: 595px;}
        .board_Notice_Update>form>p>a{background-color: #dddddd; padding: 1px;}
    </style>
    <!-- Custom-->
<meta charset="UTF-8">

<title>공지사항 글수정</title>
<script type="text/javascript">

//파일추가 경로 똑같이 쓰기.
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


<div>
      <div class="board_Notice_Update">
         <form action="/web/admin/adminBoard_Notice_Update.mdo" name="board_notice_value" method="post" onsubmit="return checkValue()" >
            <h4>공지 수정</h4>

            <p>
               <input id="update_board_notice_title" type="text" name="board_notice_title" value="${board_notice.board_notice_title}">
            </p>
            <p>
               <textarea name="board_notice_info" rows="10" cols="80" >${board_notice.board_notice_info}</textarea>
            </p>          
            <p>
               <input type="file" name = "board_notice_info">
            </p>
            <p >
               <input type="hidden" name="board_notice_num" value="${board_notice.board_notice_num }">
               <input type="submit" value="수정하기" />
            </p>
         </form>
      </div>
   </div>


</body>
</html>
</html>