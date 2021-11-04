package Lecture4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/ServletDeleteUser")
public class ServletDeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        ValidateUtils v = new ValidateUtils();

        if (v.validateAdmin(session) == true) {
            request.getRequestDispatcher("deleteUser.jsp").forward(request, response);
        } else {
            out.println("Forbidden!!! Du er ikke admin baby!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Connection con;
        PreparedStatement ps;

        String email = request.getParameter("email");

        try {
            con = DBUtils.getINSTANCE().getConnection();
            String query = "delete from Lecture4.Users where Email = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.execute();
            response.sendRedirect("home.jsp");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}