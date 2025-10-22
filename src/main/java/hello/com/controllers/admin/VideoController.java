package hello.com.controllers.admin;

import java.io.IOException;
import java.util.List;

import hello.com.entity.Video;
import hello.com.services.VideoService;
import hello.com.services.impl.VideoServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/videos/list"})
public class VideoController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    VideoService videoService = new VideoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Video> list = videoService.findAll();
        req.setAttribute("listVideo", list);

        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/videos/list.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        // Tùy chỉnh xử lý thêm (nếu có form upload video)
    }
}
