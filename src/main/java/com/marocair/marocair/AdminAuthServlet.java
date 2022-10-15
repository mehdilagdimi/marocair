package com.marocair.marocair;

import com.marocair.marocair.controller.Auth;
import com.marocair.marocair.model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth/client-auth")
public class AdminAuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(password);

        if (Auth.authenticate(admin,req.getSession())) {
            resp.sendRedirect(getServletContext().getInitParameter("url")+"admin/");
        }

    }
}
