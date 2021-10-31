package Lecture3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(name = "ServletDeleteUser", urlPatterns = {"/ServletDeleteUser"})
public class ServletDeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Delete user from the database by providing email:</h1>");
        out.println("<form action='ServletDeleteUser' method='POST'>");
        out.println("<input type='email' name='email' placeholder='Email'/>");
        out.println("<input type='submit'/>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        Connection con;
        PreparedStatement ps;

        String email = request.getParameter("email");

        try {
            con = DBUtils.getINSTANCE().getConnection(out);
            String query = "delete from Lecture3.Users where Email = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.execute();
            out.println("User successfully deleted from the database!");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}