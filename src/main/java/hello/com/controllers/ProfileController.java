package hello.com.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession(false); // Lấy thông tin session
        if (session != null && session.getAttribute("username") != null) { // Nếu có session username thì hiện thị Xin chào <username>!
            String username = (String) session.getAttribute("username");
            resp.getWriter().println("<h2>Xin chào " + username + "!</h2>");
            resp.getWriter().println("<a href='logout'>Logout</a>");
        } else {
            resp.sendRedirect("login.html"); // Ngược lại trả về trang login
        }
    }
}
