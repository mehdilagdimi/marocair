package com.marocair.marocair.controller;

import com.marocair.marocair.dao.FlightDao;
import com.marocair.marocair.model.Flight;
import com.marocair.marocair.util.TimeHelper.TimeUtil;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class FlightsController {

    public List<Flight> getSearchedFlights(String from, String to, String date) {
        //convert date to timestamp
        Timestamp formattedDate = TimeUtil.stringToTimestamp(date);
        System.out.println(" formatted date " + formattedDate);
        return new FlightDao().getFlightsByContraints(from, to, formattedDate);
    }

}
