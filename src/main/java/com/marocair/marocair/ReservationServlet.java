package com.marocair.marocair;

import com.marocair.marocair.controller.Auth;
import com.marocair.marocair.controller.ClientController;
import com.marocair.marocair.model.Admin;
import com.marocair.marocair.model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "reservation", value = "/reservation")
public class ReservationServlet extends HttpServlet {
    private String message;
    ClientController clientController;

    public ReservationServlet() {
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
    }

    public void destroy() {
    }
}