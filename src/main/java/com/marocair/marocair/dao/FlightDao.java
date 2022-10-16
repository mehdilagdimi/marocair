package com.marocair.marocair.dao;

import com.marocair.marocair.FlightServlet;
import com.marocair.marocair.base.DaoBuilder;
import com.marocair.marocair.model.Client;
import com.marocair.marocair.model.Flight;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Flight> getFlights(){
        ArrayList<Flight> flights = new ArrayList<>();
        try {
            ResultSet res = this.select("*").build().execute();
            while (res.next()){
                Flight flight = new Flight(
                        res.getInt("id"),
                        res.getString("_from"),
                        res.getString("_to"),
                        res.getInt("nbr_of_seats"),
                        res.getInt("available_seats"),
                        res.getTimestamp("depart_time"),
                        res.getTimestamp("arrival_time"),
                        res.getFloat("price")
                );
                flights.add(flight);
            }
            return flights;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Flight> getFlightsByContraints(String from, String to, Timestamp date){
        List<Flight> flights = new ArrayList<>();
        try{
            ResultSet res = this.select("*").where("_from", "=", from).and("_to", "=", to).and("depart_time", ">", date).build().execute();
            while (res.next()){
                Flight flight = new Flight(
                        res.getInt("id"),
                        res.getString("_from"),
                        res.getString("_to"),
                        res.getInt("nbr_of_seats"),
                        res.getInt("available_seats"),
                        res.getTimestamp("depart_time"),
                        res.getTimestamp("arrival_time"),
                        res.getFloat("price")
                );
                flights.add(flight);
            }
            System.out.println(" flights inside DAO ");
            flights.forEach(System.out::print);
            return flights;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
