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

@WebServlet(value = "/ServletUpdateUser")
public class ServletUpdateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Please provide the email of the employee to give an admin role:</h1>");
        out.println("<form action='ServletUpdateUser' method='POST'>");
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
            String query = "update Lecture3.Users set Admin = true where Email = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.execute();
            out.println("Employee has admin permission now!");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
