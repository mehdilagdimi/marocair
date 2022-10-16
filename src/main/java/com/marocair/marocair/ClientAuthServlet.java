package com.marocair.marocair;

import com.marocair.marocair.controller.Auth;
import com.marocair.marocair.model.Admin;
import com.marocair.marocair.model.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth/client-auth")
public class ClientAuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Client client = new Client();
        client.setEmail(email);
        client.setPassword(password);

        if (Auth.authenticate(client,req.getSession())) {
            resp.sendRedirect(getServletContext().getInitParameter("url")+"index.jsp");
        }



    }
}
