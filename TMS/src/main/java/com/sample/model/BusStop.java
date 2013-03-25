package com.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "BusStop")
public class BusStop {

    @Id @GeneratedValue

    @Column(name = "Stop_Id")
    private int stopId;

    @Column(name = "Stop_Name")
    private int StopName;

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public int getStopName() {
        return StopName;
    }

    public void setStopName(int stopName) {
        StopName = stopName;
    }
}
