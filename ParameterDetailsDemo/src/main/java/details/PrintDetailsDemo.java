package details;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class PrintDetailsDemo
 */
@WebServlet("/PrintDetailsDemo")
public class PrintDetailsDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintDetailsDemo() {
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
		
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String phone=request.getParameter("phone");
		String qua=request.getParameter("qua");
		String city=request.getParameter("city");

		
		pw.print("<html><body>");
		pw.print("<h1>User Details :</h1>");
		pw.print("<h2>Name : "+name+"</h2>");
		pw.print("<h2>Age : "+age+"</h2>");
		pw.print("<h2>Contact No : "+phone+"</h2>");
		pw.print("<h2>Qualification : "+qua+"</h2>");
		pw.print("<h2>City : "+city+" </h2>");

		pw.print("</body></html>");
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
