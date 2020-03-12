<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 답변</title>
<style>
table {
    border-collapse: collapse;
    border-spacing: 0;
}
.tbl_qna table tbody th.t_top {
    padding: 22px 0 22px 25px;
}
.tbl_qna table tbody th.t_top, .tbl_qna table tbody td.t_top {
    color: #222;
    font-size: 14px;
    background: url(/images/egovframework/adt_new//bg_board_th.png) left bottom repeat-x;
}
tr {
    display: table-row;
    vertical-align: inherit;
    border-color: inherit;
}
.tbl_qna table tbody th {
    color: #222;
    font-size: 14px;
    font-weight: 600;
    padding: 14px 0 14px 25px;
}
.tbl_qna table tbody td {
    padding: 10px 0 10px 8px;
}
.tbl_qna table tbody th, .tbl_qna table tbody td {
    text-align: left;
    background-color: #f9f9f9;
    border-bottom: 1px solid #dfdfdf;
}
#contents_sub {
    position: relative;
    float: right;
    display: inline;
    width: 800px;
    padding: 11px 0 80px;
}
#contents_sub_n h3 {
    color: #000;
    font-size: 26px;
    font-weight: 600;
    margin: 91px 0 37px 0;
}
.tbl_qna {
    float: left;
    width: 100%;
    border-top: 3px solid #0c4ca4;
}
.tbl_qna table {
    width: 100%;
}
.tbl_qna table tbody td.msg {
    background-color: #fff;
    padding: 30px 0;
}
.tbl_qna dl {
    float: left;
    width: 790px;
    min-height: 190px;
    background: url(/images/egovframework/adt_new//bg_qna_gray.png) repeat;
}
.tbl_qna dl.qna_q {
    border: 2px solid #ed7764;
}
.tbl_qna dl.qna_a {
    border: 2px solid #66addb;
}
colgroup {
    display: table-column-group;
}
.tbl_qna dl dd {
    float: left;
    width: 690px;
    padding: 15px 20px 20px;
}
.tbl_qna table tbody td.last {
    border-bottom: 1px solid #ccc;
}
.tbl_qna dl.qna_q dt {
    background-color: #ed7764;
}
.tbl_qna dl.qna_a dt {
    background-color: #66addb;
}
.tbl_qna dl dt {
    float: left;
    clear: left;
    display: inline;
    width: 26px;
    height: 100%;
    text-align: center;
    color: #fff;
    font-weight: 500;
    padding: 17px 15px 19px 13px;
}
.tbl_qna dl dd textarea {
    background: #fff;
    min-height: 180px;
    border: 1px solid #dcdcdc;
    overflow: visible;
    line-height: 160%;
    resize: vertical;
}
dd {
    margin-inline-start: 0px;
}
dl {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
}
textarea {
    width: 100%;
}
</style>
<script type="text/javascript">
function goSubmit() {
    window.opener.name = "parentPage"; // 부모창의 이름 설정
    document.QnaManageForm.target = "parentPage"; // 타켓을 부모창으로 설정
    document.QnaManageForm.action = "/web/admin/adminBoardQuestionRejoinder.mdo";
    document.QnaManageForm.submit();
    alert("답변등록 되었습니다.");
    self.close();
}
function checkValue() {
	if (!document.QnaManageForm.board_question_info_r.value) {
		alert("답변내용이 없습니다.");
		document.QnaManageForm.board_question_info_r.focus();
		return false;
	}
}
function setUpdate(){
	document.QnaManageForm.board_question_info_r.readOnly = false	;
}
</script>
</head>
<body>
<!-- contents 영역 -->
	<div id="contents_sub">
		<h3>묻고 답하기</h3>
		<form name="QnaManageForm" method="post" onsubmit="return checkValue()">
			<input name="qaId" type="hidden" value="UUFfMDAwMDAwMDAwMDAwMTg0NTA=" />
			<input type="hidden" name="qnaProcessSttusCode" value="3" />
			<input type="hidden" name="frstRegisterId" value="USRCNFRM_00000000002" />
			<input type="hidden" name="menu" value="5"/>
			<input type="hidden" name="submenu" value="3"/>
		<div class="tbl_qna">
			<table summary="묻고 답하기 정보를 제공하는 표입니다.">
				<colgroup>
					<col style="width: 13%;"/>
					<col style="width: ;"/>
					<col style="width: 13%;"/>
					<col style="width: 14%;"/>
					<col style="width: 13%;"/>
					<col style="width: 14%;"/>
				</colgroup>
				<tbody>
					<tr>
						<th class="t_top">제목</th>
						<td colspan="5" class="t_top">${question.board_question_title}</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${question.board_question_writer}</td>
						<th>작성일</th>
						<td><fmt:formatDate type="date" value="${question.board_question_date}" pattern="yyyy.MM.dd HH:mm"/></td>
						<th>처리상태</th>
						<td colspan="3">${question.state}</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="5"></td>
					</tr>
					<tr>
						<td colspan="6" class="last msg">
							<!-- 질문 -->
								<dl class="qna_q">
									<dt>질문</dt>
									<dd>
										<textarea id="qestnCn" name="qestnCn" rows="10" cols="" class="white_bgbg" readonly>${question.board_question_info}</textarea>
									</dd>
								</dl>
								<!-- 질문 //-->
							<!-- 답변 -->
								<dl class="qna_a mt30">
									<dt>답변</dt>
									<c:choose>
										<c:when test="${question.board_question_info_r == null}">
											<dd>
												<textarea id="answerCn" name="board_question_info_r" rows="10" cols="" class="white_bgbg">${question.board_question_info_r}</textarea>									
											</dd>
										</c:when>
										<c:otherwise>
											<dd>
												<textarea id="answerCn" name="board_question_info_r" rows="10" cols="" class="white_bgbg" readonly>${question.board_question_info_r}</textarea>									
											</dd>
										</c:otherwise>
									</c:choose>
								</dl>
							<!-- 답변 //-->
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- button -->
		<div class="agree_check_all">
			<span style="float:right;">
				<input type="hidden" name="board_question_num" value="${question.board_question_num }">
				<input type="hidden" name="state" value="답변완료">
               	<input type="button" onclick="goSubmit()" value="답변등록" />
               	<c:choose>
					<c:when test="${question.board_question_info_r != null}">
						<a href="javascript:setUpdate()">답변수정</a>
					</c:when>
				</c:choose>
				<!-- <a href="" onclick="javascript:window.close()">닫 기</a> -->
			</span>
		</div>
		<!-- button //-->
	</form>
	</div>
	<!-- contents 영역 //-->
</body>
</html>