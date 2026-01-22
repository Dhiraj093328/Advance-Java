package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    Bean b = new Bean();
	    b.setUsername(username);
	    b.setPassword(password);

	    if (b.validate()) {
	        request.getRequestDispatcher("success.jsp").forward(request, response);
	    } else {
	        request.getRequestDispatcher("error.jsp").forward(request, response);
	    }

	}

}
