package com.marocair.marocair.model;

public class Passenger {

    private int id;
    private String fullname;
    private int reservation_id;

    public Passenger(){

    }
    public Passenger(int id, String fullname, int reservation_id) {
        this.id = id;
        this.fullname = fullname;
        this.reservation_id = reservation_id;
    }

    public Passenger(String fullname, int reservation_id) {
        this.fullname = fullname;
        this.reservation_id = reservation_id;
    }

    public String getFullname() {
        return fullname;
    }


    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }


}
