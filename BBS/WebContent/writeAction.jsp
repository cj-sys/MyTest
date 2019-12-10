<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bbs.BbsDAO"%>
<%@ page import="java.io.PrintWriter"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="bbs" class="bbs.Bbs" scope="page" />
<!-- 넘어오는 데이터를 각각에 넣어서 받는다. -->
<jsp:setProperty property="bbsTitle" name="bbs" />
<jsp:setProperty property="bbsContent" name="bbs" />

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
		if (userID == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하세요.')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		} else {
			if (bbs.getBbsTitle() == null || bbs.getBbsContent() == null) {
				PrintWriter scr = response.getWriter();
				scr.println("<script>");
				scr.println("alert('입력이 안 된 사항이 있습니다')");
				scr.println("history.back()");
				scr.println("</script>");
			} else {
				BbsDAO bbsDAO = new BbsDAO();
				int result = bbsDAO.write(bbs.getBbsTitle(), userID, bbs.getBbsContent());
				if (result == -1) {
					PrintWriter scr = response.getWriter();
					scr.println("<script>");
					scr.println("alert('글쓰기에 실패했습니다.')");
					scr.println("history.back()");
					scr.println("</script>");
				} else {
					//성공 한 뒤 메인페이지로 이동시킨다.
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href='bbs.jsp'");
					script.println("</script>");
				}
			}
		}
	%>
	<a href="login.jsp">메인</a>

</body>
</html>