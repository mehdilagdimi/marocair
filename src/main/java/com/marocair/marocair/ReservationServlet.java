package com.marocair.marocair;

import com.marocair.marocair.controller.Auth;
import com.marocair.marocair.controller.ClientController;
import com.marocair.marocair.controller.ReservationController;
import com.marocair.marocair.dao.FlightDao;
import com.marocair.marocair.dao.ReservationDao;
import com.marocair.marocair.model.Admin;
import com.marocair.marocair.model.Person;
import com.marocair.marocair.model.Reservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "reservation", urlPatterns ={"/reservation", "/reservation/add-reservation/", "/reservation/edit"})
public class ReservationServlet extends HttpServlet {
    private String message;
    private static int userSession_id;
    public static Reservation reservation;
    public List<Reservation> reservations;
    public ReservationController reservationController;

    public ReservationServlet() {
        reservationController = new ReservationController();
    }

    public void init() {
        message = "Hello World!";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get all reservation
        userSession_id = Auth.auth(request.getSession()).getId();
        reservations =  reservationController.getClientReservations(userSession_id);
        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("client/reservations.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userSession_id = Auth.auth(request.getSession()).getId();
//        super.doPost(req, resp);
//        reservation = reservationController.addReservation(FlightServlet.flights, Integer.valueOf(request.getParameter("flight_id")) , userSession_id, Integer.valueOf(request.getParameter("passenger_id")) );
        reservation = reservationController.addReservation(FlightServlet.searchedFlights, Integer.valueOf(request.getParameter("flight-id")) , userSession_id, 1);

        //check if list of reservation is empty if yes then get all client reservation through doGet method above
        if(reservations == null) {
            this.doGet(request, response);
        } else {
            reservations.add(reservation);
            request.setAttribute("reservations", reservations);
            request.getRequestDispatcher(getInitParameter("url") +  "client/reservations.jsp").forward(request,response);
        }

    }

    public void destroy() {
    }
}