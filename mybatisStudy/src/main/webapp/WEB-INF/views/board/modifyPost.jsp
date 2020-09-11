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
					<button type="submit" data-oper="remove" class="btn btn-danger">글 삭제</button>
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
		
		//사용자의 정보 수정을 완료하고 이를 저장처리 요청함
		$('#btnModify').on("click", function(e) {
			e.preventDefault();
			postInfoForm.submit();
		});
		
		//수정을 하지 않고 목록으로 돌아갈때 입니다.
		$('#btnList').on("click", function(e) {
			e.preventDefault();

			postInfoForm.attr('action', "/board/list").attr("method", "get");
			
			//요청정보 최소화를 하면 성능에서 이득을 본다!
			var pageNoInput = $("input:hidden[name='pageNo']").clone();
			var amountInput = $("input:hidden[name='amount']").clone();
			var typeInput = $("input:hidden[name='type']").clone();
			var keywordInput = $("input:hidden[name='keyword']").clone();
			
			postInfoForm.empty();
			postInfoForm.append(pageNoInput);
			postInfoForm.append(amountInput);
			postInfoForm.append(typeInput);
			postInfoForm.append(keywordInput);
			
			
			  postInfoForm.submit();   
		});
		
		//삭제 처리합니다.
		$("button[data-oper='remove']").on("click",function(e){
			e.preventDefault();
			
			postInfoForm.attr('action', "/board/remove").attr("method", "post");
			
			postInfoForm.submit();
		});
	});
</script>