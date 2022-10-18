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

    public List<Reservation> getReservationsByClientId(int client_id){
        List<Reservation> reservations = new ArrayList<>();
        try {
            ResultSet res = this.select("*").where("client_id", "=", client_id).build().execute();

            while (res.next()){
//                Reservation reservationG = new Reservation();
//                reservationG = DBHandler.<Reservation>getParams(res, Reservation::typesToMap, Reservation.class);

                Reservation reservation = new Reservation(
                        res.getInt("id"),
                        res.getInt("client_id"),
                        res.getInt("flight_id"),
                        res.getTimestamp("created_at"),
                        res.getFloat("amount")
                );

                reservations.add(reservation);
            }
            return reservations;
        }catch (SQLException e){
//        }catch (SQLException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e){
            e.printStackTrace();
        }
        return null;
    }

    public Reservation storeReservation(int flight_id, int client_id, float amount){
        try {
            ResultSet res = this.insert("client_id, flight_id, amount", client_id, flight_id, amount).buildReturn().execute();
//
//                Reservation reservationG = new Reservation();
//                reservationG = DBHandler.<Reservation>getParams(res, Reservation::typesToMap, Reservation.class);
                if(res.next()){
                    Reservation reservation = new Reservation(
                            res.getInt("id"),
                            res.getInt("client_id"),
                            res.getInt("flight_id"),
                            res.getTimestamp("created_at"),
                            res.getFloat("amount")
                    );
                    return reservation;
                }
        }catch (SQLException e){
//        }catch (SQLException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e){
            e.printStackTrace();
        }
        return null;
    }

}
