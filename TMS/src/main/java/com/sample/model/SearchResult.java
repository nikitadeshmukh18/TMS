package com.sample.model;


public class SearchResult {

    int busId1;
    int busId2;
    int stopId1;
    int stopId2;
    int stopIndex1;
    int stopIndex2;
    int interMedStopIndex1;
    int interMedStopIndex2;

    public int getInterMedStopIndex2() {
        return interMedStopIndex2;
    }

    public void setInterMedStopIndex2(int interMedStopIndex2) {
        this.interMedStopIndex2 = interMedStopIndex2;
    }

    public int getInterMedStopIndex() {
        return interMedStopIndex1;
    }

    public void setInterMedStopIndex(int interMedStopIndex) {
        this.interMedStopIndex1 = interMedStopIndex;
    }



    public int getBusId1() {
        return busId1;
    }

    public void setBusId1(int busId1) {
        this.busId1 = busId1;
    }

    public int getBusId2() {
        return busId2;
    }

    public void setBusId2(int busId2) {
        this.busId2 = busId2;
    }

    public int getStopId1() {
        return stopId1;
    }

    public void setStopId1(int stopId1) {
        this.stopId1 = stopId1;
    }

    public int getStopId2() {
        return stopId2;
    }

    public void setStopId2(int stopId2) {
        this.stopId2 = stopId2;
    }

    public int getStopIndex1() {
        return stopIndex1;
    }

    public void setStopIndex1(int stopIndex1) {
        this.stopIndex1 = stopIndex1;
    }

    public int getStopIndex2() {
        return stopIndex2;
    }

    public void setStopIndex2(int stopIndex2) {
        this.stopIndex2 = stopIndex2;
    }
}
