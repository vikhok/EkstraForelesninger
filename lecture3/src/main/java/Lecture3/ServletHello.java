package Lecture3;

import java.io.*;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/ServletHello")
public class ServletHello extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("Velkommen til den tredje ekstraforelesning i JAVA programmering");
    }
}