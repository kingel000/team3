<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 상세히</title>

<style>
table {
    margin: auto;
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
    float: center;
    display: inline;
    width: 800px;
    padding: 11px 0 80px;
}
h3 {
    color: #000;
    font-size: 26px;
    font-weight: 600;
    margin: 50px 0 20px 0;
}
.tbl_qna {
    width: 75%;
    margin: auto;
}
.tbl_qna table {
    width: 100%;
    border-top: 3px solid #2AC37D;
}
.tbl_qna table tbody td.msg {
    background-color: #fff;
    padding: 30px 130px 30px 50px;
}
.tbl_qna dl {
    float: left;
    width: 100%;
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
    width: 800px;
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
    width: 60px;
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
.tbl_qna table tbody th.t_top {
    padding: 22px 0 22px 25px;
}
.tbl_qna table tbody th.t_top, .tbl_qna table tbody td.t_top {
    color: #222;
    font-size: 14px;
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
</head>
<body class="contents">
	<!-- contents 영역 -->
	<div class="contents_sub">
		<form name="QnaManageForm" action="/uss/olh/qna/QnaDetailInqire.do" method="post">
		<div class="tbl_qna">
		<h3>묻고 답하기</h3>
		<!-- button -->
		<div class="agree_check_all">
		<span style="float:right;">
			<p>
				<c:choose>
					<c:when test="${member.id == question.board_question_writer}">
							<a href="/web/board/deleteQuestion.do?num=${question.board_question_num}">문의삭제</a>&nbsp;&nbsp;
					</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
			<a href="/web/board/question.do?num=1">목 록</a>
			</p>
			</span>
		</div>
		<!-- button //-->
			<table summary="묻고 답하기 정보를 제공하는 표입니다.">
				<tbody>
					<tr>
						<th class="t_top">제목</th>
						<td colspan="5" class="t_top">${question.board_question_title}</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${question.board_question_writer}</td>
						<th>작성일</th>
						<td>${question.board_question_date}</td>
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
										<textarea id="qestnCn" name="qestnCn" rows="10" cols="" class="white_bgbg">${question.board_question_info}</textarea>
									</dd>
								</dl>
								<!-- 질문 //-->
							<!-- 답변 -->
								<c:choose>
									<c:when test="${question.board_question_info_r != null}">
										<dl class="qna_a mt30">
											<dt>답변</dt>
											<dd>
												<textarea id="answerCn" name="answerCn" rows="10" cols="" class="white_bgbg" title="답변내용">${question.board_question_info_r}</textarea>									
											</dd>
										</dl>
									</c:when>
								</c:choose>
							<!-- 답변 //-->
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
	</div>
	<!-- contents 영역 //-->
	
</body>
</html>
