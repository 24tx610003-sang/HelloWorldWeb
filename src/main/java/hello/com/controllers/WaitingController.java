package hello.com.controllers;

import hello.com.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/waiting")
@SuppressWarnings("serial")
public class WaitingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false); // tránh tạo session mới nếu chưa có

        if (session != null && session.getAttribute("account") != null) {
            User u = (User) session.getAttribute("account");
            req.setAttribute("username", u.getUserName());

            // Redirect theo role
            switch (u.getRoleid()) {
                case 1: // admin
                    resp.sendRedirect(req.getContextPath() + "/admin/home");
                    break;
                case 2: // manager
                    resp.sendRedirect(req.getContextPath() + "/manager/home");
                    break;
                default: // user thường
                    resp.sendRedirect(req.getContextPath() + "/home");
                    break;
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
