<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/TodaysHouse/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		$(".loginBtn").click(function() {
			$.post("/TodaysHouse/member/login"
				   , $("#loginData").serialize()
				   , function(response) {
					   if(response.status) {
							alert("로그인되었습니다.")
							location.href="/TodaysHouse/"
						} else {
							alert("로그인에 실패하였습니다.")
							location.href="/TodaysHouse/member/login"
						}
					}
			)
		})
	})
</script>
</head>
<body>
	<h1>LOGIN</h1>
	<form:form id="loginData" modelAttribute="memberVO" >
	<div>
		<input type="email" name="email" name="email" placeholder="EMAIL" value="" />
	</div>
	<div>
		<input type="password" name="password" name="password" placeholder="PASSWORD" value="" />
	</div>
	<div>
		<input type="button" class="loginBtn" value="로그인" />
	</div>
	</form:form>
</body>
</html>