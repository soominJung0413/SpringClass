<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">게시글 등록 페이지</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				<form id = "postForm" role="form" action="/board/register" method="post">
					<%@ include file="./includes/PostInfo.jsp"%>

					<button id = "btnInsertPost" type="submit" class="btn btn-default">Submit Button</button>
					<button type="reset" class="btn btn-default">Reset Button</button>
					
					<input type="hidden" name="boardId" value="-1">
					<input type="hidden" name="writer.loginId" value="a">
				</form>

			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
</div>

<%@ include file="../includes/footer.jsp"%>

<script type="text/javascript">
$(document).ready(function() {
	setOperMode("createMode");

	var postForm = $("#postForm");
	
	$("#btnInsertPost").on("click", function(e) {
		e.preventDefault();		//브라우저 기본 이벤트 처리를 맊아줍니다.

		postForm.submit();
	});
});
</script>
