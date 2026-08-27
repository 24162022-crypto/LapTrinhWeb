package vn.iotstar.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.entity.User;
import vn.iotstar.service.IUserService;
import vn.iotstar.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/auth/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("username");
        String p = req.getParameter("password");

        User user = userService.login(u, p);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("account", user);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        } else {
            req.setAttribute("alertError", "Mật khẩu hoặc tài khoản sai!");
            req.getRequestDispatcher("/views/auth/login.jsp").forward(req, resp);
        }
    }
}