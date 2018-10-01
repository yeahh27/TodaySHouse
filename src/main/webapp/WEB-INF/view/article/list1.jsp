<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.box {
	display: inline-block;
	padding-left: 15px;
	text-align: center;
}

.header {
	font-weight: bold;
	text-align: center;
}

.number {
	width: 150px;
}

.subject {
	width: 340px;
}

.writer {
	width: 170px;
}

.create-date {
	width: 170px;
}

a:hover {
    color: #00e6ac;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	<h1>LIST1</h1>
	
	<div id="headerWrapper">
		<div class="number header box">글 번호</div><!-- 
		 --><div class="subject header box">제목</div><!-- 
		 --><div class="writer header box">작성자</div><!-- 
		 --><div class="create-date header box">작성일</div>
	</div>
	
	<c:choose>
		<c:when test="${not empty articleList}">
			<c:forEach items="${articleList}" var="article">
			<div>
				<div class="number box">${article.articleId}</div><!-- 
				 --><div class="subject box">
				 	<a href="/TodaysHouse/${boardId}/${article.articleId}">${article.title}</a>
				 </div><!-- 
				 --><div class="writer box">${article.memberVO.name}</div><!-- 
				 --><div class="create-date box">${article.regDate}</div>
			</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<div>
				등록된 게시물이 없습니다.
			</div>
		</c:otherwise>
	</c:choose>
	
	<hr>
	<a href="/TodaysHouse/${boardId}/articleWrite">글쓰기1</a>
</body>
</html>