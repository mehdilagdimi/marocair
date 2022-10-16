package com.marocair.marocair.dao;

import com.marocair.marocair.base.DaoBuilder;
import com.marocair.marocair.model.Reservation;
import com.marocair.marocair.util.DB.DBHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDao extends DaoBuilder {
    public ReservationDao (){
        table = "reservation";
    }

    public List<Reservation> getReservationsById(int id){
        List<Reservation> reservations = new ArrayList<>();
        try {
            ResultSet res = this.select("*").build().execute();
//

            while (res.next()){
                Reservation reservationG = new Reservation();
                reservationG = DBHandler.<Reservation>getParams(res, Reservation::typesToMap, Reservation.class);

                Reservation reservation = new Reservation(
                        res.getInt("id"),
                        res.getInt("client_id"),
                        res.getInt("passanger_id"),
                        res.getInt("flight_id"),
                        res.getTimestamp("created_at"),
                        res.getFloat("amount")
                );

                reservations.add(reservation);
            }
            return reservations;
        }catch (SQLException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e){
            e.printStackTrace();
        }
        return null;
    }

}
