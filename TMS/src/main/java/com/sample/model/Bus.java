package com.sample.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Time;

@XmlRootElement
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

    @Column(name = "Start_Time")
    private String startTime;

    @XmlElement
    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    @XmlElement
    public String getBusSource() {
        return busSource;
    }

    public void setBusSource(String busSource) {
        this.busSource = busSource;
    }

    @XmlElement
    public String getBusDestination() {
        return busDestination;
    }

    public void setBusDestination(String busDestination) {
        this.busDestination = busDestination;
    }

    @XmlElement
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @XmlElement
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
