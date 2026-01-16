package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		pw.print("<a href='index.html'>Add Employees</a>");
		pw.print("<h3>List of Employees</h3>");

		List<Emp> list = EmpDao.getAllEmployees();

		pw.print("<table border='1' width='100%'>");
		pw.print(
				"<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");

		for (Emp e : list) {
			pw.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getPassword()
					+ "</td><td>" + e.getEmail() + "</td><td>" + e.getCountry() + "</td>"
					+ "<td><a href='EditServlet?id=" + e.getId() + "'>Edit</a></td>"
					+ "<td><a href='DeleteServlet?id=" + e.getId() + "'>Delete</a></td></tr>");
		}

		pw.print("</table>");
		pw.close();
	}
}
