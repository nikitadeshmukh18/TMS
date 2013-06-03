package com.sample.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "busStops")
public class StopList {
    @XmlElement(name = "stop")
    private List<BusStop> stopList;

    public StopList() {
    }

    public StopList(List<BusStop> stopList) {
        this.stopList = stopList;
    }
}
