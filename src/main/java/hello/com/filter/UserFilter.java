package hello.com.filter;

import java.io.IOException;
import hello.com.entity.UserJPA;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

@WebFilter(urlPatterns = {"/user/*"})
public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        UserJPA user = (session != null) ? (UserJPA) session.getAttribute("accountJPA") : null;

        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/jpa/login");
            return;
        }

        // Chỉ cho user (3) và admin (1)
        if (user.getRoleid() != 3 && user.getRoleid() != 1) {
            resp.sendRedirect(req.getContextPath() + "/waiting");
            return;
        }

        chain.doFilter(request, response);
    }
}
