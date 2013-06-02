package com.sample.controller;

import com.sample.model.Bus;
import com.sample.model.BusList;
import com.sample.service.BusService;
import com.sample.service.LoginService;
import exceptions.LoginFailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.List;

@Controller
@Transactional

@RequestMapping("/api")
public class ApiController extends ResourceNo {

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
    public @ResponseBody
    ResponseStatus login(@RequestParam("username") String username , @RequestParam("password")String password) throws LoginFailException {

        boolean isValid = loginService.isValidUser(username, password);
        if(!isValid) throw new LoginFailException();

    }

}
