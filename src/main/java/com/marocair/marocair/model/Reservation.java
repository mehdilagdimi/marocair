package com.marocair.marocair.model;

import java.sql.Timestamp;
import java.util.*;

public class Reservation {
    int id;
    int client_id;

    int flight_id;
    Timestamp created_at;
    float amount;

    Flight flight;

    public Reservation () {

    }

    public Reservation(int client_id, int flight_id, Timestamp created_at, float amount) {
        this.client_id = client_id;
        this.flight_id = flight_id;
        this.created_at = created_at;
        this.amount = amount;
    }
    public Reservation(int id, int client_id,  int flight_id, Timestamp created_at, float amount) {
        this.id = id;
        this.client_id = client_id;
        this.flight_id = flight_id;
        this.created_at = created_at;
        this.amount = amount;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }


    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public static Map<String, String> typesToMap () {
        Reservation reservationObj = new Reservation();
        Map<String, String> typesMap = new LinkedHashMap<>();

        typesMap.put("id", ((Object) reservationObj.id).getClass().getSimpleName());
        typesMap.put("client_id", ((Object) reservationObj.client_id).getClass().getSimpleName());
        typesMap.put("flight_id", ((Object) reservationObj.flight_id).getClass().getSimpleName());
        typesMap.put("created_at", ((Object) reservationObj.created_at).getClass().getSimpleName());
        typesMap.put("amount", ((Object) reservationObj.amount).getClass().getSimpleName());
        return typesMap;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", flight_id=" + flight_id +
                ", created_at=" + created_at +
                ", amount=" + amount +
                ", flight=" + flight +
                '}';
    }
}
