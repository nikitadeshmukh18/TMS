package com.sample.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "busList")
public class BusList {

    @XmlElement(name = "bus")
    private List<Bus> busList;

    public BusList() {
    }

    public BusList(List<Bus> busList) {
        this.busList = busList;
    }
}
