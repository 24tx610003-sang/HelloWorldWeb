package hello.com.controllers;

import java.io.IOException;
import hello.com.entity.UserJPA;
import hello.com.services.UserJPAService;
import hello.com.services.impl.UserJPAServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = {"/jpa/login"})
public class LoginJPAController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserJPAService userService = new UserJPAServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        // Nếu có session cũ chứa User thường -> xóa nó
        if (session != null) {
            Object oldAccount = session.getAttribute("account");
            if (oldAccount != null && oldAccount.getClass().getName().equals("hello.com.models.User")) {
                session.removeAttribute("account");
            }
        }

        // Nếu đã đăng nhập bằng JPA thì chuyển hướng
        if (session != null && session.getAttribute("accountJPA") != null) {
            UserJPA user = (UserJPA) session.getAttribute("accountJPA");
            redirectByRole(user, req, resp);
            return;
        }

        req.getRequestDispatcher("/views/jpa/login.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        req.getSession().invalidate();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserJPA user = userService.login(username, password);

        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("accountJPA", user);

            redirectByRole(user, req, resp);
        } else {
            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu sai!");
            RequestDispatcher rd = req.getRequestDispatcher("/views/jpa/login.jsp");
            rd.forward(req, resp);
        }
    }

    private void redirectByRole(UserJPA user, HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        if (user.getRoleid() == 1) {
            resp.sendRedirect(req.getContextPath() + "/admin/home");
        } else if (user.getRoleid() == 3) {
            resp.sendRedirect(req.getContextPath() + "/user/home");
        } else {
            resp.sendRedirect(req.getContextPath() + "/waiting");
        }
    }
}
