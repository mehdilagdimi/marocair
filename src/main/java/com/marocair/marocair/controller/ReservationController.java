package com.marocair.marocair.controller;

import com.marocair.marocair.dao.ReservationDao;
import com.marocair.marocair.model.Reservation;

import java.util.List;

public class ReservationController {


    //GET CLIENT RESERVATION BY HIS ID
    public List<Reservation> getClientReservation(int id) {
        return new ReservationDao().getReservationsById(id);
    }

//    public Reservation storeReservation(int flight_id, int client_id, int passanger_id, float amount){
//
//    }
}
