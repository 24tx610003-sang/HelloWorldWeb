package hello.com.filter;

import java.io.IOException;
import hello.com.entity.UserJPA;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

@WebFilter(urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        UserJPA user = (session != null) ? (UserJPA) session.getAttribute("accountJPA") : null;

        if (user == null || user.getRoleid() != 1) {
            resp.sendRedirect(req.getContextPath() + "/jpa/login");
            return;
        }

        chain.doFilter(request, response);
    }
}
