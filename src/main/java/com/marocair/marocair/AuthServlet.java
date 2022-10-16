package com.marocair.marocair;

import com.marocair.marocair.controller.Auth;
import com.marocair.marocair.model.Admin;
import com.marocair.marocair.model.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth/admin-auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        //verify if admin
        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(password);

        if (Auth.authenticate(admin,req.getSession())) {
            resp.sendRedirect(getServletContext().getInitParameter("url")+"admin/");
            return;
        }

        //verify if client
        Client client = new Client();
        client.setEmail(email);
        client.setPassword(password);

        if(Auth.authenticate(client,req.getSession())){
            System.out.println("inside client ");
            resp.sendRedirect(getServletContext().getInitParameter("url")+"pages/search-flight.jsp");
            return;
        }

    }
}
