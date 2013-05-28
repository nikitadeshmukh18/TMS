package com.sample.controller;

import com.sample.model.Bus;
import com.sample.model.BusList;
import com.sample.service.BusService;
import com.sample.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/api")
public class ApiController {

    private BusService busService;
    private LoginService loginService;

    public ApiController() {
    }

    @Autowired

    public ApiController(BusService busService,  LoginService loginService) {
        this.busService = busService;
        this.loginService = loginService;
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

    @RequestMapping(value = "/buses", method = RequestMethod.GET)
    public @ResponseBody BusList giveBusList(){

        List<Bus> busList = busService.getAllBuses();
        BusList list = new BusList(busList);
        return list;

    }

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public @ResponseBody void login(@RequestParam("username") String username , @RequestParam("password")String password){

        boolean isValid = loginService.isValidUser(username, password);


        if (isValid) {
            JOptionPane.showMessageDialog(null,"successfull");
        } else {
            JOptionPane.showMessageDialog(null,"Unsuccessfull");
        }

    }

}
