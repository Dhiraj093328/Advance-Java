package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/SendMessageServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,   // 2MB
        maxFileSize = 1024 * 1024 * 10,        // 10MB
        maxRequestSize = 1024 * 1024 * 50      // 50MB
)
public class SendMessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SendMessageServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sender = request.getParameter("sender");
        String receiver = request.getParameter("receiver");
        String message = request.getParameter("message");

        Part filePart = request.getPart("image");
        String fileName = null;

        try {
            // If image uploaded
            if (filePart != null && filePart.getSize() > 0) {

                fileName = System.currentTimeMillis() + "_" + filePart.getSubmittedFileName();

                String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
                File uploadDir = new File(uploadPath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                filePart.write(uploadPath + File.separator + fileName);
            }

            // Database Insert
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO chat_messages(sender, receiver, message, image) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, sender);
            ps.setString(2, receiver);
            ps.setString(3, message);
            ps.setString(4, fileName);

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Redirect back to same page
        response.sendRedirect(request.getHeader("Referer"));
    }
}
