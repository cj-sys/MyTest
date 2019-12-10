<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select * from test");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

#header, #footer {
	background-color: #ccc;
	height: 80px;
}

#header>h1 {
	text-align: center;
}

table {
	width: 100%;
}

table td:nth-child(1) {
	width: 20%;
}

table td:nth-child(2) {
	width: 30%;
}

.row {
	border-bottom: red solid 1px;
}

.row>div {
	display: inline-block;
	width: 25%;
}

a {
	text-decoration: none;
}

#footer li {
	display: inline-block;
	width: 22%;
	margin: 0px 3px;
}

#footer a {
	display: inline-block;
	background-color: #aaa;
	width: 100%;
	height: 80px;
	text-align: center;
	line-height: 80px;
}
</style>
</head>
<body>
	<div id="header">
		<h1>app 화면</h1>
	</div>
	<div id="content">
		<div id="table">
			<div class="row">
				<table>
					<tr>
						<td rowspan="2">아이디</td>
						<td rowspan="2">이름</td>
					</tr>
					
				</table>
			</div>
		</div>
		<%
			while (rs.next()) {
		%>

		<a href="#?ID=<%=rs.getString("ID")%>">
			<div class="row">
				<div class="col"><%=rs.getString("id")%></div>
				<div class="col"><%=rs.getString("name")%></div>
			</div>
		</a>
		<%
			}
		%>
	</div>
	<div id="footer">
		<ul>
			<li><a href="#">HOME</a></li>
			<li><a href="#">menu1</a></li>
			<li><a href="#">menu2</a></li>
			<li><a href="#">BACK</a></li>
		</ul>
	</div>

</body>
</html>