package com.sample.controller;

import com.sample.model.Bus;
import com.sample.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.PrivateKey;
import java.util.List;
import java.util.Map;

@Controller
@Transactional
@RequestMapping("/api")
public class ApiController {

    private BusService busService;

    public ApiController() {
    }

    @Autowired

    public ApiController(BusService busService) {
        this.busService = busService;
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET )
    public @ResponseBody Bus searchBuses(@RequestParam("bus_src") String bus_src,@RequestParam("bus_destination") String bus_destination){

            List<Bus> buses = busService.searchDirectBus(bus_src,bus_destination);
            Bus bus1 = new Bus();
           bus1.setBusNo(1);

        System.out.println("----------------------------busssss api---------------------------" + buses);
        bus1.setBusSource("pune");
        bus1.setBusDestination("mumbai");
        bus1.setRouteId(1);
        bus1.setStartTime("10:00:00");
           return bus1;


    }


}
