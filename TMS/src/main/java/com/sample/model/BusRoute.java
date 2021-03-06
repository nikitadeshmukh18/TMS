package com.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "Route")
public class BusRoute {

    @Id
    @Column(name = "Route_Id")
    private int routeId;

    @Column(name = "Stop_Index")
    private int stopIndex;


    @Column(name = "Stop_Id")
    private int stopId;

    @Column(name = "Time_Taken")
    private String timeTaken;

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(int stopIndex) {
        this.stopIndex = stopIndex;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }
}
