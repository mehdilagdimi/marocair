package com.marocair.marocair;

import java.io.*;

import com.marocair.marocair.controller.Auth;
import com.marocair.marocair.controller.ClientController;
import com.marocair.marocair.model.Admin;
import com.marocair.marocair.model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "addClient", value = "/add-client")
public class ClientServlet extends HttpServlet {
    private String message;
    ClientController clientController;

    public ClientServlet() {
        clientController = new ClientController();
    }

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String email = req.getParameter("email");
        String passw = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + email + "</h1>");
        out.println("<h1>" + passw + "</h1>");

        Person guest = new Admin();
        guest.setEmail(email);
        guest.setPassword(passw);
        Auth.authenticate(guest,req.getSession());
        out.println(Auth.auth(req.getSession()).getEmail());
        out.println(req.getSession().getAttribute("person"));
        out.println(req.getSession().getAttribute("role"));

        out.println("</body></html>");

        /*
        System.out.println("email" + clientModel.getEmail());
        System.out.println("id" + clientModel.getId());
        System.out.println("passw" + clientModel.getPassword());
        req.setAttribute("client", clientModel);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

         */
    }

    public void destroy() {
    }
}