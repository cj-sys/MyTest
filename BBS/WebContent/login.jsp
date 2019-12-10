<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html" http-equiv="Content-Type">
<meta name="viewport" content="width=device-width", inital-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<!-- 부트스트랩.css를 참조해서 이 홈페이지의 기본적인 css를 설정하겟다~~ -->
<title>JSP 게시판 웹사이트</title>
</head>
<body>

	<!--네비게이션 - 하나의 웹사이트의 전반적인 구성을 보여주는 것. -->
	<nav class="navbar navbar-default">
		<div class="navbar-header"> <!-- head : 로고같은걸 담는 영역 -->
			<button type="button" class="navbar-toggle collapsed"
				data-togle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
				<a class="navbar-brand" href="main.jsp">JSP 게시판 웹 사이트</a>
		</div>
	<div class="navbar-collapse" id="bs-example-navbar-collapse-1" >
	<!-- class="collapse navbar-collapse" -->
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li><a href="bbs.jsp">게시판</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" 
						data-togle="dropdown" role="button" aria-haspopup="true" 
						aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul >
					<!-- class="dropdown-menu" -->
						<li class="active"><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
						<li><a href="index.jsp">인덱스</a></li>
					</ul>
				</li>
			</ul>
		</div> 
	</nav>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4"></div>
			<div class="jumbotron" style="padding-top: 20px;">
				<form method="post" action="loginAction.jsp">
					<h3 style="text-align: center;">로그인 화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀먼호" name="userPassword" maxlength="20">
					</div>
					<input type="submit" class="btn btn-primary form-control" value="로그인">
				</form>
			</div>
	</div>
	<!-- 애니메이션을 담당하게될 js를 참조-->	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>