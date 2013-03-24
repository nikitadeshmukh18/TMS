package com.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "BusRoute")
public class BusRoute {

    @Id @GeneratedValue
    @Column(name = "Route_Id")
    private int routeId;

    @Column(name = "Stop1")
    private int stop1;


    @Column(name = "Stop2")
    private int stop2;

    @Column(name = "Stop3")
    private int stop3;

    @Column(name = "Stop4")
    private int stop4;

    @Column(name = "Stop5")
    private int stop5;

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getStop1() {
        return stop1;
    }

    public void setStop1(int stop1) {
        this.stop1 = stop1;
    }

    public int getStop2() {
        return stop2;
    }

    public void setStop2(int stop2) {
        this.stop2 = stop2;
    }

    public int getStop3() {
        return stop3;
    }

    public void setStop3(int stop3) {
        this.stop3 = stop3;
    }

    public int getStop4() {
        return stop4;
    }

    public void setStop4(int stop4) {
        this.stop4 = stop4;
    }

    public int getStop5() {
        return stop5;
    }

    public void setStop5(int stop5) {
        this.stop5 = stop5;
    }
}
