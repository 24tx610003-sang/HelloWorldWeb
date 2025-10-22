package hello.com.controllers.admin;

import java.io.IOException;
import java.util.List;

import hello.com.entity.UserJPA;
import hello.com.services.UserJPAService;
import hello.com.services.impl.UserJPAServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/test/user/list"})
public class UserJPAController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserJPAService userService = new UserJPAServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<UserJPA> list = userService.findAll();
        req.setAttribute("listUser", list);

        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/user/list.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserJPA user = new UserJPA();
        user.setUsername(username);
        user.setPassword(password);

        userService.insert(user);

        resp.sendRedirect(req.getContextPath() + "/admin/user/list");
    }
}
