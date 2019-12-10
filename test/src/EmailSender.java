import java.io.IOException;
import java.io.PrintWriter;

import javax.print.attribute.standard.Severity;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

@WebServlet
public class EmailSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public EmailSender() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		User user = new User("이창진", "hello@java.com", 31);
		PrintWriter printWriter = response.getWriter();
		
		printWriter.write("<!DOCTYPE html>");
		printWriter.write("<html>");
		printWriter.write("<head>");
		printWriter.write("<meta charset=\"UTF-8\">");
		printWriter.write("<title>Insert title here</title>");
		printWriter.write("</head>");
		printWriter.write("<body>");
		
		printWriter.write("이름 : " + user.getName()+"<br>");
		printWriter.write("이메일 : " + user.getEmail()+"<br>");
		printWriter.write("나이 : " + user.getAge()+"<br>");
		
		printWriter.write("</body>");
		printWriter.write("</html>");
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
}
