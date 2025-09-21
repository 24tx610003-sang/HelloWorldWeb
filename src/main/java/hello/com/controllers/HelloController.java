package hello.com.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/hello"})
public class HelloController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String name = null;
        Cookie[] cookies = req.getCookies(); // Lấy danh sách cookies
        if (cookies != null) {
            for (Cookie c : cookies) { // Duyệt qua từng cookie
                if ("username".equals(c.getName())) { // Nếu cookie có tên là "username"
                    name = c.getValue(); // Gán vào biến name
                }
            }
        }

        if (name == null) { // Nếu chưa có cookie username (chưa login hoặc cookie đã hết hạn) thì chuyển hướng về trang login
            resp.sendRedirect(req.getContextPath() + "/login.html");
        } else {
            out.println("<h2>Xin chào " + name + "!</h2>"); // Ngược lại in ra Xin chào <tên user>!
        }
    }
}
