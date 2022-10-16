package com.marocair.marocair.model;

import java.sql.Timestamp;

public class Flight {
    private int id;
    private String from;
    private String to;
    private int nbrOfSeats;
    private int availableSeats;
    private Timestamp departTime;
    private Timestamp arrivalTime;
    private float price;

    public Flight() {
    }

    public Flight(int id, String from, String to, int nbrOfSeats, int availableSeats, Timestamp departTime, Timestamp arrivalTime,float price) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.nbrOfSeats = nbrOfSeats;
        this.availableSeats = availableSeats;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Flight(String from, String to, int nbrOfSeats, int availableSeats, Timestamp departTime, Timestamp arrivalTime, float price) {
        this.from = from;
        this.to = to;
        this.nbrOfSeats = nbrOfSeats;
        this.availableSeats = availableSeats;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getNbrOfSeats() {
        return nbrOfSeats;
    }

    public void setNbrOfSeats(int nbrOfSeats) {
        this.nbrOfSeats = nbrOfSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Timestamp getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Timestamp departTime) {
        this.departTime = departTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
