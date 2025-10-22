package hello.com.filter;

import java.io.IOException;
import hello.com.entity.UserJPA;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

@WebFilter(urlPatterns = {"/manager/*"})
public class ManagerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        // Lấy thông tin user từ session
        UserJPA user = session != null ? (UserJPA) session.getAttribute("accountJPA") : null;

        // Nếu chưa đăng nhập → chuyển về trang login JPA
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/jpa/login");
            return;
        }

        // Nếu không có quyền manager (2) hoặc admin (1) → chuyển đến trang waiting
        if (user.getRoleid() != 2 && user.getRoleid() != 1) {
            resp.sendRedirect(req.getContextPath() + "/waiting");
            return;
        }

        // Nếu hợp lệ → cho phép tiếp tục
        chain.doFilter(request, response);
    }
}
