package com.sample.model;


import javax.persistence.Column;
import javax.persistence.Id;

public class RouteStops {


    private int stopIndex;
    private String stopName;
    private String stopTime;
    public int getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(int stopIndex) {
        this.stopIndex = stopIndex;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }
    public String getStopTime()
    {
        return stopTime;
    }
    public void setStopTime(String stopTime)
    {
        this.stopTime=stopTime;
    }
}