package vn.iotstar.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.entity.Category;
import vn.iotstar.service.ICategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.utils.Constant;

@MultipartConfig
@WebServlet(urlPatterns = {"/admin/categories", "/admin/category/add", "/admin/category/insert", "/admin/category/delete"})
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("/admin/categories")) {
            req.setAttribute("listCategory", categoryService.findAll());
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
        } else if (url.contains("/admin/category/add")) {
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        } else if (url.contains("/admin/category/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            categoryService.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Category category = new Category();
        category.setCategoryName(req.getParameter("categoryName"));
        category.setStatus(Integer.parseInt(req.getParameter("status")));

        Part part = req.getPart("imageFile");
        if (part != null && part.getSize() > 0) {
            String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            String ext = filename.substring(filename.lastIndexOf(".") + 1);
            String fname = System.currentTimeMillis() + "." + ext;
            
            File dir = new File(Constant.UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();
            part.write(Constant.UPLOAD_DIR + "/" + fname);
            category.setImages(fname);
        } else {
            category.setImages(req.getParameter("imageUrl"));
        }

        categoryService.insert(category);
        resp.sendRedirect(req.getContextPath() + "/admin/categories");
    }
}