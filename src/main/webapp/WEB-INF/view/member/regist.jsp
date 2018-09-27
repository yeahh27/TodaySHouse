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
		$(".regBtn").click(function() {
			$.post("/TodaysHouse/member/regist"
					, $("#regData").serialize()
					, function(response) {
						if(response.status) {
							alert("회원 등록되었습니다.")
							location.href="/TodaysHouse/member/login"
						} else {
							alert("회원등록에 실패하였습니다.")
							location.href="/TodaysHouse/member/regist"
						}
					}
			)
		})
	})
</script>
</head>
<body>
	<h1>REGIST</h1>
	<form:form id="regData" modelAttribute="memberVO" >
		<div>
			<label for="email">Email</label>
			<input type="email" name="email" id="email" placeholder="EMAIL" value=""/>
		</div>
		<div>
			<label for="name">Name</label>
			<input type="text" name="name" id="name" placeholder="NAME" value="" />
		</div>
		<div>
			<label for="password">Password</label>
			<input type="password" name="password" id="password" placeholder="PASSWORD" value=""/>
		</div>
		<div>
			<label for="password2">Password Confirm</label>
			<input type="password" name="password2" id="password2" placeholder="PASSWORD CONFIRM" />
		</div>
		<div>
			<label for="chatOk">채팅 허용 여부</label>
			<input type="radio" name="chatOk" value="true" />허용
			<input type="radio" name="chatOk" value="false" />거부		
		</div>
		<div>
			<input type="button" class="regBtn" value="회원가입" />
		</div>
	</form:form>
</body>
</html>