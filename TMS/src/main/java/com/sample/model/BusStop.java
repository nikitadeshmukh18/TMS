package com.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "BusStop")
public class BusStop {

    @Id @GeneratedValue

    @Column(name = "Stop_Id")
    private int stopId;

    @Column(name = "Stop_Name")
    private String stopName;

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }
}
