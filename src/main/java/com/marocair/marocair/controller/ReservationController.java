package com.marocair.marocair.controller;

import com.marocair.marocair.dao.ReservationDao;
import com.marocair.marocair.model.Reservation;

import java.util.List;

public class ReservationController {


    //GET CLIENT RESERVATION BY HIS ID
    public List<Reservation> getClientReservation(int id) {
        return new ReservationDao().getReservationsById(id);
    }
}
