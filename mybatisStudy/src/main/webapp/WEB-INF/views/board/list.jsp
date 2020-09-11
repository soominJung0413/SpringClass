<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>
	<p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">게시글 목록 페이지</h6>
			<!-- pagination 처리 시에는 검색 조건에 대한 변화가 없어야합니다. 이에 기억하고 있다가 재요청하는 스타일로 개발합니다. 
							검색 이후 검색 문자열 변경하고 페이지를 누른다면 검색 문자열 변경 이전으로 지속되어야 합니다. -->
						<form id='actionForm' action='/board/list' method='get'>
							<select name="type">
								<option value="" ${pageMaker.type == null ? 'selected' : ''} >---</option>
								<option value="T" ${pageMaker.type eq 'T' ? 'selected' : ''} >제목</option>
								<option value="C" ${pageMaker.type eq 'C' ? 'selected' : ''} >내용</option>
								<option value="TC" ${pageMaker.type eq 'TC' ? 'selected' : ''} >제목 또는 내용</option>
							</select>
							<input type="text" name="keyword" value="${pageMaker.keyword}"  />
							<button class="btn btn-default" type="submit">검색</button>	
							<input type="hidden" name='pageNo' value='${pageMaker.pageNo}'> 
							<input type="hidden" name='amount' value='${pageMaker.amount}'>
						</form>
			<button class='btn btn-xs pull-right' id="btnInsertPostPage" type='button'>글 쓰기</button>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>제목</th>
							<th>작성자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="post">
						<tr>
							<td><a class="jumpToDetail" href="${post.hierarchyId}">${post.title}</a></td>
							<td>${post.writer.name}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class='justify-content-center'> <!-- Page Jump 용 anchor -->
					<ul class='pagination'>
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous">
								<a href="${pageMaker.startPage - 1}">Previous</a>
							</li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<!-- active : 현재 선택된 것 지정. 더이상 클릭하지 않아도 됩니다. -->
							<li class="paginate_button ${pageMaker.pageNo == num ? "active":"" }">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li class="paginate_button next">
								<a href="${pageMaker.endPage + 1}">Next</a>
							</li>
						</c:if>
					</ul>
					
				</div> <!-- Page Jump 용 anchor -->
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->

<!-- 처리 완료 확인용 모달창 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
			</div>
			<div class="modal-body">처리가 완료되었습니다.</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default"
					data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div> <!-- /.modal-content -->
	</div> <!-- /.modal-dialog -->
</div><!-- /.modal 처리 완료 확인용 모달끝 -->



	
<%@include file="../includes/footer.jsp"%>

<script type="text/javascript">
$(document).ready(function() {
	var result = '<c:out value="${result}"/>';

	checkModal(result);

	

	function checkModal(result) {
		if (result === '' || history.state) {
			return;
		}
		$(".modal-body").html("게시글 " + result + " 번이 등록되었습니다.");

		$("#myModal").modal("show");
		
		// 상태(모달 창 띄울 필요 없음 상태) 하나 생성
		history.replaceState({}, null, null);
	}

	$("#btnInsertPostPage").on('click', function(e){
		self.location = "/board/register";
	});
	
	var actionForm = $("#actionForm");
	
	//페이지네이션 버튼 클릭
	$(".pagination a").on("click",function(e){
		e.preventDefault();
		var pageNo = actionForm.find("input[name='pageNo']");
		var jumpTarget = $(this).attr("href");
		pageNo.val(jumpTarget);
		actionForm.submit();
	});
	
	//글 상세 페이지 이동
	$(".jumpToDetail").on("click",function(e){
		e.preventDefault();
		var hierarchyId = $(this).attr("href");
		actionForm.append("<input type='hidden' name='hierarchyId' value='"+hierarchyId+"'>" );
		actionForm.attr("action","/board/findPostById");
		actionForm.submit();
	});
	
	//검색 
	$("#actionForm button").on("click",function(e){
		e.preventDefault();
		//선택 값이 없다면
		if(!actionForm.find("option:selected").val()){
			alert('검색종류를 선택하세요');
			return false;
		};
		if(!actionForm.find("input[name='keyword']").val()){
			alert('키워드를 입력하세요');
			return false;
		};
		//새로운 검색시 페이지 번호 1을 가지게 함
		actionForm.find("input:hidden[name=pageNo]").val("1");
		
		actionForm.submit();
	});
});
</script>







