package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/GetMessagesServlet")
public class GetMessagesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetMessagesServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user1 = request.getParameter("user1");
        String user2 = request.getParameter("user2");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM chat_messages " +
                    "WHERE (sender=? AND receiver=?) " +
                    "OR (sender=? AND receiver=?) " +
                    "ORDER BY timestamp ASC";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user1);
            ps.setString(2, user2);
            ps.setString(3, user2);
            ps.setString(4, user1);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String sender = rs.getString("sender");
                String message = rs.getString("message");
                String image = rs.getString("image");
                String time = rs.getString("timestamp");

                if (sender.equals(user1)) {
                    out.println("<div class='sent'>");
                } else {
                    out.println("<div class='received'>");
                }

                if (message != null && !message.isEmpty()) {
                    out.println("<p>" + message + "</p>");
                }

                if (image != null) {
                    out.println("<img src='uploads/" + image + "' width='150'/><br>");
                }

                out.println("<small>" + time + "</small>");
                out.println("</div>");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
