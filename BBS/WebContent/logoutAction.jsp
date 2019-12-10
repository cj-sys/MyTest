<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>JSP 게시판 웹사이트</title>
</head>
<body>
	<%
		session.invalidate();
		// 세션을 빼앗겨서 로그아웃하게 만든다.
	%>
	<script>
		location.href = 'main.jsp';
	</script>
</body>
</html>