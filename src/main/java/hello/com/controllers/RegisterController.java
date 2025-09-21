package hello.com.controllers;

import hello.com.models.User;
import hello.com.services.UserService;
import hello.com.services.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
@SuppressWarnings("serial")
public class RegisterController extends HttpServlet {

    public static final String REGISTER_PAGE = "/views/register.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    session = req.getSession(true);
                    session.setAttribute("account", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/home");
                    return;
                }
            }
        }

        req.getRequestDispatcher(REGISTER_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String fullname = req.getParameter("fullname");
        String phone = req.getParameter("phone");

        String alertMsg = "";

        UserService service = new UserServiceImpl();

        if (service.checkExistEmail(email)) {
            alertMsg = "Email đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(REGISTER_PAGE).forward(req, resp);
            return;
        }

        if (service.checkExistUsername(username)) {
            alertMsg = "Tài khoản đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(REGISTER_PAGE).forward(req, resp);
            return;
        }

        if (service.checkExistPhone(phone)) {
            alertMsg = "Số điện thoại đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(REGISTER_PAGE).forward(req, resp);
            return;
        }

        boolean isSuccess = service.register(username, password, email, fullname, phone);

        if (isSuccess) {
        	alertMsg = "Tạo tài khoản thành công!";
            req.setAttribute("alert", alertMsg);
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            alertMsg = "System error!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(REGISTER_PAGE).forward(req, resp);
        }
    }
}
