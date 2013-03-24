package com.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "Bus")
public class Bus {

    @Id @GeneratedValue

    @Column(name = "Bus_No")
    private int busNo;

    @Column(name = "Bus_Source")
    private String busSource;

    @Column(name = "Bus_Destination")
    private String busDestination;

    @Column(name = "Route_Id")
    private int routeId;

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public String getBusSource() {
        return busSource;
    }

    public void setBusSource(String busSource) {
        this.busSource = busSource;
    }

    public String getBusDestination() {
        return busDestination;
    }

    public void setBusDestination(String busDestination) {
        this.busDestination = busDestination;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }
}
