package Lecture4;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidateUtils {
    public boolean validateLogin(String email, String password) {
        Connection db;
        PreparedStatement ps;
        try {
            db = DBUtils.getINSTANCE().getConnection();
            String query = "SELECT email, password FROM Lecture4.Users WHERE email = ? AND password = ?";
            ResultSet rs;
            ps = db.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();

            rs.next();
            String dbEmail = rs.getString("email");
            String dbPassword = rs.getString("password");
            if (dbEmail.equals(email) && dbPassword.equals(password)) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validateAdmin(HttpSession session) {
        Connection db;
        PreparedStatement ps;
        String email = (String) session.getAttribute("email");
        try {
            db = DBUtils.getINSTANCE().getConnection();
            String query = "SELECT Admin FROM Lecture4.Users WHERE email = ?";
            ResultSet rs;
            ps = db.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();

            rs.next();
            String dbAdmin = rs.getString("Admin");
            if (dbAdmin.equals("1")) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
