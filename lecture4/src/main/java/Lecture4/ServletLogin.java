package Lecture4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        ValidateUtils v = new ValidateUtils();

        if (v.validateLogin(email, password) == true) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);

            out.println("<html><body>");
            out.println("Du er nå logget inn!");
            out.println("<form action='ServletDeleteUser' method='GET'>");
            out.println("<input type='submit' value='Delete User' />");
            out.println("</form>");
            out.println("</body></html>");
        } else {
            out.println("OBS! Enten email eller passord er feil! prøv en gang til!");
        }
    }
}

