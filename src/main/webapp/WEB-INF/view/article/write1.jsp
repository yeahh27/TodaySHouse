<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/view/common/layout_header.jsp"/>

<script type="text/javascript">
	$().ready(function() {
		$(".sendBtn").click(function() {
			$("#writeData").attr( {
				action: "/TodaysHouse/board/${boardId}/articleWrite",
	            method: "post",
	            enctype: "multipart/form-data"
			} ).submit()
		})
	})
</script>

	<h1>WRITE1</h1>
	<form:form id="writeData" modelAttribute="articleVO" enctype="multipart/form-data">
	<input type="hidden" name="token" value="${sessionScope._CSRF_TOKEN_}" />
	<div>
		<input type="hidden" name="boardId" id="boardId" value="${boardId}" />
	</div>
	<div>
		<input type="text" name="title" id="title" placeholder="TITLE" value="${articleVO.title}" />
	</div>
	<div>
		<textarea name="content" id="content" placeholder="CONTENT">${articleVO.content}</textarea>
	</div>
	<div>
		<input type="file" id="file" name="file" multiple="multiple" placeholder="Choose File"  />
	</div>
	<div>
		<input type="button" class="sendBtn" value="Send" />
	</div>
	</form:form>

<jsp:include page="/WEB-INF/view/common/layout_footer.jsp"/>