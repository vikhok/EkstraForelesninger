package Lecture3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(value = "/ServletListAllUsers")
public class ServletListAllUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        Connection con;
        PreparedStatement ps;

        try {
            con = DBUtils.getINSTANCE().getConnection(out);
            String query = "select * from Lecture3.Users";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String dbFirstName = rs.getString("First_name");
                String dbLastName = rs.getString("Last_name");
                String dbEmail = rs.getString("Email");
                String dbPassword = rs.getString("Password");
                out.println(dbFirstName);
                out.println(dbLastName);
                out.println(dbEmail);
                out.println(dbPassword);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}