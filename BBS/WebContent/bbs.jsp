<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="bbs.BbsDAO"%>
<%@ page import="bbs.Bbs"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html" http-equiv="Content-Type">
<meta name="viewport" content="width=device-width" , inital-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<!-- 부트스트랩.css를 참조해서 이 홈페이지의 기본적인 css를 설정하겟다~~ -->
<title>JSP 게시판 웹사이트</title>
<style type="text/css">
	a, a:hover {
		color: #000000;
		text-decoration: none;
	}
</style>
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

		int pageNumber = 1;
		//기본페이지 를 의미

		//파라미터로 pageNumber라는게 넘어 왔다면
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
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
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<%
						BbsDAO bbsDAO = new BbsDAO();

						// 여기다 현제의 페이지에서 가져온 리스트(게시글 목록)를 하나씩 출력할거임
						ArrayList<Bbs> list = bbsDAO.getList(pageNumber);

						for (int i = list.size()-1 ; i >=0; i--) {
					%>
					<tr>
						<td><%=list.get(i).getBbsID() %></td>
						<td><a href="view.jsp?bbsID=<%=list.get(i).getBbsID() %>"> <%=list.get(i).getBbsTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll("\n", "<br>").replaceAll(">", "&gt;") %></a></td>
						<td><%=list.get(i).getUserID() %></td>
						<td><%=list.get(i).getBbsDate().substring(0,11)+list.get(i).getBbsDate().substring(11,13) + "시" + list.get(i).getBbsDate().substring(14,16)+"분" %></td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>
			
			<%
				if(pageNumber != 1){
			%>
			
				<a href="bbs.jsp?pageNumber=<%=pageNumber-1%>" class="btn btn-success btn-arraw-left">이전</a>
			
			<% 		
				}if(bbsDAO.nextPage(pageNumber+1)){
					
					%>
					<a href="bbs.jsp?pageNumber=<%=pageNumber+1%>" class="btn btn-success btn-arraw-left">다음</a>
					<%
				}
			%>
			<a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>


	<!-- 애니메이션을 담당하게될 js를 참조-->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>