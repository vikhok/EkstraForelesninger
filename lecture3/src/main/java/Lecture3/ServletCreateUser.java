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

@WebServlet(value = "/ServletCreateUser")
public class ServletCreateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Please fill the following inputs to register a new user i databasen:</h1>");
        out.println("<form action='ServletCreateUser' method='POST'>");
        out.println("<input type='text' name='firstName' placeholder='First Name'/>");
        out.println("<input type='text' name='lastName' placeholder='Last Name'/>");
        out.println("<input type='email' name='email' placeholder='Email'/>");
        out.println("<input type='password' name='password' placeholder='Password'/>");
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

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            con = DBUtils.getINSTANCE().getConnection(out);
            String query = "insert into Lecture3.Users (First_name, Last_name, Email, Password) values (?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.execute();
            out.println("New user successfully added to database!");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
