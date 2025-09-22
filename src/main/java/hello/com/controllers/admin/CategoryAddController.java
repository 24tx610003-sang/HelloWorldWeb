package hello.com.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import hello.com.models.Category;
import hello.com.services.CategoryService;
import hello.com.services.impl.CategoryServiceImpl;
import hello.com.utils.Constant;

@WebServlet(urlPatterns = { "/admin/category/add" })
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB
        maxRequestSize = 1024 * 1024 * 50     // 50MB
)
public class CategoryAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/category/add.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            Category category = new Category();
            category.setCatename(req.getParameter("name"));

            Part part = req.getPart("icon");
            if (part != null && part.getSize() > 0) {
                String originalFileName = Paths.get(part.getSubmittedFileName())
                                               .getFileName().toString();
                int index = originalFileName.lastIndexOf(".");
                String ext = (index > 0) ? originalFileName.substring(index + 1) : "";
                String fileName = System.currentTimeMillis() + "." + ext;

                String uploadPath = "C:" + File.separator + "Users" + File.separator + "ASUS"
                        + File.separator + "eclipse" + File.separator + "www"
                        + File.separator + "HelloWorld" + File.separator + "src"
                        + File.separator + "main" + File.separator + "webapp"
                        + File.separator + Constant.UPLOAD_DIR
                        + File.separator + "category";


                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                    System.out.println("Tạo thư mục upload: " + uploadPath);
                }

                String fullFilePath = uploadPath + File.separator + fileName;
                System.out.println("Đang lưu file: " + fullFilePath);

                part.write(fullFilePath);
                System.out.println("Upload thành công!");

                category.setIcon(Constant.UPLOAD_DIR + "/category/" + fileName);
            } else {
                category.setIcon(null);
            }

            cateService.insert(category);
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Upload file thất bại!");
        }
    }
}
