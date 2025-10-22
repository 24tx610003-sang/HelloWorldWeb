package hello.com.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import hello.com.entity.Categories;
import hello.com.services.CategoriesService;
import hello.com.services.impl.CategoriesServiceImpl;
import hello.com.utils.Constant;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(urlPatterns = {"/admin/categories/list"})
public class CategoriesController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CategoriesService cateService = new CategoriesServiceImpl();
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
		List<Categories> list = cateService.findAll();
		req.setAttribute("listCate", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/categories/list.jsp");
		
		rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

    }
}
