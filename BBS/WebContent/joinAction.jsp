<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO"%>
<%@ page import="user.User"%>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="user" class="user.User" scope="page" />
<!-- 넘어오는 데이터를 각각에 넣어서 받는다. -->
<jsp:setProperty property="userID" name="user" />
<jsp:setProperty property="userPassword" name="user" />
<jsp:setProperty property="userName" name="user" />
<jsp:setProperty property="userGender" name="user" />
<jsp:setProperty property="userEmail" name="user" />
<!-- login.jsp에서 넘어오는 id와 pw를 각각 그대로 담긴다.  -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>JSP 게시판 웹사이트</title>
</head>
<body>
	<%
		String userID = null;

		// 세션을 확인해서 userid란 이름이란아이디로 세션이 존재하는 회원들은 userid에 해당 세션값을 넣어주도록한다. 이렇게 함으로서
		//자신에게 할당된 세션아이드를 담을수 있도록 만들어 준다.
		if (session.getAttribute("userID") != null) {
			//userID에 세션값을 스트링 형태로 변경하여 넣어준다... 널이 아닐경우에... 세션이 존재한다면...
			userID = (String) session.getAttribute("userID");
		}
		if (userID != null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인이 되었습니다.')");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		}

		if (user.getUserID() == null || user.getUserPassword() == null || user.getUserName() == null
				|| user.getUserGender() == null || user.getUserEmail() == null) {
			PrintWriter scr = response.getWriter();
			scr.println("<script>");
			scr.println("alert('입력이 안 된 사항이 있습니다')");
			scr.println("history.back()");
			scr.println("</script>");
		} else {
			UserDAO userDAO = new UserDAO();
			int result = userDAO.join(user);
			//입력이 된 값을 다오의 조인함수에 넣어서 실행.... 
			System.out.println("result: " + result);
			if (result == -1) {
				//id는 프라이머리 키.. 동일한 데이터가 있다면 db오류가 발생하면서 -1을 리턴하게된다.
				PrintWriter scr = response.getWriter();
				scr.println("<script>");
				scr.println("alert('이미 존재하는 아이디입니다')");
				scr.println("history.back()");
				scr.println("</script>");
			} else {
				//성공 한 뒤 메인페이지로 이동시킨다.
				session.setAttribute("userID", user.getUserID());
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href='main.jsp'");
				script.println("</script>");
			}
		}
	%>
	<a href="login.jsp">메인</a>

</body>
</html>