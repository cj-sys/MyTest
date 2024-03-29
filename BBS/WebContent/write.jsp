<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html" http-equiv="Content-Type">
<meta name="viewport" content="width=device-width" , inital-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<!-- 부트스트랩.css를 참조해서 이 홈페이지의 기본적인 css를 설정하겟다~~ -->
<title>JSP 게시판 웹사이트</title>
</head>
<body>
	<%
		//로그인을 한 사람이라면, 세션이존재한사람이라면 userID에 id값을 받는다.
		//세션에 있는 값을 그대로 가져온다.
		//userid에 해당변수가 담긴다.
		String userID = null;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
	%>
	<!--네비게이션 - 하나의 웹사이트의 전반적인 구성을 보여주는 것. -->
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<!-- head : 로고같은걸 담는 영역 -->
			<button type="button" class="navbar-toggle collapsed"
				data-togle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">JSP 게시판 웹 사이트</a>
		</div>
		<div class="navbar-collapse" id="bs-example-navbar-collapse-1">
			<!-- class="collapse navbar-collapse" -->
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li clss="active"><a href="bbs.jsp">게시판</a></li>
			</ul>

			<%
				//userID가 null이면 로그인이나 회원가입을 할수 있게
				if (userID == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-togle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul>
						<!-- class="dropdown-menu" -->
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>

					</ul></li>
			</ul>

			<%
				// 그렇지 않다면... 로그인이 되어있는 사람이 볼수 있는 화면....
				} else {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-togle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul>
						<!-- class="dropdown-menu" -->
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul></li>
			</ul>
			<%
				}
			%>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<form method="post" action="writeAction.jsp">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">게시판
								글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control"	placeholder="글 제목" name="bbsTitle" maxlength="50"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" name="bbsContent" maxlength="2048" placeholder="글 내용" style="height:350px"></textarea></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
			</form>
		</div>
	</div>


	<!-- 애니메이션을 담당하게될 js를 참조-->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>