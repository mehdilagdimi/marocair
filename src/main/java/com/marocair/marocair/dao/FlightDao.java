package com.marocair.marocair.dao;

import com.marocair.marocair.base.DaoBuilder;
import com.marocair.marocair.model.Client;
import com.marocair.marocair.model.Flight;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FlightDao extends DaoBuilder {
    public FlightDao (){
        table = "flight";
    }

    public Flight addFlight(Flight flight) {

        String cols = "_from,_to,nbr_of_seats,available_seats,depart_time,arrival_time,price";
        try {
            ResultSet res = this.insert(cols,flight.getFrom(),flight.getTo(),flight.getNbrOfSeats(),flight.getNbrOfSeats(),flight.getDepartTime(),flight.getArrivalTime(),flight.getPrice()).buildReturn().execute();
            if (res.next()) {
                flight.setId(res.getInt("id"));
                return flight;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
