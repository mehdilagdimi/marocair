package com.marocair.marocair.controller;

import com.marocair.marocair.dao.ReservationDao;
import com.marocair.marocair.model.Flight;
import com.marocair.marocair.model.Reservation;

import java.util.List;

public class ReservationController {

    ReservationDao reservationDao;
    public ReservationController(){
        reservationDao = new ReservationDao();
    }
    //GET CLIENT RESERVATION BY HIS ID
    public List<Reservation> getClientReservations(int id) {
        return reservationDao.getReservationsByClientId(id);
    }

    public Reservation addReservation(List<Flight> searchedFlights, int flight_id, int client_id, int passanger_id){
        //get model of selected flight and get its price to calculate appropriate reservation amount
        Flight selectedFlight = searchedFlights.stream()
                .filter(flight -> flight.getId() == flight_id)
                .findFirst()
                .orElse(null);

        float amount = getReservationAmount(selectedFlight.getPrice());

        return reservationDao.storeReservation(flight_id, client_id, passanger_id, amount);
    }

    public float getReservationAmount(float flightPrice){
        return flightPrice *  (1f - 0.1f);
    }

}
