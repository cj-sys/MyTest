<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="user.User" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty property="userID" name="user"/>
<jsp:setProperty property="userPassword" name="user"/>
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
		if(session.getAttribute("userID") != null){
			//userID에 세션값을 스트링 형태로 변경하여 넣어준다... 널이 아닐경우에... 세션이 존재한다면...
			userID = (String) session.getAttribute("userID");
		}
		if(userID != null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인이 되었습니다.')");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		}
	
		UserDAO userDAO =  new UserDAO();
		int result = userDAO.login(user.getUserID(), user.getUserPassword());
		//입력이 된 값을 로그인함수에 넣어서 실행.... 
		System.out.println("result: "+result);
		if(result == 1 ){
			session.setAttribute("userID", user.getUserID());
			//로그인에 성공한 경우 모두 세션 아이디를 부여 받기 때문에 이를 이용해서 로그인 여부를 확인 가능
			//
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		} else if(result == 0) {
			//0은 비번 틀릴때..
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다')");
			script.println("</script>");
		} else if (result == -2) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생~ 이동헌 바보~')");
			script.println("</script>");
		}else if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('아이디엄서영~ 이동헌 바보~')");
			script.println("</script>");
		}
	%>
	<a href="login.jsp">메인</a>
	
</body>
</html>