package post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DoPostDemo
 */
@WebServlet("/DoPostDemo")
public class DoPostDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoPostDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("username");

		
		pw.print("<html><body>");
		pw.print("<h1>Using doGet</h1>");
		pw.print("<h2>Welcome "+name+"</h2>");
		pw.print("</body></html>");	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("username");
		String pass=request.getParameter("upass");

		
		pw.print("<html><body>");
		pw.print("<h1>Using doPost</h1>");
		pw.print("<h2>Welcome "+name+"</h2>");
		pw.print("<h4>Your Password is "+pass+"</h4>");
		pw.print("</body></html>");	}
	

}
