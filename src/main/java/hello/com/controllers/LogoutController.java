package hello.com.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
@SuppressWarnings("serial")
public class LogoutController extends HttpServlet {

    public static final String COOKIE_REMEMBER = "username";
    public static final String SESSION_ACCOUNT = "account";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (COOKIE_REMEMBER.equals(cookie.getName())) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
        }

        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
