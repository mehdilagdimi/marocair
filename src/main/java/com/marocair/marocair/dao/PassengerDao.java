package com.marocair.marocair.dao;

import com.marocair.marocair.base.DaoBuilder;
import com.marocair.marocair.model.Passenger;
import com.marocair.marocair.model.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDao extends DaoBuilder {

        public PassengerDao(){
            table = "passanger";
        }

        public Passenger storePassenger(String fullname, int reservation_id){
            try {
                ResultSet res = this.insert("fullname, reservation_id", fullname, reservation_id).buildReturn().execute();
//
//                Reservation reservationG = new Reservation();
//                reservationG = DBHandler.<Reservation>getParams(res, Reservation::typesToMap, Reservation.class);
                if(res.next()){
                    Passenger passenger = new Passenger(
                            res.getInt("id"),
                            res.getString("fullname"),
                            res.getInt("reservation_id")
                    );

                    return passenger;
                }
            }catch (SQLException e){
//        }catch (SQLException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e){
                e.printStackTrace();
            }
            return null;
        }

}
