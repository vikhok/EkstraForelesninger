package Lecture3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/ServletGetUserDetails")
public class ServletGetUserDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Get the details of the user from the database by providing email:</h1>");
        out.println("<form action='ServletGetUserDetails' method='POST'>");
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
            String query = "select * from Users where Email = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String dbFirstName = rs.getString("First_name");
            String dbLastName = rs.getString("Last_name");
            String dbEmail = rs.getString("Email");
            String dbPassword = rs.getString("Password");
            out.println(dbFirstName);
            out.println(dbLastName);
            out.println(dbEmail);
            out.println(dbPassword);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}