package com.marocair.marocair;

import com.marocair.marocair.controller.Auth;
import com.marocair.marocair.controller.ClientController;
import com.marocair.marocair.controller.ReservationController;
import com.marocair.marocair.dao.FlightDao;
import com.marocair.marocair.dao.ReservationDao;
import com.marocair.marocair.model.Admin;
import com.marocair.marocair.model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "reservation", urlPatterns ={"/reservation", "/reservation/add-reservation/", "/reservation/edit"})
public class ReservationServlet extends HttpServlet {
    private String message;
    public ReservationController reservationController;



    public void init() {
        reservationController = new ReservationController();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get all reservation
        request.setAttribute("reservations", reservationController.getClientReservation(Auth.auth(request.getSession()).getId()));
        request.getRequestDispatcher("client/reservations.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        if (req.getParameter("flight-id") != null) {

        }
    }

    public void destroy() {
    }
}