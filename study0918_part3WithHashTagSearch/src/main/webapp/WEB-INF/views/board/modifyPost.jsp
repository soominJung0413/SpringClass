<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시글 수정</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">게시글 수정 페이지</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				<form id="postInfoForm" role="form" action="/board/modify" method="post">
					<%@ include file="./includes/PostInfo.jsp"%>

					<button type="submit" id='btnModify' class="btn btn-default">글 수정</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">글삭제</button>
					<button type="submit" id='btnList' class="btn btn-info">글 목록</button>

					${cri.makeHiddenHTMLTags()}
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
		// ./includes/PostInfo.jsp에 정의된 함수입니다.
		setOperMode("updateMode");

		var postInfoForm = $("#postInfoForm");
		
		//사용자의 정보 수정을 완료하고 이를 저장처리 요청합니다.
		$('#btnModify').on("click", function(e) {
			e.preventDefault();
			postInfoForm.submit();
		});
		
		//수정 취소하고 목록으로 돌아갑니다.
		$('#btnList').on("click", function(e) {
			e.preventDefault();
			postInfoForm.attr('action', "/board/list").attr("method", "get");
			
			//요청 정보 최소화를 통하여 성능 손해 없도록
			//input[name  이 사이에 공백을 넣으면(input   [name) 오작동. 
			pageNo = $("input[name='pageNo']").clone();
			keyword = $("input[name='keyword']").clone();
			postInfoForm.empty();
			postInfoForm.append(pageNo);
			postInfoForm.append(keyword);
			
			postInfoForm.submit();
		});
		
		//삭제처리합니다.
		$('button[data-oper="remove"]').on('click', function(e){
			e.preventDefault();
			postInfoForm.attr('action', "/board/remove");

			pageNo = $("input[name='pageNo']").clone();
			keyword = $("input[name='keyword']").clone();
			hierarchyId = $("input[name='hierarchyId']").clone();
			postInfoForm.empty();
			postInfoForm.append(pageNo);
			postInfoForm.append(keyword);
			postInfoForm.append(hierarchyId);
			
			postInfoForm.submit();
		});
	});
</script>