package com.marocair.marocair;

import java.io.*;

import com.marocair.marocair.controller.ClientController;
import com.marocair.marocair.model.ClientModel;
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
        out.println("</body></html>");
        ClientModel clientModel = clientController.getClient(email, passw);

        System.out.println("email" + clientModel.getEmail());
        System.out.println("id" + clientModel.getId());
        System.out.println("passw" + clientModel.getPassw());
        req.setAttribute("client", clientModel);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public void destroy() {
    }
}