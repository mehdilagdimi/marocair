package com.marocair.marocair;

import com.marocair.marocair.controller.FlightsController;
import com.marocair.marocair.dao.FlightDao;
import com.marocair.marocair.model.Flight;
import com.marocair.marocair.util.TimeHelper.TimeUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/flight")
public class FlightServlet extends HttpServlet {
    FlightsController flightsController;
    @Override
    public void init() throws ServletException {
        super.init();
        flightsController = new FlightsController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Executed when search is requested
        if(req.getParameter("searchflight") != null){
            String from = req.getParameter("from");
            String to = req.getParameter("to");
            String date = req.getParameter("date");

            List<Flight> list = flightsController.getSearchedFlights(from, to, date);

            req.setAttribute("searchedFlights", flightsController.getSearchedFlights(from, to, date));
            req.getRequestDispatcher("pages/flights.jsp").forward(req,resp);
            return;
        }

        // Get all flights
        req.setAttribute("flights",new FlightDao().getFlights());
        req.getRequestDispatcher("admin/flights.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Flight flight = new Flight();
        flight.setArrivalTime(TimeUtil.stringToTimestamp(req.getParameter("arrival-time")));
        flight.setDepartTime(TimeUtil.stringToTimestamp(req.getParameter("depart-time")));
        flight.setNbrOfSeats(Integer.valueOf(req.getParameter("nbr-of-seats")));
        flight.setFrom(req.getParameter("from"));
        flight.setTo(req.getParameter("to"));
        flight.setPrice(Float.valueOf(req.getParameter("price")));
        new FlightDao().addFlight(flight);
    }
}
