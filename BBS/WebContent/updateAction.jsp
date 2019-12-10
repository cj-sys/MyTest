<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bbs.BbsDAO"%>
<%@ page import="bbs.Bbs"%>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="bbs" class="bbs.Bbs" scope="page" />
<!-- 넘어오는 데이터를 각각에 넣어서 받는다. -->
<jsp:setProperty property="bbsTitle" name="bbs" />
<jsp:setProperty property="bbsContent" name="bbs" />

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
		} 
		int bbsID =0;
		if(request.getParameter("bbsID") != null){
			bbsID=Integer.parseInt(request.getParameter("bbsID"));
		}
		
		if(bbsID==0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('유효하지 안ㄶ은 글입니다.')");
			script.println("location.href = 'bbs.jsp'");
			script.println("</script>");
		}
		
		
		Bbs bbss = new BbsDAO().getBbs(bbsID);
		if(!userID.equals(bbss.getUserID())){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('권한이 없습니다.')");
			script.println("location.href = 'bbs.jsp'");
			script.println("</script>");
		} else {
			//자바 빈즈를 안쓰고.. updatepage에서 넘어오는파라미터중 bbsTitle로 넘어온걸 비교 한다.
			if (bbss.getBbsTitle() == null || bbss.getBbsContent() == null ||
					bbss.getBbsTitle().equals("") || bbss.getBbsContent().equals("")) {
				PrintWriter scr = response.getWriter();
				scr.println("<script>");
				scr.println("alert('입력이 안 된 사항이 있습니다')");
				scr.println("history.back()");
				scr.println("</script>");
			} else {
				BbsDAO bbsDAO = new BbsDAO();
				int result = bbsDAO.update(bbsID,request.getParameter("bbsTitle"),request.getParameter("bbsContent"));
				if (result == -1) {
					PrintWriter scr = response.getWriter();
					scr.println("<script>");
					scr.println("alert('글수정에 실패했습니다.')");
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
</body>
</html>