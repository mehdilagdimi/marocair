package com.marocair.marocair;

import com.marocair.marocair.dao.FlightDao;
import com.marocair.marocair.model.Flight;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/flight")
public class FlightServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Flight flight = new Flight();
        flight.setArrivalTime(req.getParameter("arrival-time"));
        flight.setDepartTime(req.getParameter("depart-time"));
        flight.setNbrOfSeats(Integer.valueOf(req.getParameter("nbr-of-seats")));
        flight.setFrom(req.getParameter("from"));
        flight.setTo(req.getParameter("to"));
        flight.setPrice(Float.valueOf(req.getParameter("price")));
        new FlightDao().addFlight(flight);
    }
}
