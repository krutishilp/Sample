import javax.servlet.http.*;
import java.io.*;
class MyServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Manual Hello World!! </h1>");
		out.println("</body>");
		out.println("</html>");
	}

}